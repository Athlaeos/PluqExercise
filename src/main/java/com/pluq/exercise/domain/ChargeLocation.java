package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ChargeLocation {
    @Getter private final long id;
    @Getter private final LocationType type;
    @Getter private final String address;
    @Getter private final String city;
    @Getter private final String postal_code;
    @Getter private final String country;
    @Getter private final String name;
    @Getter private final LocationCoordinates coordinates;
    @Getter private final boolean charging_when_closed;
    @Getter @Setter private Date last_updated;
    @Getter private final Collection<ChargePole> evses = new HashSet<>();

    public ChargeLocation(long id,
                          LocationType locationType,
                          String address,
                          String city,
                          String postal_code,
                          String country,
                          String name,
                          LocationCoordinates coordinates,
                          boolean charging_when_closed,
                          Date last_updated,
                          Collection<ChargePole> evses){
        this.id = id;
        this.type = locationType;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.country = country;
        this.name = name;
        this.coordinates = coordinates;
        this.charging_when_closed = charging_when_closed;
        this.last_updated = last_updated;
        this.evses.addAll(evses);
    }
}
