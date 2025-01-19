package com.skillbrain;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class SeleniumTest {
    public static void main(String[] args) {
        // Configurarea WebDriver-ului
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64/chromedriver.exe"); // calea către chromedriver

        //Optiuni pentru Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Deschida browserul pe tot ecranul

        // Inițializarea WebDriver-ului
        WebDriver driver = new ChromeDriver(options);
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
        WebElement formAuthLink = driver.findElement(By.linkText("Form Authentication"));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        formAuthLink.click();

        String actualTitle = driver.findElement(By.cssSelector("#content h2")).getText();
        String expectedTitle = "Login Pages";
        Assert.assertEquals(actualTitle,expectedTitle, "Titlul nu este cel asteptat");



        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Inchiderea browserului
        driver.quit();
    }
}
