package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    protected WebElement cartButton;

    @FindBy(css = "a.logout")
    protected WebElement logOutButton;

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    protected WebElement myAccountButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public LogInPage logout() {
        logOutButton.click();
        return new LogInPage(driver);
    }

    public MyAccountPage goToMyAccountPage() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }
}