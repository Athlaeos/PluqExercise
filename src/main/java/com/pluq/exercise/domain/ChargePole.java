package com.pluq.exercise.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class ChargePole {
    @Getter private final String uid;
    @Getter private final String evse_uid;
    @Getter private final ChargePoleStatus status;
    @Getter @Setter private Date last_updated;
    @Getter private final Collection<ChargePoleCapability> capabilities = new HashSet<>();
    @Getter private final String physical_reference;

    public ChargePole(String uid,
                      String evse_uid,
                      ChargePoleStatus status,
                      Date last_updated,
                      String physical_reference,
                      Collection<ChargePoleCapability> capabilities){
        this.uid = uid;
        this.evse_uid = evse_uid;
        this.status = status;
        this.last_updated = last_updated;
        this.physical_reference = physical_reference;
        this.capabilities.addAll(capabilities);
    }
}
