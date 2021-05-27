package com.lib.enums;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EnvironmentConfig {

    protected static JsonObject JSON_OBJECT;

    public static void loadConfig() throws FileNotFoundException {
        Config.loadConfig();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(Config.getEnvironmentName()+".json").getFile());
        JsonElement jsonElement = JsonParser.parseReader(new FileReader(file.getAbsolutePath()));
        JSON_OBJECT = jsonElement.getAsJsonObject();
    }

    public static String getApiBaseUrl() {
        return JSON_OBJECT.get("apiBaseUrl").getAsString();
    }

    public static String getApiEndPointPrefix() {
        return JSON_OBJECT.get("apiEndPointPrefix").getAsString();
    }

    public static String getFsBaseUrl() {
        return JSON_OBJECT.get("fsBaseUrl").getAsString();
    }

    public static String getFsEndPointPrefix() {
        return JSON_OBJECT.get("fsEndPointPrefix").getAsString();
    }

}
