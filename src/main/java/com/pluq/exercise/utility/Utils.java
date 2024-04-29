package com.pluq.exercise.utility;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Utils {
    public static <T> Map<String, Collection<T>> mapByStringValue(Collection<T> collection, StringGetter<T> getter){
        Map<String, Collection<T>> mapped = new HashMap<>();
        for (T t : collection){
            Collection<T> existingValues = mapped.getOrDefault(getter.get(t), new HashSet<>());
            existingValues.add(t);
            mapped.put(getter.get(t), existingValues);
        }
        return mapped;
    }
}
