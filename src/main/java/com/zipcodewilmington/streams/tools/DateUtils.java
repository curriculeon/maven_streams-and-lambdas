package com.zipcodewilmington.streams.tools;

import java.time.*;
import java.util.Date;

/**
 * Created by leon on 5/1/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public final class DateUtils {
    private DateUtils() {
        /** this class is uninstantiable */
    }

    /**
     * @param localDate LocalDate object to convert
     * @return respective Date-object-representation
     */
    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param localDateTime LocalDateTime object to convert
     * @return respective Date-object-representation
     */
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * @param date Date object to convert
     * @return respective LocalDate-object-representation
     */
    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * @param date Date object to convert
     * @return respective LocalDateTime-object-representation
     */
    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * @param startDate starting Date object
     * @param endDate ending Date object
     * @return integer difference between the two Date arguments
     */
    public static int yearsBetween(Date startDate, Date endDate) {
        return yearsBetween(DateUtils.asLocalDate(startDate), DateUtils.asLocalDate(endDate));
    }

    /**
     * @param startDate starting Date object
     * @param endDate ending LocalDate object
     * @return integer difference between the two Date arguments
     */
    public static int yearsBetween(Date startDate, LocalDate endDate) {
        return yearsBetween(DateUtils.asLocalDate(startDate), endDate);
    }

    /**
     * @param startDate starting LocalDate object
     * @param endDate ending LocalDate object
     * @return integer difference between the two Date arguments
     */
    public static int yearsBetween(LocalDate startDate, LocalDate endDate) {
        return Period.between(startDate, endDate).getYears();
    }
}