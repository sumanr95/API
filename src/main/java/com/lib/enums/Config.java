package com.lib.enums;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {

    protected static Configuration configuration;

    public static void loadConfig() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try {
            configuration = new PropertiesConfiguration(classLoader.getResource("config.properties").toString());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getEnvironmentName() {
        return configuration.getString("env");
    }

}
