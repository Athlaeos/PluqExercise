package com.pluq.exercise.domain.pojo;

import com.pluq.exercise.Constants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document("meter_values")
public class MeterValue {
    @Getter private String transactionId;
    @Getter private String physicalReference;
    @Getter @Setter private float meterValue;
    @Getter @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) private Date date;
    @Getter @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT) private Date dateAdded;

    public MeterValue(){}

    public MeterValue(String transactionId, String physicalReference, float meterValue, Date date, Date dateAdded){
        this.transactionId = transactionId;
        this.physicalReference = physicalReference;
        this.meterValue = meterValue;
        this.date = date;
        this.dateAdded = dateAdded;
    }

    public int getSocket(){
        String[] args = physicalReference.split("[*]");
        if (args.length != 2) return -1;
        return Integer.parseInt(args[1]);
    }
}
