package com.epam.lab.pageobjects;

import com.epam.lab.control.PageElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends AbstractGmailPage {
    private Boolean statusLoad;
    @FindBy(xpath = "//span[@class='nU n1']")
    private PageElement draftsButton;
    @FindBy(xpath = "//input[@name='q']")
    private PageElement searchField;
    @FindBy(xpath = "//span[contains(text(),'Hi!')]")
    private PageElement myLetter;


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
