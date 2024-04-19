package com.pluq.exercise.service;

import com.pluq.exercise.data.meter.IMeterValueFetcher;
import com.pluq.exercise.domain.MeterValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class MeterValueService implements IMeterValueService {
    private final IMeterValueFetcher meterValueFetcher;

    @Autowired
    public MeterValueService(IMeterValueFetcher meterValueFetcher){
        this.meterValueFetcher = meterValueFetcher;
    }

    @Override
    public Collection<MeterValue> getMeterValues() {
        return meterValueFetcher.fetchMeterValues();
    }
}
