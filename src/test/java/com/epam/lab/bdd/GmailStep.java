package com.epam.lab.bdd;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static junit.framework.TestCase.assertTrue;

public class GmailStep {
    private GmailLoginBO gmailLoginBO = new GmailLoginBO();
    private MessagesBO messagesBO = new MessagesBO();

    @Given("^User navigates to Gmail$")
    public void openGmailPage() {
        gmailLoginBO.openLoginPage();
    }

    @When("^I enter mail (\\S+) and password (\\S+)$")
    public void enterMail(String login, String password) {
        gmailLoginBO.loginAS(login, password);
    }

    @Then("^Login should be successful$")
    public void checkLoginSuccess() {
        assertTrue(gmailLoginBO.checkLoginSuccess());
    }

    @When("^I write message$")
    public void writeLetter() {
        messagesBO.writeLetter("ltd67392@cjpeg.com", "Test", "Hi!");
    }

    @When("^Open Drafts Page$")
    public void openDrafts() {
        messagesBO.openDrafts();
    }

    @Then("^My message should be here$")
    public void checkMessageDrafts() {
        assertTrue(messagesBO.checkLoadDrafts());
    }

    @When("^I sent that message$")
    public void sendLetter() {
        messagesBO.openMyLetter();
        messagesBO.sendLetter();
    }

    @Then("^Message must be sent$")
    public void checkSentMessage() {
        assertTrue(messagesBO.checkSentMessage());
        Driver.close();
    }

}
