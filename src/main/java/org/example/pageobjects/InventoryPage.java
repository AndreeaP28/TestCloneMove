package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    // Url paginii de inventar
    private final String pageUrl = "https://www.saucedemo.com/v1/inventory.html";

    // locatorii
    private By addToCartButtonFirstItem = By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");

    // Constructor
    public InventoryPage(WebDriver driver){
        this.driver = driver;
    }

    public void nagigateTo(){
        driver.get(pageUrl);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void addFirstProductToCart(){
        driver.findElement(addToCartButtonFirstItem).click();
    }

    public String getCartBadgeText(){
        return driver.findElement(cartBadge).getText();
    }

    public boolean isCartBadgeDisplayed(){
        return !driver.findElements(cartBadge).isEmpty();
    }

}

