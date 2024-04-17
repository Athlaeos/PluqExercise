package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ChargePoleConnector {
    @Getter private final String id;
    @Getter private final String standard;
    @Getter private final String format;
    @Getter private final ChargingPowerType power_type;
    @Getter private final int voltage;
    @Getter private final int amperage;
    @Getter @Setter private Date last_updated;
    @Getter private final String tariff_id;

    public ChargePoleConnector(String id,
                               String standard,
                               String format,
                               ChargingPowerType power_type,
                               int voltage,
                               int amperage,
                               Date last_updated,
                               String tariff_id){
        this.id = id;
        this.standard = standard;
        this.format = format;
        this.power_type = power_type;
        this.voltage = voltage;
        this.amperage = amperage;
        this.last_updated = last_updated;
        this.tariff_id = tariff_id;
    }
}
