package com.pluq.exercise.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pluq.exercise.api.TechnicalExerciseApplication;
import com.pluq.exercise.domain.ChargeLocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class GsonChargeLocationService implements IChargeLocationService {
    @Autowired
    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'")
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();

    @Override
    public Collection<ChargeLocation> fetchLocations() {
        Collection<ChargeLocation> locations = new HashSet<>();
        URL url = TechnicalExerciseApplication.class.getClassLoader().getResource("locations.json");
        if (url == null) throw new RuntimeException("locations.json was referenced, but it does not exist!");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(url.toURI()), StandardCharsets.UTF_8))){
            ChargeLocation[] collectedLocations = gson.fromJson(reader, ChargeLocation[].class);
            locations.addAll(Arrays.asList(collectedLocations));
        } catch (IOException | URISyntaxException exception){
            exception.printStackTrace();
        }
        return locations;
    }
}
