package com.epam.lab.businessobjects;

import com.epam.lab.models.UserModel;
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


    public void loginAS(String login,String password) {
        gmailLoginPage.enterEmail(login);
        gmailLoginPage.enterPassword(password);
    }

    public boolean checkLoginSuccess() {
        return gmailInboxPage.checkLoadInbox();
    }
}
