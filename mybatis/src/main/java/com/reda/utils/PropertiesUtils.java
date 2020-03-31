package com.reda.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public static String get(String key) {
        InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream("data.properties");
        Properties props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props.getProperty(key);
    }
}
