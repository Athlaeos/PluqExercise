package com.pluq.exercise.service;

import com.pluq.exercise.data.charge_locations.MongoChargeLocationRepository;
import com.pluq.exercise.domain.pojo.ChargeLocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashSet;

public class LocationService implements ILocationService {
    @Autowired
    private MongoChargeLocationRepository locationRepository;

    @Override
    public ChargeLocation get(String id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<ChargeLocation> getLocations() {
        return new HashSet<>(locationRepository.findAll());
    }

    @Override
    public void addOrUpdateLocation(ChargeLocation location) {
        locationRepository.deleteById(location.getId());
        locationRepository.insert(location);
    }

    @Override
    public void removeLocation(String id) {
        locationRepository.deleteById(id);
    }
}
