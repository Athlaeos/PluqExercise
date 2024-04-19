package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class MeterValue {
    @Getter private String transactionId;
    @Getter private String physicalReference;
    @Getter @Setter private float meterValue;
    @Getter private Date date;
    @Getter private Date dateAdded;

    public MeterValue(){}

    public MeterValue(String transactionId, String physicalReference, float meterValue, Date date, Date dateAdded){
        this.transactionId = transactionId;
        this.physicalReference = physicalReference;
        this.meterValue = meterValue;
        this.date = date;
        this.dateAdded = dateAdded;
    }
}
