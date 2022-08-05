package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import com.coherensolutions.training.automation.java.web.urnezaite.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends DriverManager {
    private WebDriver driver;
    private final String USERNAME = PropertyProvider.getProperty("username");
    private final String PASSWORD = PropertyProvider.getProperty("password");
    private final String LOGIN_PAGE_LINK = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
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
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(LOGIN_PAGE_LINK);
    }

    public RegistrationPage createAccount() {
        emailCreateInput.sendKeys(USERNAME);
        createAccountButton.click();
        return new RegistrationPage(driver);
    }

    public MyAccountPage logIn() {
        usernameInput.sendKeys(USERNAME);
        loginButton.click();
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();
        return new MyAccountPage(driver);
    }
}