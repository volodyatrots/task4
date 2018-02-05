package com.epam.lab.businessobjects;

import com.epam.lab.pageobjects.DraftsPage;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.LetterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesBO {
    private DraftsPage draftsPage;
    private GmailInboxPage gmailInboxPage;
    private LetterPage letterPage;


    public MessagesBO(WebDriver driver) {
        draftsPage = new DraftsPage(driver);
        gmailInboxPage = new GmailInboxPage(driver);
        letterPage = new LetterPage(driver);
    }

    public void writeLetterAndSave(String mailTo, String mailSubject, String mailMessage) {
        gmailInboxPage.composeLetter();
        letterPage.enterEmailTo(mailTo);
        letterPage.enterEmailSubject(mailSubject);
        letterPage.enterMessage(mailMessage);
        letterPage.closeLetter();
    }

    public void openDrafts() {
        draftsPage.openDrafts();
        draftsPage.waitLoadDrafts();
    }

    public boolean checkLoadDrafts() {
        return draftsPage.checkLoadDrafts();
    }

    public void openMyLetter() {
        draftsPage.openMyLetter();
    }

    public void sendLetter() {
        letterPage.sendLetter();
    }

    public WebElement checkSentMessage() {
        return letterPage.checkSentMessage();
    }
}
