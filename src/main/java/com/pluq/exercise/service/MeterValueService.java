package com.pluq.exercise.service;

import com.pluq.exercise.data.meter.MongoMeterValueRepository;
import com.pluq.exercise.domain.pojo.ChargeLocation;
import com.pluq.exercise.domain.pojo.ChargePole;
import com.pluq.exercise.domain.pojo.MeterValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class MeterValueService implements IMeterValueService {
    @Autowired
    private MongoMeterValueRepository meterValueRepository;

    @Override
    public Collection<MeterValue> getMeterValues() {
        return new HashSet<>(meterValueRepository.findAll());
    }

    @Override
    public Collection<MeterValue> getByLocation(ChargeLocation location) {
        Collection<MeterValue> valuesByLocation = new HashSet<>();
        location.getEvses().forEach(p -> valuesByLocation.addAll(getByChargingPole(p).values()));
        return valuesByLocation;
    }

    @Override
    public Map<String, MeterValue> getByChargingPole(ChargePole pole) {
        return meterValueRepository.findByPhysicalReference(pole.getPhysical_reference()).stream()
                .collect(Collectors.toMap(MeterValue::getPhysicalReference, v -> v));
    }

    @Override
    public Collection<MeterValue> getByTransactionId(String transactionId) {
        return meterValueRepository.findByTransactionId(transactionId);
    }
}
