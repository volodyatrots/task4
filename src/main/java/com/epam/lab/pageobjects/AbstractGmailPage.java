package com.epam.lab.pageobjects;

import com.epam.lab.control.CustomFieldDecorator;
import com.epam.lab.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

abstract class AbstractGmailPage {
    WebDriver driver;

    AbstractGmailPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(new CustomFieldDecorator(
                new DefaultElementLocatorFactory(driver)
        ), this);
    }
}
