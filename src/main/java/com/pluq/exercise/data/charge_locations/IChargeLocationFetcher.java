package com.pluq.exercise.data.charge_locations;

import com.pluq.exercise.domain.ChargeLocation;

import java.util.Collection;

public interface IChargeLocationFetcher {
    Collection<ChargeLocation> fetchLocations();
}
