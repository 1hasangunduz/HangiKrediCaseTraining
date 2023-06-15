package Utilities;

import ExtentReports.ExtentTestManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Log extends ExtentTestManager {

    public static final Logger LOGGER = LogManager.getLogger(Log.class);

    public static void pass(String message) {
        LOGGER.info(message);
        getTest().pass(message);

    }

    public static void pass(float message) {
        LOGGER.info(message);
        getTest().pass(String.valueOf(message));
    }

    public static void pass(int message) {
        LOGGER.info(message);
        getTest().info(String.valueOf(message));
    }

    public static void pass(List<String> message) {
        LOGGER.info(message);
        getTest().info(String.valueOf(message));
    }

    public static void fail(String message) {
        LOGGER.error(message);
        getTest().fail(message);
    }

    public static void warning(String message) {
        LOGGER.warn(message);
        getTest().warning(message);
    }
}