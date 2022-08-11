package com.coherensolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(id = "email_create")
    private WebElement emailCreateInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement usernameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void load(String link) {
        driver.get(link);
    }

    public RegistrationPage createAccount(String username) {
        emailCreateInput.sendKeys(username);
        createAccountButton.click();
        return new RegistrationPage(driver);
    }

    public MyAccountPage logIn(String username, String password) {
        usernameInput.sendKeys(username);
        loginButton.click();
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MyAccountPage(driver);
    }
}