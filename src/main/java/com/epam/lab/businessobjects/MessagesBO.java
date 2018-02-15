package com.epam.lab.businessobjects;


import com.epam.lab.models.MessageModel;
import com.epam.lab.pageobjects.DraftsPage;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.LetterPage;

public class MessagesBO {
    private DraftsPage draftsPage;
    private GmailInboxPage gmailInboxPage;
    private LetterPage letterPage;


    public MessagesBO() {
        draftsPage = new DraftsPage();
        gmailInboxPage = new GmailInboxPage();
        letterPage = new LetterPage();
    }

    public void writeLetter(String mailTo,String mailSubject,String mailMessage) {
        gmailInboxPage.composeLetter();
        letterPage.enterEmailTo(mailTo);
        letterPage.enterEmailSubject(mailSubject);
        letterPage.enterMessage(mailMessage);
        letterPage.closeLetter();
    }

    public void openDrafts() {
        draftsPage.openDrafts();
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

    public boolean checkSentMessage() {
        return letterPage.checkSentMessage();
    }
}
