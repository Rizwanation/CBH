package org.cbh.configs;

import org.cbh.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Properties;
public final class ReadConfig {
    private ReadConfig()
    {}
    private static Properties prop;

    static {
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
            prop.load(fis);
        } catch (FileNotFoundException e) {
            System.out.println("Config file not found. Check name and path");
            e.printStackTrace();

        } catch (Exception e) {
            System.out.println("Check config file format. key/value must not be null");
            e.printStackTrace();
        }
    }
    public static String getKey(String key) throws Exception {

        String value = prop.getProperty(key);
        if (Objects.isNull(value))
        {
            throw new Exception("Property name " + key + " is not found. Check config file in Configs folder.");
        }
        return value;
    }
}