package com.zipcodewilmington.streams.tools.logging;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by leon on 5/15/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public class LoggerWarehouse {
    public static final LoggerHandler globalLogger = new LoggerHandler(Logger.getGlobal());
    private static final HashMap<Class, LoggerHandler> loggerMap = new HashMap<>();

    public static final LoggerHandler getLogger(Class c) {
        addLogger(c);
        return loggerMap.get(c);
    }

    private static final void addLogger(Class c) {
        if (!loggerMap.containsKey(c)) {
            globalLogger.info(String.format("Instantiating logger for [ %s ] ... ", c.getName()));
            loggerMap.put(c, new LoggerHandler(c));
        }
    }
}
