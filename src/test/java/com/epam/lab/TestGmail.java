package com.epam.lab;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.DriverFactory;
import com.epam.lab.models.GmailData;
import com.epam.lab.models.unmarsheller.User;
import com.epam.lab.models.unmarsheller.UserDataUnmarshaller;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class TestGmail {
    List<User> users;
    private WebDriver driver;
    private GmailData gmailData;
    private GmailLoginBO gmailLoginBO;
    private MessagesBO messagesBO;

    @DataProvider(parallel = true)
    public Object[][] getUsersData() {
        users = new UserDataUnmarshaller().createObjectsUserData();
        return new Object[][]{
                {users.get(0).getEmail(), users.get(0).getPassword()},
                {users.get(1).getEmail(), users.get(1).getPassword()}
        };
    }

    @BeforeMethod
    public void setUp() {
        gmailData = new GmailData();
        gmailLoginBO = new GmailLoginBO();
        messagesBO = new MessagesBO();
    }


    @Test(dataProvider = "getUsersData",threadPoolSize = 2)
    public void sendFromDrafts(String email, String password) {

        gmailLoginBO.openLoginPage(gmailData.getGmailLink());

        gmailLoginBO.login(email, password);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        messagesBO.writeLetterAndSave(gmailData.getMailTo(), gmailData.getMailSubject(), gmailData.getMailMessage());

        messagesBO.openDrafts();

        assertTrue(messagesBO.checkLoadDrafts());

        messagesBO.openMyLetter();

        messagesBO.sendLetter();

        assertNotNull(messagesBO.checkSentMessage());
    }

    @AfterMethod
    public void closeDriver() {
        DriverFactory.getInstance().removeDriver();
    }
}