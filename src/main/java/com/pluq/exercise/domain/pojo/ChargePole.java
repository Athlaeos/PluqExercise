package com.pluq.exercise.domain.pojo;

import com.pluq.exercise.Constants;
import com.pluq.exercise.domain.ChargePoleCapability;
import com.pluq.exercise.domain.ChargePoleStatus;
import lombok.Getter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ChargePole {
    @Getter private String uid;
    @Getter private String evse_uid;
    @Getter private ChargePoleStatus status;
    @Getter @DateTimeFormat(pattern = Constants.DATE_TIME_FORMAT)  private Date last_updated;
    @Getter private final Collection<ChargePoleCapability> capabilities = new HashSet<>();
    @Getter private Collection<ChargePoleConnector> connectors;
    @Getter private String physical_reference;

    public ChargePole(){}

    public ChargePole(String uid,
                      String evse_uid,
                      ChargePoleStatus status,
                      Date last_updated,
                      String physical_reference,
                      Collection<ChargePoleConnector> connectors,
                      Collection<ChargePoleCapability> capabilities){
        this.uid = uid;
        this.evse_uid = evse_uid;
        this.status = status;
        this.last_updated = last_updated;
        this.connectors = connectors;
        this.physical_reference = physical_reference;
        this.capabilities.addAll(capabilities);
    }
}
