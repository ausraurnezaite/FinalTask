package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends DriverManager {
    private WebDriver driver;


    private final String TITLE = "Order - My Store";

    @FindBy(css = "a.home")
    private WebElement homeButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

}