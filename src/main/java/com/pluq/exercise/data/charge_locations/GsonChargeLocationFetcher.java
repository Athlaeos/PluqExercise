package com.pluq.exercise.data.charge_locations;

import com.pluq.exercise.data.GsonFetcher;
import com.pluq.exercise.domain.ChargeLocation;

import java.util.Collection;

public class GsonChargeLocationFetcher implements IChargeLocationFetcher {
    private final GsonFetcher<ChargeLocation> fetcher = new GsonFetcher<>(ChargeLocation[].class);

    @Override
    public Collection<ChargeLocation> fetchLocations() {
        return fetcher.getFromFile("locations.json");
    }
}
