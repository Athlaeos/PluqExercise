package com.pluq.exercise;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constants {
    public static final String DATE_TIME_FORMAT = "yyyy'-'MM'-'dd'T'HH':'mm':'ss'Z'";
    public static final SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT, Locale.ENGLISH);
    public static final String DATE_FORMAT = "yyyy'-'MM'-'dd";
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH);
}
