package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;

public class ChargePoleConnector {
    @Getter private String id;
    @Getter private String standard;
    @Getter private String format;
    @Getter @BsonProperty("power_type") private ChargingPowerType chargingPowerType;
    @Getter private int voltage;
    @Getter private int amperage;
    @Getter @Setter @BsonProperty("last_updated") private Date lastUpdated;
    @Getter @BsonProperty("tariff_id") private String tariffId;

    public ChargePoleConnector(){}

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
        this.chargingPowerType = power_type;
        this.voltage = voltage;
        this.amperage = amperage;
        this.lastUpdated = last_updated;
        this.tariffId = tariff_id;
    }
}
