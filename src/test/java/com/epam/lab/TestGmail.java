package com.epam.lab;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.propmodel.GmailData;
import com.epam.lab.propmodel.WebDriverData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;


public class TestGmail {
    private WebDriver driver;
    private GmailData gmailData;
    private GmailLoginBO gmailLoginBO;
    private MessagesBO messagesBO;

    @BeforeClass
    public void setUp() {
        WebDriverData webDriverData = new WebDriverData();
        System.setProperty(webDriverData.getChromeDriver(), webDriverData.getUrl());
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        };

        gmailData = new GmailData();
        gmailLoginBO = new GmailLoginBO(driver);
        messagesBO = new MessagesBO(driver);
    }

    @Test
    public void sendFromDrafts() {

        gmailLoginBO.openLoginPage(gmailData.getGmailLink());

        gmailLoginBO.login(gmailData.getUserMail(), gmailData.getUserPassword());

        assertTrue(gmailLoginBO.checkLoginSuccess());

        messagesBO.writeLetterAndSave(gmailData.getMailTo(), gmailData.getMailSubject(), gmailData.getMailMessage());

        messagesBO.openDrafts();

        assertTrue(messagesBO.checkLoadDrafts());

        messagesBO.openMyLetter();

        messagesBO.sendLetter();

        assertNotNull(messagesBO.checkSentMessage());
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}