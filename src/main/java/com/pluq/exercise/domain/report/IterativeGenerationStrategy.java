package com.pluq.exercise.domain.report;

import com.pluq.exercise.Constants;
import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.pojo.ChargePole;
import com.pluq.exercise.domain.pojo.MeterValue;
import com.pluq.exercise.service.IEnergyPriceService;
import com.pluq.exercise.service.IMeterValueService;
import com.pluq.exercise.utility.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.*;

public class IterativeGenerationStrategy implements ReportGenerationStrategy{
    @Autowired
    private IMeterValueService meterValueService;

    @Autowired
    private IEnergyPriceService energyPriceService;

    @Override
    public ChargeReport generate(ChargeLocation location) {
        float totalKwhCharged = 0;
        float totalRevenue = 0;
        Map<String, Double> chargedBySocket = new HashMap<>();
        Map<String, Double> chargedBySession = new HashMap<>();
        Map<String, Map<String, Double>> chargedPerDayPerSocket = new HashMap<>();

        for (ChargePole pole : location.getEvses()){
            // all meter values associated to this charging pole, mapped by physical reference so each socket is separate
            Map<String, Collection<MeterValue>> poleMeterValues = Utils.mapByStringValue(meterValueService.getByChargingPole(pole), MeterValue::getPhysicalReference);

            for (String socket : poleMeterValues.keySet()){
                Collection<MeterValue> socketMeterValues = poleMeterValues.getOrDefault(socket, new HashSet<>());
                totalRevenue += energyPriceService.getEnergyPriceOverTime(location.getCountry(), socketMeterValues);

                double totalSocketCharged = socketMeterValues.stream().mapToDouble(MeterValue::getMeterValue).max().orElse(0);
                chargedBySocket.put(socket, totalSocketCharged);

                for (MeterValue value : socketMeterValues){
                    if (!chargedBySession.containsKey(value.getTransactionId())) {
                        double valueBeforeSession = socketMeterValues.stream()
                                .filter(v -> v.getTransactionId().equals(value.getTransactionId()))
                                .mapToDouble(MeterValue::getMeterValue).min().orElse(0);
                        double valueAfterSession = socketMeterValues.stream()
                                .filter(v -> v.getTransactionId().equals(value.getTransactionId()))
                                .mapToDouble(MeterValue::getMeterValue).max().orElse(0);
                        double sessionCharged = valueAfterSession - valueBeforeSession;
                        chargedBySession.put(value.getTransactionId(), sessionCharged);
                    } // session was already calculated, does not need to be done again
                    String formattedDate = Constants.SIMPLE_DATE_FORMAT.format(value.getDate());
                    Map<String, Double> chargedPerDayValue = chargedPerDayPerSocket.getOrDefault(value.getPhysicalReference(), new HashMap<>());
                    if (!chargedPerDayValue.containsKey(formattedDate)){
                        double valueStartOfDay = socketMeterValues.stream()
                                .filter(v -> Constants.SIMPLE_DATE_FORMAT.format(v.getDate()).equals(formattedDate))
                                .mapToDouble(MeterValue::getMeterValue).min().orElse(0);
                        double valueEndOfDay = socketMeterValues.stream()
                                .filter(v -> Constants.SIMPLE_DATE_FORMAT.format(v.getDate()).equals(formattedDate))
                                .mapToDouble(MeterValue::getMeterValue).max().orElse(0);
                        double chargedDuringDay = valueEndOfDay - valueStartOfDay;
                        chargedPerDayValue.put(formattedDate, chargedDuringDay);
                        chargedPerDayPerSocket.put(socket, chargedPerDayValue);

                        totalKwhCharged += chargedDuringDay;
                    }
                }
            }
        }
        return new ChargeReport(location.getName(), totalKwhCharged, chargedBySocket, chargedBySession, chargedPerDayPerSocket, totalRevenue);
    }

    private String toSimpleFormat(Date complexDate) throws ParseException {
        return Constants.SIMPLE_DATE_FORMAT.format(complexDate);
    }
}
