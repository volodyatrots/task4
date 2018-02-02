package com.epam.lab.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractGmailPage {
    @FindBy(className = "vO")
    private WebElement mailToInput;

    @FindBy(className = "aoT")
    private WebElement mailSubjectInput;

    @FindBy(css = "div[class='Am Al editable LW-avf'")
    private WebElement mailMessageInput;

    @FindBy(className = "Ha")
    private WebElement closeButton;

    @FindBy(css = "td[class='gU Up']")
    private WebElement sendButton;


    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailTo(String mailTo) {
        mailToInput.sendKeys(mailTo);
    }

    public void enterEmailSubject(String mailSubject) {
        mailSubjectInput.sendKeys(mailSubject);
    }

    public void enterMessage(String mailMessage) {
        mailMessageInput.sendKeys(mailMessage);
    }

    public void closeLetter() {
        closeButton.click();
    }

    public void sendLetter() {
        sendButton.click();
    }


}
