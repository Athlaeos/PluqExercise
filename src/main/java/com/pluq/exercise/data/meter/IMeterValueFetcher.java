package com.pluq.exercise.data.meter;

import com.pluq.exercise.domain.MeterValue;

import java.util.Collection;

public interface IMeterValueFetcher {
    Collection<MeterValue> fetchMeterValues();
}
