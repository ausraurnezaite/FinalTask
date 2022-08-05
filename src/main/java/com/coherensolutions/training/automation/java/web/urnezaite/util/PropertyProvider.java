package com.coherensolutions.training.automation.java.web.urnezaite.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyProvider {
    public static Properties properties;

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src/main/resources/properties.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String propertyName) {
        if (properties == null) {
            loadProperties();
        }
        return PropertyProvider.properties.getProperty(propertyName);
    }
}