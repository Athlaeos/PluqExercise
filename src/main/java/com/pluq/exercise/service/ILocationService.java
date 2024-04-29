package com.pluq.exercise.service;

import com.pluq.exercise.domain.pojo.ChargeLocation;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ILocationService {
    ChargeLocation get(String id);

    Collection<ChargeLocation> getLocations();

    void addOrUpdateLocation(ChargeLocation location);

    void removeLocation(String id);
}
