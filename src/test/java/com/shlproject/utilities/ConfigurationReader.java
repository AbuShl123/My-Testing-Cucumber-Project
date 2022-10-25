package com.shlproject.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private final static Properties properties;

    static {
        properties = new Properties();

        try{
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

            file.close();
        } catch (IOException ignored) {}
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
