package com.skillbrain;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.file.Files;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(){
        // Configurarea WebDriver-ului
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64/chromedriver.exe"); // calea către chromedriver

        //Optiuni pentru Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Deschida browserul pe tot ecranul

        // Inițializarea WebDriver-ului
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

