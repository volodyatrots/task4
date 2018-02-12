package com.epam.lab.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class Driver {
    private static int countThreads =0;
    private static final ThreadLocal<WebDriver> threadLocalScope = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            countThreads++;
            if (countThreads <=2) {
                synchronized (threadLocalScope) {
                    try {
                        threadLocalScope.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            return driver;
        }
    };

    private Driver() {
    }

    public static void close() {
        if (getDriver() != null) {
            try {
                getDriver().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ;
            synchronized (threadLocalScope) {
                threadLocalScope.notify();
            }
            threadLocalScope.remove();
        }
    }

    public static WebDriver getDriver() {
        return threadLocalScope.get();
    }
}
