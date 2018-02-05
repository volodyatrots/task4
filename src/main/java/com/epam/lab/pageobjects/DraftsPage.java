package com.epam.lab.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends AbstractGmailPage {
    private Boolean statusLoad;
    @FindBy(xpath = "//span[@class='nU n1']")
    private WebElement draftsButton;
    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;
    @FindBy(xpath = "//span[contains(text(),'Hi!')]")
    private WebElement myLetter;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public void openDrafts() {
        draftsButton.click();
    }

    public void waitLoadDrafts() {
        statusLoad = new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementValue(searchField, "in:draft "));
    }

    public boolean checkLoadDrafts() {
        return statusLoad;
    }

    public void openMyLetter() {
        myLetter.click();
    }
}
