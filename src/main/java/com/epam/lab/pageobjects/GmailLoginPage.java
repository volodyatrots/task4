package com.epam.lab.pageobjects;

import com.epam.lab.control.PageElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends AbstractGmailPage {

    @FindBy(css = "input[type='email']")
    private PageElement emailInput;

    @FindBy(css = "input[name='password']")
    private PageElement passwordInput;



    public void openLoginPage(String link) {
        driver.get(link);
    }

    public void enterEmail(String mail) {
        emailInput.sendKeys(mail + Keys.ENTER);
    }

    public void enterPassword(String pass) {
        passwordInput.sendKeys(pass + Keys.ENTER);
    }


}
