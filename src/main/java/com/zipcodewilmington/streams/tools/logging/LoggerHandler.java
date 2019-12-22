package com.zipcodewilmington.streams.tools.logging;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;
import java.util.stream.Stream;

import static java.util.logging.Level.*;

/**
 * Created by leon on 5/15/17.
 * @ATTENTION_TO_STUDENTS You are FORBIDDEN from modifying this class
 */
public final class LoggerHandler {
    private final Logger logger;
    private final String loggerName;
    private boolean printingEnabled;

    public LoggerHandler(Class c) {
        this(c.getSimpleName());
    }

    public LoggerHandler(String loggerName) {
        this(Logger.getLogger(loggerName));
    }

    public LoggerHandler(Logger logger) {
        this.logger = logger;
        this.loggerName = logger.getName();
        this.logger.addHandler(getFileHandler());
        this.printingEnabled = true;
    }

    public void throwable(Throwable t, Level level) {
        StringWriter out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        log(level, description);
    }

    public void throwable(Throwable t) {
        throwable(t, WARNING);
    }

    public void info(String s, Object... args) {
        log(INFO, s, args);
    }

    public void warn(String s, Object... args) {
        log(WARNING, String.format(s, args));
    }

    public void error(String s, Object... args) {
        log(SEVERE, s, args);
    }

    private void log(Level level, String message, Object... messageArgs) {
        if(printingEnabled) {
            System.out.println(String.format(message, messageArgs));
        }
        logger.log(level, String.format(message, messageArgs));
    }

    public void setLevel(Level level) {
        logger.setLevel(level);
    }

    public void enablePrinting() {
        this.printingEnabled = true;
    }

    public void disbalePrinting() {
        this.printingEnabled = false;
    }

    private FileHandler getFileHandler() {
        return getFileHandler(new SimpleFormatter());
    }

    private FileHandler getFileHandler(Formatter formatter) {
        FileHandler fh = null;
        try {
            removeHandlers(); // enables better printing control
            String fileName = String.format("./target/%s.leonlog", loggerName, System.nanoTime());
            fh = new FileHandler(fileName);
            fh.setFormatter(formatter);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {

        }
        return fh;
    }

    private void removeHandlers() {
        logger.setUseParentHandlers(false);
        for (Handler handler : logger.getHandlers()) {
            logger.removeHandler(handler);
        }
    }
}
