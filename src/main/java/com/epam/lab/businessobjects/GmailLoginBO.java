package com.epam.lab.businessobjects;

import com.epam.lab.models.unmarsheller.User;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.GmailLoginPage;

public class GmailLoginBO {
    private GmailInboxPage gmailInboxPage;
    private GmailLoginPage gmailLoginPage;

    public GmailLoginBO() {
        gmailLoginPage = new GmailLoginPage();
        gmailInboxPage = new GmailInboxPage();
    }

    public void openLoginPage() {
        gmailLoginPage.openLoginPage();
    }


    public void login(User user) {
        gmailLoginPage.enterEmail(user.getEmail());
        gmailLoginPage.enterPassword(user.getPassword());
    }

    public boolean checkLoginSuccess() {
        return gmailInboxPage.checkLoadInbox();
    }
}
