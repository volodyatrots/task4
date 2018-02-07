package com.epam.lab.pageobjects;

import com.epam.lab.control.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInboxPage extends AbstractGmailPage {
    private Boolean statusLoad;
    @FindBy(xpath = "//div[@class='z0']/div")
    private PageElement composeButton;


    public void composeLetter() {
        composeButton.click();
    }

    public boolean checkLoadInbox() {
        if ((new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(composeButton)) != null) {
            statusLoad = true;
        }
        return statusLoad;
    }
}
