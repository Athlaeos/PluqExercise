package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ChargePole {
    @Getter private String uid;
    @Getter private String evse_uid;
    @Getter private ChargePoleStatus status;
    @Getter @Setter @BsonProperty("last_updated") private Date lastUpdated;
    @Getter private final Collection<ChargePoleCapability> capabilities = new HashSet<>();
    @Getter @BsonProperty("physical_reference") private String physicalReference;

    public ChargePole(){}

    public ChargePole(String uid,
                      String evse_uid,
                      ChargePoleStatus status,
                      Date last_updated,
                      String physical_reference,
                      Collection<ChargePoleCapability> capabilities){
        this.uid = uid;
        this.evse_uid = evse_uid;
        this.status = status;
        this.lastUpdated = last_updated;
        this.physicalReference = physical_reference;
        this.capabilities.addAll(capabilities);
    }
}
