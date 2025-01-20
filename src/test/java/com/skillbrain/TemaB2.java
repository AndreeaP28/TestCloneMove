package com.skillbrain;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class TemaB2  extends BaseTest {

    @Test
    public void PageProtection() {

        //go to url
        driver.get("https://testpages.eviltester.com/styled/index.html");

        //dau click pe linkul Basic Authentication Page Protected
        WebElement pageProtected = driver.findElement(By.cssSelector("#basicauth"));
        pageProtected.click();

        // titlul paginii
        WebElement pagetitle = driver.findElement(By.cssSelector("body > div > h1"));
        System.out.println("Titlul paginii este : " + pagetitle.getText());

        // instructiuni pentru acces
        WebElement instructions = driver.findElement(By.cssSelector("body > div > div.centered > p:nth-child(3)"));
        System.out.println(" Instructiunile sunt  urmatoarele : " + instructions.getText());

        //username ul pentru acces
        WebElement username = driver.findElement(By.cssSelector("body > div > div.centered > p:nth-child(4)"));
        System.out.println(username.getText());

        //parola pentru a accesa contul
        WebElement password = driver.findElement(By.cssSelector("body > div > div.centered > p:nth-child(5)"));
        System.out.println(password.getText());

        // auth result
        WebElement authResult = driver.findElement(By.cssSelector("body > div > div.centered > p:nth-child(7) > a"));
        authResult.click();

        // Introducerea username-ului și parolei
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popup-login")));

        WebElement usernameField = driver.findElement(By.id("#username"));
        WebElement passwordField = driver.findElement(By.id("#password"));
        usernameField.sendKeys("authorized");
        passwordField.sendKeys("password001");

        //click pe butonul de login
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();

        // Verificarea succesului autentificării
        if (driver.getCurrentUrl().contains("dashboard")) {
            System.out.println("Login successful!" + username.getText());
        } else {
            System.out.println("Login failed!");
        }
    }


    // Oprim executia testtului pentru a putea vedea stadiul final al paginii
    //try {
    //  Thread.sleep(2000);
    //} catch (Exception e) {
    // e.printStackTrace();


    @Test
    public void windowsLinkTest() {

        //navighez catre url dorit
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // dau click pe linkul de windows link test
        WebElement linkTest = driver.findElement(By.cssSelector("#windowstest"));
        linkTest.click();

        //printam titlul paginii deschise
        WebElement pageTitle = driver.findElement(By.cssSelector("body > div > h1"));
        System.out.println(" Titlul paginii este : " + pageTitle.getText());

        //titlul paginei in tab nou
        WebElement basicExemple = driver.findElement(By.cssSelector("#gobasicajax"));
        basicExemple.click();

        //facem un screenshot la pagina noua
        try {
            WebElement newPage = driver.findElement(By.cssSelector("body > div"));
        } catch (Exception e) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("src/test/resources/screenshot/test.tema"));
            } catch (Exception e1) {
                e.printStackTrace();

            }

            try {
                Thread.sleep(3000);
            } catch (Exception e2) {
                e.printStackTrace();
            }
        }

    }
}