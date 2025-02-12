package com.inventsys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String filePath) {
        properties = new Properties();
        try {
            InputStream input;

            File file = new File(filePath);
            if (file.exists()) {
                input = new FileInputStream(file);
            } else {
                input = getClass().getClassLoader().getResourceAsStream(filePath);
                if (input == null) {
                    throw new IOException("File not found: " + filePath);
                }
            }

            properties.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while trying to load file: " + filePath, e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
