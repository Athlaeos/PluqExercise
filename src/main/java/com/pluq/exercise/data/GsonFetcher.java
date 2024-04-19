package com.pluq.exercise.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pluq.exercise.TechnicalExerciseApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import static com.pluq.exercise.Constants.DATE_FORMAT;

public class GsonFetcher <T> {
    @Autowired
    private final Gson gson = new GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();

    private final Class<T[]> clazz;
    public GsonFetcher(Class<T[]> clazz){
        this.clazz = clazz;
    }

    public Collection<T> getFromFile(String fileName) {
        Collection<T> values = new HashSet<>();
        URL url = TechnicalExerciseApplication.class.getClassLoader().getResource(fileName);
        if (url == null) throw new RuntimeException(fileName + " was referenced, but it does not exist!");
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(url.toURI()), StandardCharsets.UTF_8))){
            T[] collectedValues = gson.fromJson(reader, clazz);
            values.addAll(Arrays.asList(collectedValues));
        } catch (IOException | URISyntaxException exception){
            exception.printStackTrace();
        }
        return values;
    }
}
