package com.pluq.exercise.service;

import com.pluq.exercise.domain.ChargeLocation;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ILocationService {
    Collection<ChargeLocation> getLocations();
}
