package com.coherensolutions.training.automation.java.web.urnezaite;

import com.coherensolutions.training.automation.java.web.urnezaite.util.DriverManager;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[@title = 'View my customer account']")
    private WebElement myAccountButton;

    @FindBy(xpath = "//a[@title = 'Woman']")
    private WebElement optionWomanButton;

    @FindBy(xpath = "//a[@title = 'Dresses']")
    private WebElement optionDressesButton;

    @FindBy(xpath = "//a[@title = 'T-shirts']")
    private WebElement optionTShirtsButton;

    @FindBy(css = "ul.product_list")
    private WebElement products;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public CartPage goToCartPage() {
        cartButton.click();
        return new CartPage(driver);
    }

    public MyAccountPage goToMyAccountPage() {
        myAccountButton.click();
        return new MyAccountPage(driver);
    }

    public LogInPage logout() {
        logOutButton.click();
        return new LogInPage(driver);
    }

    public ItemPage selectRandomItem() {
        Integer random = new Faker().random().nextInt(1, products.findElements(By.cssSelector("li")).size());
        WebElement randomItem = products.findElement(By.xpath("//li[" + random + "]//a[@class='product-name']"));
        randomItem.click();
        return new ItemPage(driver);
    }
}