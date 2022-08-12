package com.coherentsolutions.training.automation.java.web.urnezaite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    @FindBy(css = "ul#homefeatured>li a.product-name")
    private List<WebElement> productsList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public LogInPage logout() {
        logOutButton.click();
        return new LogInPage(driver);
    }

    public ItemPage selectRandomItem() {
        int random = new Random().nextInt(productsList.size());
        productsList.get(random).click();
        return new ItemPage(driver);
    }
}