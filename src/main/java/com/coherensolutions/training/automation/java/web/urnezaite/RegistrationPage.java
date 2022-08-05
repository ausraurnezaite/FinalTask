package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import com.coherensolutions.training.automation.java.web.urnezaite.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends DriverManager {
    private WebDriver driver;

    private final String PASSWORD = PropertyProvider.getProperty("password");
    @FindBy(xpath = "//label[@for='id_gender2']")
    private WebElement genderRadio;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private Select daysDropDawn;
    @FindBy(id = "months")
    private Select monthsDropDawn;
    @FindBy(id = "years")
    private Select yearsDropDawn;
    @FindBy(id = "address1")
    private WebElement addressInput;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    private Select stateDropDawn;
    @FindBy(id = "postcode")
    private WebElement postalInput;
    @FindBy(id = "phone_mobile")
    private WebElement phoneInput;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MyAccountPage register() {
        genderRadio.click();
        firstNameInput.sendKeys("test");
        lastNameInput.sendKeys("account");
        passwordInput.sendKeys(PASSWORD);
        daysDropDawn.selectByValue("26");
        monthsDropDawn.selectByValue("2");
        yearsDropDawn.selectByValue("1992");
        addressInput.sendKeys("testing street 1");
        cityInput.sendKeys("testcity");
        stateDropDawn.selectByVisibleText("Florida");
        postalInput.sendKeys("12345");
        phoneInput.sendKeys("+37062685556");
        registerButton.click();
        return new MyAccountPage(driver);
    }
}