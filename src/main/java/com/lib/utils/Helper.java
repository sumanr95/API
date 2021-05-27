package com.lib.utils;

import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;

import java.lang.reflect.Type;
import java.security.SecureRandom;

public class Helper {

    public static String generateRandomBase64String(int size) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[size];
        secureRandom.nextBytes(bytes);
        return Base64.encodeBase64String(bytes);
    }

    public static Object convertJsonToDTO(String json, String dtoClassName) {
        Object containerObject = null;
        Gson gson = new Gson();
        try {
            containerObject = Class.forName(dtoClassName).newInstance();
            containerObject = gson.fromJson(json, containerObject.getClass());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return containerObject;
    }

    public static String convertDTOToJson(Object object) {
        try {
            Gson gson = new Gson();
            return gson.toJson(object);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Object convertJsonToDTO(String json, Type type) {
        Object containerObject = null;
        try {
            Gson gson = new Gson();
            containerObject = gson.fromJson(json, type);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return containerObject;
    }

    public static String convertBasicAuthToBase64(String userName, String password) {
        return "Basic "+ Base64.encodeBase64String((userName+":"+password).getBytes());
    }

}
