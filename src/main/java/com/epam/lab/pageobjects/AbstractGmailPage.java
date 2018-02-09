package com.epam.lab.pageobjects;


import com.epam.lab.control.CustomFieldDecorator;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.ConfigProperty;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

class AbstractGmailPage {

    AbstractGmailPage() {
        ConfigProperty configProperty = new ConfigProperty();
        System.setProperty(configProperty.getChromeDriver(), configProperty.getUrl());
        PageFactory.initElements(new CustomFieldDecorator(
                new DefaultElementLocatorFactory(Driver.getDriver())), this);
    }
}
