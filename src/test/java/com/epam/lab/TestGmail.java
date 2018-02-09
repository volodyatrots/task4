package com.epam.lab;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.unmarsheller.Message;
import com.epam.lab.models.unmarsheller.MessageUnmarshaller;
import com.epam.lab.models.unmarsheller.User;
import com.epam.lab.models.unmarsheller.UserDataUnmarshaller;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class TestGmail {

    @DataProvider(parallel = true)
    public Object[][] getUsersData() {
        List<User> users = new UserDataUnmarshaller().createObjectsUserData();
        List<Message> messages = new MessageUnmarshaller().createObjectsMessage();
        return new Object[][]{
                {users.get(0), messages.get(0)},

                {users.get(1), messages.get(1)},

                {users.get(2), messages.get(2)},

                {users.get(3), messages.get(3)},

                {users.get(4), messages.get(4)}
        };
    }


    @Test(dataProvider = "getUsersData", threadPoolSize = 5)
    public void sendFromDrafts(User user, Message message) {

        GmailLoginBO gmailLoginBO = new GmailLoginBO();

        gmailLoginBO.openLoginPage();

        gmailLoginBO.login(user);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        MessagesBO messagesBO = new MessagesBO();

        messagesBO.writeLetterAndSave(message);

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