package com.epam.lab;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.MessageModel;
import com.epam.lab.models.UserModel;
import com.epam.lab.utils.xml.XMLData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class TestGmail {

    @DataProvider(parallel = true)
    public Object[][] getUsersData() {
        return new XMLData().getGmailData();
    }


    @Test(dataProvider = "getUsersData", threadPoolSize = 5)
    public void sendFromDrafts(UserModel userModel, MessageModel message) {

        GmailLoginBO gmailLoginBO = new GmailLoginBO();

        MessagesBO messagesBO = new MessagesBO();

        gmailLoginBO.openLoginPage();

        gmailLoginBO.loginAS(userModel);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        messagesBO.writeLetter(message);

        messagesBO.openDrafts();

        assertTrue(messagesBO.checkLoadDrafts());

        messagesBO.openMyLetter();

        messagesBO.sendLetter();

        assertNotNull(messagesBO.checkSentMessage());
    }

    @AfterMethod
    public void closeDriver() {
        Driver.close();
    }
}