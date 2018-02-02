package com.epam.lab.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage extends AbstractGmailPage {

    @FindBy(xpath = "//div[@class='z0']/div")
    private WebElement composeButton;

    public GmailInboxPage(WebDriver driver) {
        super(driver);
    }

    public void composeLetter() {
        composeButton.click();
    }

}
