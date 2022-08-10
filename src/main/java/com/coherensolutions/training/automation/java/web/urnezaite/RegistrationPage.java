package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.factory.UserData;
import com.coherensolutions.training.automation.java.web.urnezaite.factory.UserDataGenerator;
import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import com.coherensolutions.training.automation.java.web.urnezaite.util.PropertyProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {
      private final String PASSWORD = PropertyProvider.getProperty("password");
    @FindBy(xpath = "//label[@for='id_gender1']")
    private WebElement genderMRadio;

    @FindBy(xpath = "//label[@for='id_gender2']")
    private WebElement genderFRadio;

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
        super(driver);
    }

    public MyAccountPage register() {
        UserData user = UserDataGenerator.generate();
        System.out.println(user.getGender());
        if (user.getGender() == 1) {
            genderMRadio.click();
        } else {
            genderFRadio.click();
        }
        genderFRadio.click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        passwordInput.sendKeys(PASSWORD);
        daysDropDawn.selectByValue(user.getBirthDay());
        monthsDropDawn.selectByValue(user.getBirthMonth());
        yearsDropDawn.selectByValue(user.getBirthYear());
        addressInput.sendKeys(user.getStreetAndHouseNo());
        cityInput.sendKeys(user.getCity());
        stateDropDawn.selectByVisibleText(user.getState());
        postalInput.sendKeys(user.getPostalCode());
        phoneInput.sendKeys(user.getPhoneNo());
        registerButton.click();
        return new MyAccountPage(driver);
    }
}