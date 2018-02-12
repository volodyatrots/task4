package com.epam.lab.pageobjects;

import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends PageObject {
    @FindBy(xpath = "//textarea[@name='to']")
    private TextInput mailToInput;

    @FindBy(xpath = ("//span[@class='ag a8k']"))
    private WebElement showSentMessage;

    @FindBy(css = ".aoT")
    private TextInput mailSubjectInput;

    @FindBy(css = "div[class='Am Al editable LW-avf']")
    private TextInput mailMessageInput;

    @FindBy(css = ".Ha")
    private Button closeButton;

    @FindBy(css = "td[class='gU Up']")
    private Button sendButton;


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

    public WebElement checkSentMessage() {
        return showSentMessage;
    }

}
