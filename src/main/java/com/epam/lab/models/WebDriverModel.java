package com.epam.lab.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverModel {
    private Properties prop = new Properties();

    public WebDriverModel() {
        FileInputStream input = null;
        try {
            input = new FileInputStream("src/resources/driver.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getChromeDriver() {
        return prop.getProperty("webDriverChrome");
    }

    public String getUrl() {
        return prop.getProperty("pathDriver");
    }
}
