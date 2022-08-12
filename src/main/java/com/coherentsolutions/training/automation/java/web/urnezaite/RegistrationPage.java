package com.coherentsolutions.training.automation.java.web.urnezaite;

import com.coherentsolutions.training.automation.java.web.urnezaite.user.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage {
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

    @FindBy(css = "select#days")
    private WebElement selectDay;

    @FindBy(css = "select#months")
    private WebElement selectMonth;

    @FindBy(css = "select#years")
    private WebElement selectYear;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement selectState;

    @FindBy(id = "postcode")
    private WebElement postalInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    private static final Logger logger = LogManager.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage register(UserData user) {
        logger.info(user);

        if (user.getGender() == 1) {
            genderMRadio.click();
        } else {
            genderFRadio.click();
        }

        genderFRadio.click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        passwordInput.sendKeys(user.getPassword());

        Select daysDropDawn = new Select(selectDay);
        daysDropDawn.selectByValue(user.getBirthDay());

        Select monthsDropDawn = new Select(selectMonth);
        monthsDropDawn.selectByValue(user.getBirthMonth());

        Select yearsDropDawn = new Select(selectYear);
        yearsDropDawn.selectByValue(user.getBirthYear());

        addressInput.sendKeys(user.getStreetAndHouseNo());
        cityInput.sendKeys(user.getCity());

        Select stateDropDawn = new Select(selectState);
        stateDropDawn.selectByVisibleText(user.getState());

        postalInput.sendKeys(user.getPostalCode());
        phoneInput.sendKeys(user.getPhoneNo());
        registerButton.click();

        return new MyAccountPage(driver);
    }
}