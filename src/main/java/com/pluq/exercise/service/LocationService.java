package com.pluq.exercise.service;

import com.pluq.exercise.data.charge_locations.IChargeLocationFetcher;
import com.pluq.exercise.domain.ChargeLocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class LocationService implements ILocationService {
    private final IChargeLocationFetcher locationFetcher;

    @Autowired
    public LocationService(IChargeLocationFetcher locationFetcher){
        this.locationFetcher = locationFetcher;
    }

    @Override
    public Collection<ChargeLocation> getLocations() {
        return locationFetcher.fetchLocations();
    }
}
