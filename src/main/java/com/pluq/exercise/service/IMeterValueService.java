package com.pluq.exercise.service;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.pojo.ChargePole;
import com.pluq.exercise.domain.pojo.MeterValue;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public interface IMeterValueService {
    Collection<MeterValue> getMeterValues();

    Collection<MeterValue> getByLocation(ChargeLocation location);

    Map<String, MeterValue> getByChargingPole(ChargePole pole);

    Collection<MeterValue> getByTransactionId(String transactionId);
}
