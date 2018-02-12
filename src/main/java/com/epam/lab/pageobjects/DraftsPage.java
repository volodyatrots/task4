package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.Button;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends PageObject {
    private Boolean statusLoad;

    @FindBy(xpath = "//div[@class='aim'][3]")
    private Button draftsButton;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'Hi!')]")
    private WebElement myLetter;


    public void openDrafts() {
        draftsButton.click();
    }

    public void waitLoadDrafts() {
        statusLoad = new WebDriverWait(Driver.getDriver(), 60).until(ExpectedConditions.textToBePresentInElementValue(searchField, "in:draft "));
    }

    public boolean checkLoadDrafts() {
        return statusLoad;
    }

    public void openMyLetter() {
        myLetter.click();
    }
}
