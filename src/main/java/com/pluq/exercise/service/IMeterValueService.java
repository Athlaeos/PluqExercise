package com.pluq.exercise.service;

import com.pluq.exercise.domain.MeterValue;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IMeterValueService {
    Collection<MeterValue> getMeterValues();
}
