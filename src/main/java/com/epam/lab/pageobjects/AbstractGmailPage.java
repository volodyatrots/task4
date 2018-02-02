package com.epam.lab.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

class AbstractGmailPage {
    WebDriver driver;

    AbstractGmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
