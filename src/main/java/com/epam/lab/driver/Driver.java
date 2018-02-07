package com.epam.lab.driver;

import com.epam.lab.models.WebDriverModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }

    public static void createDriver() {

        WebDriverModel webDriverModel = new WebDriverModel();
        System.setProperty(webDriverModel.getChromeDriver(), webDriverModel.getUrl());
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        };
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
