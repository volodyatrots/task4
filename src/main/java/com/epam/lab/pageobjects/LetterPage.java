package com.epam.lab.pageobjects;

import com.epam.lab.control.PageElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractGmailPage {
    @FindBy(className = "vO")
    private PageElement mailToInput;

    @FindBy(xpath = ("//span[@class='ag a8k']"))
    private PageElement showSentMessage;

    @FindBy(css = ".aoT")
    private PageElement mailSubjectInput;

    @FindBy(css = "div[class='Am Al editable LW-avf']")
    private PageElement mailMessageInput;

    @FindBy(css = ".Ha")
    private PageElement closeButton;

    @FindBy(css = "td[class='gU Up']")
    private PageElement sendButton;


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

    public PageElement checkSentMessage() {
        return showSentMessage;
    }

}
