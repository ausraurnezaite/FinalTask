package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends DriverManager {
    private WebDriver driver;

    private final String HOME_URL = "http://automationpractice.com/index.php";
    private final String TITLE = "My Store";

    @FindBy(xpath = "//*[text() = 'My account']")
    private WebElement myAccountHeading;

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@title = 'View my shopping cart']")
    private WebElement cartButton;

    @FindBy(css = "a.home")
    private WebElement homeButton;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }
}