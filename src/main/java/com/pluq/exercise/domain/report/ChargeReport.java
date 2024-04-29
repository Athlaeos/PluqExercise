package com.pluq.exercise.domain.report;

import lombok.Getter;

import java.util.Date;
import java.util.Map;

public class ChargeReport {
    @Getter private final String location;
    @Getter private final float kWhCharged;
    @Getter private final Map<String, Double> sockets; // map where string key represents socket ID, and float value represents kWh charged with that socket
    @Getter private final Map<String, Double> sessions; // map where string key represents session ID, and float value represents kWh charged during that session
    @Getter private final Map<String, Map<String, Double>> kWhPerDayPerSocket; // map where string key represents socket ID, and value is a map where its key is the date and value the amount charged on that day
    @Getter private final float totalRevenue;

    public ChargeReport(String location,
                        float kWhCharged,
                        Map<String, Double> sockets,
                        Map<String, Double> sessions,
                        Map<String, Map<String, Double>> kWhPerDayPerSocket,
                        float totalRevenue) {
        this.location = location;
        this.kWhCharged = kWhCharged;
        this.sockets = sockets;
        this.sessions = sessions;
        this.kWhPerDayPerSocket = kWhPerDayPerSocket;
        this.totalRevenue = totalRevenue;
    }
}
