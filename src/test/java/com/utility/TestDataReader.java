package com.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\lkadadas\\Desktop\\Sprint\\Practo\\src\\test\\resource\\PropertieFiles\\testdata.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
