package com.epam.lab.driver;

import com.epam.lab.models.WebDriverModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static DriverFactory instance = new DriverFactory();
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            WebDriverModel webDriverModel = new WebDriverModel();
            System.setProperty(webDriverModel.getChromeDriver(), webDriverModel.getUrl());
            return new ChromeDriver();
        }
    };

    private DriverFactory() {

    }

    public static DriverFactory getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
