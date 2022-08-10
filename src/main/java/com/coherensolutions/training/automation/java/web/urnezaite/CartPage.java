package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{

    @FindBy(css = "a.home")
    private WebElement homeButton;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToHomePage() {
        homeButton.click();
        return new MainPage(driver);
    }

}