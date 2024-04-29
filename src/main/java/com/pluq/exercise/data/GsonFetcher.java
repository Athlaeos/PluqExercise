package com.pluq.exercise.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.pluq.exercise.TechnicalExerciseApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

import static com.pluq.exercise.Constants.DATE_TIME_FORMAT;

public class GsonFetcher <T> {
    @Autowired
    private final Gson gson = new GsonBuilder()
            .setDateFormat(DATE_TIME_FORMAT)
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

    public void removeFromFile(String fileName, Predicate<T> removalCondition){
        Collection<T> values = getFromFile(fileName);
        values.forEach(v -> System.out.println(gson.toJson(v)));
        values.removeIf(removalCondition);
        saveToFile(fileName, values);
    }

    public void addToFile(String fileName, T element){
        Collection<T> values = getFromFile(fileName);
        values.add(element);
        saveToFile(fileName, values);
    }

    public Collection<T> findFromFile(String fileName, Predicate<T> filter){
        Collection<T> matches = new HashSet<>();
        for (T element : getFromFile(fileName)){
            if (filter.test(element)) matches.add(element);
        }
        return matches;
    }

    public void saveToFile(String fileName, Collection<T> elements){
        URL url = TechnicalExerciseApplication.class.getClassLoader().getResource(fileName);
        if (url == null) throw new RuntimeException(fileName + " was referenced, but it does not exist!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(url.toURI()), StandardCharsets.UTF_8))){
            JsonElement element = gson.toJsonTree(new ArrayList<>(elements), new TypeToken<ArrayList<T>>(){}.getType());
            gson.toJson(element, writer);
        } catch (IOException | URISyntaxException exception){
            exception.printStackTrace();
        }
    }
}
