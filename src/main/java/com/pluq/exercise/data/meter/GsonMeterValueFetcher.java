package com.pluq.exercise.data.meter;

import com.pluq.exercise.data.GsonFetcher;
import com.pluq.exercise.domain.MeterValue;

import java.util.Collection;

public class GsonMeterValueFetcher implements IMeterValueFetcher {
    private final GsonFetcher<MeterValue> fetcher = new GsonFetcher<>(MeterValue[].class);

    @Override
    public Collection<MeterValue> fetchMeterValues() {
        return fetcher.getFromFile("meterValues.json");
    }
}
