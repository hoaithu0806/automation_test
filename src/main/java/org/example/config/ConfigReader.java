package org.example.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties prop = new Properties();

    public ConfigReader(Environment env) {
        try {
            String fileName = "config_" + env.name().toLowerCase() + ".properties";
            var inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException("Không tìm thấy file config: " + fileName);
            }

            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Không đọc được config cho " + env, e);
        }
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}

