package com.pluq.exercise.data.converters;

import com.pluq.exercise.Constants;
import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateToStringConverter implements Converter<ZonedDateTime, String> {
    @SneakyThrows
    @Override
    public String convert(ZonedDateTime source) {
        return DateTimeFormatter.ofPattern(Constants.DATE_TIME_FORMAT).format(source);
    }
}
