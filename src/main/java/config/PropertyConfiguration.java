package config;

import io.qameta.allure.Allure;

import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {
    private static final Properties props = new Properties();
    static {
        try (InputStream input = PropertyConfiguration.class.getResourceAsStream("/config/config.properties")) {
            if (input == null) {
                throw new RuntimeException("Config file not found");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config", e);
        }
    }
    public static String get(String key) {
        String value = props.getProperty(key);
        if (value == null) {
            Allure.addAttachment("CONFIG ERROR", "text/plain",
                    "Отсутствует ключ: " + key + "\nДоступные ключи: " + props.keySet());
            throw new RuntimeException("Не найден ключ: " + key);
        }
        return value;
    }

}