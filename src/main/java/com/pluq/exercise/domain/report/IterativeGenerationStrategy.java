package com.pluq.exercise.domain.report;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.pojo.ChargePole;
import com.pluq.exercise.domain.pojo.ChargePoleConnector;
import com.pluq.exercise.domain.pojo.MeterValue;
import com.pluq.exercise.service.IEnergyPriceService;
import com.pluq.exercise.service.IMeterValueService;
import org.springframework.beans.factory.annotation.Autowired;

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
        Map<String, Float> chargedBySocket = new HashMap<>();
        Map<String, Float> chargedBySession = new HashMap<>();
        Map<String, Map<Date, Float>> chargedPerDayPerSocket = new HashMap<>();

        for (ChargePole pole : location.getEvses()){
            Map<String, MeterValue> poleMeterValues = meterValueService.getByChargingPole(pole);

            for (ChargePoleConnector connector : pole.getConnectors()){
                String physicalReference = String.format("%s*%s", pole.getPhysical_reference(), connector.getId());
            }
            totalRevenue += energyPriceService.getEnergyPriceOverTime(location.getCountry(), poleMeterValues);
            for (MeterValue value : poleMeterValues){
                float existingSocketValue = chargedBySocket.getOrDefault(value.getPhysicalReference(), 0F);
                float existingSessionValue = chargedBySession.getOrDefault(value.getTransactionId(), 0F);
                Map<Date, Float> chargedPerDayValue = chargedPerDayPerSocket.getOrDefault(value.getPhysicalReference(), new HashMap<>());

            }
        }
        return null;
    }
}
