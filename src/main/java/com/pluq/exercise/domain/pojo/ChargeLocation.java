package com.pluq.exercise.domain.pojo;

import com.pluq.exercise.Constants;
import com.pluq.exercise.domain.LocationType;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Document("charge_poles")
public class ChargeLocation {
    @Getter @Id private String id;
    @Getter private LocationType type;
    @Getter private String address;
    @Getter private String city;
    @Getter private String postal_code;
    @Getter private String country;
    @Getter private String name;
    @Getter private LocationCoordinates coordinates;
    @Getter private boolean charging_when_closed;
    @Getter @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) private Date last_updated;
    @Getter private final Collection<ChargePole> evses = new HashSet<>();

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
                          Collection<ChargePole> evses) {
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
