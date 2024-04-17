package com.pluq.exercise.service;

import com.pluq.exercise.domain.ChargeLocation;

import java.util.Collection;

public interface IChargeLocationService {
    Collection<ChargeLocation> fetchLocations();
}
