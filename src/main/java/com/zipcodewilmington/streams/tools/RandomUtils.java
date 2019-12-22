package com.zipcodewilmington.streams.tools;

import java.awt.*;
import java.util.*;

/**
 * Created by Leon on 2/4/2017.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public final class RandomUtils {
    private static final Random random = new Random();

    private RandomUtils() {
        /** This class is uninstantiable */
    }

    /** @return true with the likelihood of specified percentage */
    public static boolean createBoolean(float percentage) {
        return percentage > createFloat(0, 100);
    }

    /** @return a random character between the specified min and max character range */
    public static Character createCharacter(char min, char max) {
        return (char) createInteger((int) min, (int) max).intValue();
    }

    /** @return a random double between the specified min and max numeric range */
    public static Double createDouble(Double min, Double max) {
        return createFloat(min.floatValue(), max.floatValue()).doubleValue();
    }

    /** @return a random float between the specified min and max numeric range */
    public static Float createFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    /** @return a random integer between the specified min and max numeric range */
    public static Integer createInteger(Integer min, Integer max) {
        return createFloat(min, max).intValue();
    }

    /** @return a random long between the specified min and max numeric range */
    public static Long createLong(Long min, Long max) {
        return createFloat(min, max).longValue();
    }

    /** @return a random string of the specified length containing characters in the specified range */
    public static String createString(char min, char max, int stringLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            sb.append(createCharacter(min, max));
        }
        return sb.toString();
    }

    /** @return an array of random string objects of the specified length containing characters in the specified range */
    public static String[] createStrings(char min, char max, int stringLength, int stringCount) {
        String[] strings = new String[stringCount];
        for(int i=0;i<strings.length;i++) {
            strings[i] = createString(min,max,stringLength);
        }
        return strings;
    }

    /** @return a random date object ranging between the specified dates */
    public static Date createDate(int minYear, int maxYear) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.set(Calendar.YEAR, createInteger(minYear, maxYear));
        gc.set(Calendar.DAY_OF_YEAR, createInteger(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR)));
        return gc.getTime();
    }

    /** @return a random element from the sepcified array */
    public static <E> E selectElement(E[] array) {
        return array[createInteger(0, array.length - 1)];
    }

    /** @return specified string value with random upper and lower casing assigned to each character */
    public static String shuffleCasing(String str) {
        StringBuffer sb = new StringBuffer();
        for (String s : str.toLowerCase().split("")) {
            sb.append(createBoolean(50) ? s.toUpperCase() : s.toLowerCase());
        }
        return sb.toString();
    }

    /** @return shuffles the specified string array */
    public static String[] shuffleStringArray(String... array) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));
        Collections.shuffle(list);
        return list.toArray(new String[list.size()]);
    }

    /** @return a random color with the specified maximum rgb values */
    public static Color createColor(int maxRed, int maxGreen, int maxBlue) {
        int red = createInteger(0, maxRed);
        int green = createInteger(0, maxGreen);
        int blue = createInteger(0, maxBlue);
        return new Color(red, green, blue);
    }
}