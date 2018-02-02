package com.epam.lab;

import com.epam.lab.pageobjects.DraftsPage;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.GmailLoginPage;
import com.epam.lab.pageobjects.LetterPage;
import com.epam.lab.propmodel.GmailData;
import com.epam.lab.propmodel.WebDriverData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;



/*Task 5
        1. Open gmail & login
        2. Click on “compose” button
        3. Fill the next fields: to,subject & message
        4. Click on “save & close” button
        5. Go to the “draft” folder & open previously saved message
        6. Verify that all fields are saved correctly
        7. Press the “send” button*/


public class TestGmail {
    private WebDriver driver;
    private GmailLoginPage loginPage;
    private GmailInboxPage inboxPage;
    private LetterPage letterPage;
    private DraftsPage draftsPage;
    private GmailData gmailData;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverData webDriverData = new WebDriverData();
        System.setProperty(webDriverData.getChromeDriver(), webDriverData.getUrl());
        driver = new ChromeDriver() {
            {
                manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        };

        gmailData = new GmailData();
        loginPage = new GmailLoginPage(driver);
        inboxPage = new GmailInboxPage(driver);
        letterPage = new LetterPage(driver);
        draftsPage = new DraftsPage(driver);
    }

    @Test
    public void sendFromDrafts() {

        loginPage.openLoginPage(gmailData.getGmailLink());

        loginPage.enterEmail(gmailData.getUserMail());

        loginPage.enterPassword(gmailData.getUserPassword());

        inboxPage.composeLetter();

        letterPage.enterEmailTo(gmailData.getMailTo());

        letterPage.enterEmailSubject(gmailData.getMailSubject());

        letterPage.enterMessage(gmailData.getMailMessage());

        letterPage.closeLetter();

        draftsPage.openDrafts();

        draftsPage.waitLoadDrafts();

        draftsPage.openMyLetter();

        letterPage.sendLetter();

        assertNotNull(driver.findElement(By.xpath("//span[@class='ag a8k']")));
    }

    @AfterClass
    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}