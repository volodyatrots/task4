package com.epam.lab.propmodel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverData {
    private Properties prop = new Properties();

    public WebDriverData() throws IOException {
        FileInputStream input = new FileInputStream("src/resources/driver.properties");
        prop.load(input);
    }

    public String getChromeDriver() {
        return prop.getProperty("webDriverChrome");
    }

    public String getUrl() {
        return prop.getProperty("pathDriver");
    }
}
