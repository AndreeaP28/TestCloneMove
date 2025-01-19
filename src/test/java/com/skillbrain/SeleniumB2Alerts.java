package com.skillbrain;


import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.Set;

    public class SeleniumB2Alerts extends BaseTest {

        @Test
        public void testAlerts() {
            // navighez la url dorit
            driver.get("https://testpages.eviltester.com/styled/index.html");

            // dau click pe linkul de Alerts
            WebElement alertsLink = driver.findElement(By.cssSelector("#alerttest"));
            alertsLink.click();

            // Alert
            WebElement alertButton = driver.findElement(By.cssSelector("#alertexamples"));
            alertButton.click();

            driver.switchTo().alert().accept();

            WebElement alertExplanation = driver.findElement(By.cssSelector("#alertexplanation"));
            System.out.println("Textul pentru alerta este: " + alertExplanation.getText());

            // Dialog
            WebElement dialogButton = driver.findElement(By.cssSelector("#confirmexample"));
            dialogButton.click();

            driver.switchTo().alert().accept();

            WebElement dialogExplanation = driver.findElement(By.cssSelector("#confirmexplanation"));
            System.out.println("Textul pentru dialog este: " + dialogExplanation.getText());

            dialogButton.click();
            driver.switchTo().alert().dismiss();

            dialogExplanation = driver.findElement(By.cssSelector("#confirmexplanation"));
            System.out.println("Textul pentru dialog este: " + dialogExplanation.getText());

            // Prompt
            WebElement promoptButton = driver.findElement(By.cssSelector("#promptexample"));
            promoptButton.click();

            driver.switchTo().alert().sendKeys("acesta este un text");
            System.out.println("Verificam textul alertei " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();

            WebElement promptExplanation = driver.findElement(By.cssSelector("#promptexplanation"));
            System.out.println("Textul pentru prompt este: " + promptExplanation.getText());
        }

        @Test
        public void testHover() {
            // navighez la url dorit
            driver.get("https://testpages.eviltester.com/styled/index.html");

            // dau click pe linkul de Alerts
            WebElement hoverLink = driver.findElement(By.cssSelector("#csspseudohover"));
            hoverLink.click();

            // simulam actiunea de Hover
            WebElement elementToHover = driver.findElement(By.cssSelector("#hoverpara"));

            Actions actions = new Actions(driver);
            actions.moveToElement(elementToHover).perform();

            WebElement elementToHoverText = driver.findElement(By.cssSelector("#hoverparaeffect"));
            System.out.println(elementToHoverText.getText());

            // Oprim executia testtului pentru a putea vedea stadiul final al paginii
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

                e.printStackTrace();
            }

        }

        @Test
        public void testWindowHandles() {
            // navighez la url dorit
            driver.get("https://testpages.eviltester.com/styled/index.html");

            // dau click pe linkul de Alerts
            WebElement windowLink = driver.findElement(By.cssSelector("#windowstest"));
            windowLink.click();

            // testam deschiderea unui link in tab now

            WebElement goToAttributesLink = driver.findElement(By.cssSelector("#goattributes"));
            goToAttributesLink.click();

            // printam titlul paginii deschis in tab nou
            WebElement title = driver.findElement(By.cssSelector(".page-body h1"));
            System.out.println(title.getText());

            String expectedTabTitle = "Test Page For Element Attributes";
            switchToTab(expectedTabTitle);

            // printam titlul paginii deschis in tab nou
            title = driver.findElement(By.cssSelector(".page-body h1"));
            System.out.println(title.getText());

            WebElement randomElement = driver.findElement(By.cssSelector(".page-body .explanation+h2"));
            System.out.println("Textul pentru elementul aleator de pe tabul nou este: " + randomElement.getText());

            // Oprim executia testtului pentru a putea vedea stadiul final al paginii
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void switchToTab(String tabTitle) {
            Set<String> windows = driver.getWindowHandles();

            System.out.println("Number of tabs: " + windows.size());

            System.out.println("Window handles: ");
            // linia urmatoare parcurge variabila de windows si afiseaza numele fiecarui window
            windows.forEach(System.out::println);

            // parcurgem fiecare tab
            for (String window : windows) {
                System.out.println("Swithing to window: " + window);
                // linie de executie prin care facem switch la urmatorul tab
                driver.switchTo().window(window);

                System.out.println("Current window title: " + driver.getTitle());

                // conditie de oprire in cazul in care titlul tabului este cel cautat de noi
                if (tabTitle.equals(driver.getTitle())) {
                    break;
                }
            }
        }

        @Test
        public void testFileUpload() {
            // navighez la url dorit
            driver.get("https://the-internet.herokuapp.com/upload");

            // Get the file path (use an actual file on your machine here)
            // Wait for the file input element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement fileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("file-upload")));


            File file = new File("src/test/resources/chromedriver-win64/chromedriver.exe"); // Example: "C:/Users/You/Desktop/file.txt"
            String filePath = file.getAbsolutePath();

            // Send the file path to the file input element
            fileInput.sendKeys(filePath);


            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Test
        public void testScreenshotsTryCatch() {
            //go to url
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            // dau click pe linkul de Alerts
            WebElement alertsLink = driver.findElement(By.cssSelector("#alerttest"));
            alertsLink.click();

            try {
                WebElement randomElement = driver.findElement(By.cssSelector("#nuexista"));
            } catch (Exception e) {
                TakesScreenshot camera = (TakesScreenshot) driver;
                File screenshot = camera.getScreenshotAs(OutputType.FILE);

                try {
                    Files.move(screenshot, new File("src/test/resources/screenshot/test.png"));
                } catch (Exception e2) {
                    e.printStackTrace();

                    e.printStackTrace();
                }
            }
        }
    }