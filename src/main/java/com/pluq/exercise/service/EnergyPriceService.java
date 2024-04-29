package com.pluq.exercise.service;

import com.pluq.exercise.data.energy_prices.MongoEnergyPriceRepository;
import com.pluq.exercise.domain.pojo.EnergyPrice;
import com.pluq.exercise.domain.pojo.MeterValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;

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

    @Override
    public float getEnergyPriceOverTime(String country, Collection<MeterValue> recordings) {
        return 0;
    }
}
