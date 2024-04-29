package com.pluq.exercise.domain.pojo;

import com.pluq.exercise.Constants;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document("energy_prices")
public class EnergyPrice {
    @Getter private String id;
    @Getter private String country;
    @Getter private double price;
    @Getter private String buyVolume;
    @Getter private String sellVolume;
    @Getter private String currency;
    @Getter private String unit;
    @Getter @DateTimeFormat(pattern = Constants.DATE_FORMAT) private Date date;
    @Getter private int timeSlot;

    public EnergyPrice(){}

    public EnergyPrice(String id,
                       String country,
                       double price,
                       String buyVolume,
                       String sellVolume,
                       String currency,
                       String unit,
                       Date date,
                       int timeSlot){
        this.id = id;
        this.country = country;
        this.buyVolume = buyVolume;
        this.sellVolume = sellVolume;
        this.currency = currency;
        this.unit = unit;
        this.date = date;
        this.timeSlot = timeSlot;
    }
}
