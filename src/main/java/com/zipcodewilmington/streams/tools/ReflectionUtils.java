package com.zipcodewilmington.streams.tools;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by leon on 5/19/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class ReflectionUtils {
    public static HashMap<Field, String> getFieldMap(Object object) {
        HashMap hm = new HashMap() {
            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                Iterator it = this.entrySet().iterator();

                for (int i = 0; it.hasNext(); i++) {
                    Entry pair = (Entry) it.next();
                    sb
                            .append("\n" + StringUtils.repeatString(150, "-"))
                            .append(String.format("\nEntry number: %s", StringUtils.padLeft(i, 30)))
                            .append(String.format("\nKey: %s", StringUtils.padLeft(pair.getKey(), 30)))
                            .append(String.format("\nValue: %s", StringUtils.padLeft(pair.getValue(), 30)));
                    it.remove(); // prevents ConcurrentModificationException
                }
                return sb.toString();
            }
        };
        for (Field f : object.getClass().getDeclaredFields()) {
            try {
                boolean defaultAccess = f.isAccessible();

                // attempt to modify field visibility
                f.setAccessible(true);
                hm.put(f, f.get(object).toString());
                f.setAccessible(defaultAccess);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                hm.put(f, null);
            }

        }
        return hm;
    }
}
