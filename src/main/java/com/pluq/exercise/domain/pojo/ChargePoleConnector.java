package com.pluq.exercise.domain.pojo;

import com.pluq.exercise.Constants;
import com.pluq.exercise.domain.ChargingPowerType;
import lombok.Getter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

public class ChargePoleConnector {
    @Getter @BsonProperty private String id;
    @Getter @BsonProperty private String standard;
    @Getter @BsonProperty private String format;
    @Getter @BsonProperty("power_type") private ChargingPowerType chargingPowerType;
    @Getter @BsonProperty private int voltage;
    @Getter @BsonProperty private int amperage;
    @Getter @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) private Date last_updated;
    @Getter private String tariff_id;

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
        this.last_updated = last_updated;
        this.tariff_id = tariff_id;
    }
}
