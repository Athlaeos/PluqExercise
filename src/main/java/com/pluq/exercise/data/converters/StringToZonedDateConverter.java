package com.pluq.exercise.data.converters;

import com.pluq.exercise.Constants;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToZonedDateConverter implements Converter<String, ZonedDateTime> {
    @SneakyThrows
    @Override
    public ZonedDateTime convert(String source) {
        return ZonedDateTime.parse(source, DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT));
    }
}
