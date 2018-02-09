package com.epam.lab.pageobjects;


import com.epam.lab.control.PageElement;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.ConfigProperty;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends AbstractGmailPage {
    ConfigProperty configProperty;
    @FindBy(css = "input[type='email']")
    private PageElement emailInput;

    @FindBy(css = "input[name='password']")
    private PageElement passwordInput;


    public void openLoginPage() {
        configProperty = new ConfigProperty();
        Driver.getDriver().get(configProperty.getGmailLink());
    }

    public void enterEmail(String mail) {
        emailInput.sendKeys(mail + Keys.ENTER);
    }

    public void enterPassword(String pass) {
        passwordInput.sendKeys(pass + Keys.ENTER);
    }
}
