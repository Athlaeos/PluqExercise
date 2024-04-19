package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ChargeLocation {
    @Getter private String id;
    @Getter private LocationType type;
    @Getter private String address;
    @Getter private String city;
    @Getter @BsonProperty("postal_code") private String postalCode;
    @Getter private String country;
    @Getter private String name;
    @Getter private LocationCoordinates coordinates;
    @Getter @BsonProperty("charging_when_closed") private boolean chargingWhenClosed;
    @Getter @Setter @BsonProperty("last_updated") private Date lastUpdated;
    @Getter @BsonProperty("evses") private final Collection<ChargePole> chargePoles = new HashSet<>();

    public ChargeLocation(){}

    public ChargeLocation(String id,
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
        this.postalCode = postal_code;
        this.country = country;
        this.name = name;
        this.coordinates = coordinates;
        this.chargingWhenClosed = charging_when_closed;
        this.lastUpdated = last_updated;
        this.chargePoles.addAll(evses);
    }
}
