package com.pluq.exercise.service;

import com.pluq.exercise.data.energy_prices.MongoEnergyPriceRepository;
import com.pluq.exercise.domain.pojo.EnergyPrice;
import com.pluq.exercise.domain.pojo.MeterValue;
import com.pluq.exercise.utility.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.*;

public class EnergyPriceService implements IEnergyPriceService {
    @Autowired
    private MongoEnergyPriceRepository priceRepository;

    @Override
    public Collection<EnergyPrice> getPrices() {
        return new HashSet<>(priceRepository.findAll());
    }

    @Override
    public void addOrUpdatePrice(EnergyPrice location) {
        priceRepository.deleteById(location.getId());
        priceRepository.insert(location);
    }

    @Override
    public void removePrice(String id) {
        priceRepository.deleteById(id);
    }

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public EnergyPrice priceForDateTime(String country, Date date) {
        Collection<EnergyPrice> pricesForDate = priceRepository.pricesForDateHour(format.format(date), date.getHours()); // for the sake of simplicity, I'm ignoring time zones here
        return pricesForDate.stream().filter(p -> p.getCountry().equals(country)).findFirst().orElse(null);
    }

    @Override
    public float getEnergyPriceOverTime(String country, Collection<MeterValue> recordings) {
        // I'm aware this is not a perfect method. I assume a MeterValue is recorded the moment someone starts using the socket

        Map<String, Collection<MeterValue>> mappedByPhysicalReference = Utils.mapByStringValue(recordings, MeterValue::getPhysicalReference);
        float totalPrice = 0F;
        for (String reference : mappedByPhysicalReference.keySet()){
            List<MeterValue> values = new ArrayList<>(mappedByPhysicalReference.get(reference));
            values.sort(Comparator.comparingLong(v -> v.getDate().getTime()));
            for (int i = 0; i < values.size(); i++){
                EnergyPrice matchingPrice = priceForDateTime(country, values.get(i).getDate());
                if (matchingPrice == null) continue;
                float charged = (i == 0 ? 0 : values.get(i).getMeterValue() - values.get(i - 1).getMeterValue());
                float cost = (float) (charged * matchingPrice.getPrice() * 0.25F); // magic number, 0.25 of an hour is 15 minutes which is the time period between meter value recordings.
                totalPrice += cost;
            }
        }
        return totalPrice;
    }
}
