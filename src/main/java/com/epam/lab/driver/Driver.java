package com.epam.lab.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static final ThreadLocal<WebDriver> threadLocalScope = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            System.out.println("Thread " + Thread.currentThread().getId());

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            return driver;
        }
    };

    public static void close() {
        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            threadLocalScope.remove();
        }
    }

    public static WebDriver getDriver() {
        return threadLocalScope.get();
    }

}
