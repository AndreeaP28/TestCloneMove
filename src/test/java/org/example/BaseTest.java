package org.example;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp(String viewMode){
        // Configurarea WebDriver-ului
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver-win64/chromedriver.exe"); // calea către chromedriver

        //Optiuni pentru Chrome
        ChromeOptions options = new ChromeOptions();

        if(viewMode.equalsIgnoreCase("mobile")) {
            options.addArguments("--window-size=375,667"); // Set window size for mobile view (iPhone 6/7/8)
        } else {
            options.addArguments("--start-maximized"); // Deschida browserul pe tot ecranul
        }


        // Inițializarea WebDriver-ului
        driver = new ChromeDriver(options);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void takeScreenshot(){
        TakesScreenshot camera = (TakesScreenshot)driver;
        File screnshoot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screnshoot, new File("src/test/resources/screenshots/test.png"));
        } catch (Exception e2){
            e2.printStackTrace();
        }
    }
}

