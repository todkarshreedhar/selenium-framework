package com.framework.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/qa.properties");
            properties.load(fis);
        }
        catch (Exception e)
        {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
