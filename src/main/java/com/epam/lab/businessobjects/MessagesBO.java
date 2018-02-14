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

    public void writeLetter(MessageModel message) {
        gmailInboxPage.composeLetter();
        letterPage.enterEmailTo(message.getMailTo());
        letterPage.enterEmailSubject(message.getMailSubject());
        letterPage.enterMessage(message.getMailMessage());
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
