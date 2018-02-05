package com.epam.lab.businessobjects;

import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.GmailLoginPage;
import org.openqa.selenium.WebDriver;

public class GmailLoginBO {
    private GmailInboxPage gmailInboxPage;
    private GmailLoginPage gmailLoginPage;

    public GmailLoginBO(WebDriver driver) {
        gmailLoginPage = new GmailLoginPage(driver);
        gmailInboxPage = new GmailInboxPage(driver);
    }

    public void openLoginPage(String link) {
        gmailLoginPage.openLoginPage(link);
    }


    public void login(String mail, String pass) {
        gmailLoginPage.enterEmail(mail);
        gmailLoginPage.enterPassword(pass);
    }

    public boolean checkLoginSuccess() {
        return gmailInboxPage.checkLoadInbox();
    }
}
