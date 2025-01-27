package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Url paginii de login
    private final String pageUrl = "https://www.saucedemo.com/v1/";

    // Locatorii
    private By usernameField = By.cssSelector("#user-name");
    private By passwordField = By.cssSelector("#password");
    private By loginButton = By.cssSelector("#login-button");
    private By errorMessage = By.cssSelector("form h3");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.get(pageUrl);
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public String getUsername(){
        return driver.findElement(usernameField).getText();
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

}

