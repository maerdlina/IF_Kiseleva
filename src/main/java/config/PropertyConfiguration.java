package config;

import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {
    private static final Properties props = new Properties();
    static {
        try (InputStream input = PropertyConfiguration.class.getResourceAsStream("/config.properties")) {
            if (input == null) {
                throw new RuntimeException("Config file not found");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config", e);
        }
    }
    public static String get(String key) {
        return props.getProperty(key);
    }
}
