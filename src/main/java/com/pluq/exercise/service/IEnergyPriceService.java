package com.pluq.exercise.service;

import com.pluq.exercise.domain.pojo.EnergyPrice;
import com.pluq.exercise.domain.pojo.MeterValue;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IEnergyPriceService {
    Collection<EnergyPrice> getPrices();

    void addOrUpdatePrice(EnergyPrice price);

    void removePrice(String id);

    float getEnergyPriceOverTime(String country, Collection<MeterValue> recordings);
}
