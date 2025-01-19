package com.skillbrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

    @Test
    public void testSuccessfulLogin(){
        driver.get("https://the-internet.herokuapp.com/");

        // Verificarea titlului paginii
        String tabTitle = driver.getTitle();
        System.out.println("Titlul tabului paginii este: " + tabTitle);

        // Gasirea unui element de pe pagina
        WebElement pageTitle = driver.findElement(By.cssSelector("#content h1"));
        System.out.println("Titlul continutului paginii este: " + pageTitle.getText());

        WebElement pageSubtitleTitle = driver.findElement(By.cssSelector("#content h2"));
        System.out.println("Subtitlul continutului paginii este: " + pageSubtitleTitle.getText());

        // Form authentication

        // Ne gasim elementul Form Authentication link si sa dam click pe el
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        formAuthLink.click();

        // Cautam elementul de titlu al paginii si validam textul acestui ca fiind Login Pages
        String actualTitle = driver.findElement(By.cssSelector("#content h2")).getText();
        String expectedTitle = "Login Page";
        Assert.assertEquals(actualTitle,expectedTitle, "Titlul nu este cel asteptat");

        // Cautam elementul de username input si sa introducem in acesta textul "tomsmith"
        WebElement userNameInput = driver.findElement(By.cssSelector("#username"));
        userNameInput.sendKeys("tomsmith");

        // Cautam elementul de password input si sa introduce in acesta textul "SuperSecretPassword!"
        WebElement passwordInput = driver.findElement(By.cssSelector("#password"));
        passwordInput.sendKeys("SuperSecretPassword!");

        // Cautam butonul de Login si dam click pe acesta
        WebElement loginButton = driver.findElement(By.cssSelector("#login button"));
        loginButton.click();



        // Validam ca elementul flash error nu este prezent , si daca acesta nu este prezent validam ca flash success este
        try{
            WebElement flashError = driver.findElement(By.cssSelector(".error"));
            if (flashError.isDisplayed()) {
                Assert.assertTrue(false, "Loginul a esuat");
            } else {
                WebElement flashSuccess = driver.findElement(By.cssSelector(".success"));
                Assert.assertNotNull(flashSuccess, "Nu a fost gasit elementul dorit");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
