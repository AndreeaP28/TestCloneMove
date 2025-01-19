package com.skillbrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElementsExercises extends BaseTest {

    @Test
    public void testElementeCheckBox() {
        // Go to test URL
        driver.get("https://the-internet.herokuapp.com/");

        // Verificarea titlului paginii
        String expectedTabTitle = "The Internet";
        String actualTabTitle = driver.getTitle();
        System.out.println("Titlul tabului paginii este: " + actualTabTitle);
        Assert.assertEquals(actualTabTitle, expectedTabTitle, "[1] Tabul paginii nu este cel asteptat de noi");

        // Ne gasim elementul de link checkboxes si dam click pe acesta
        WebElement checkboxesLink = driver.findElement(By.linkText("Checkboxes"));
        checkboxesLink.click();

        // ne cautam toate elementele de pe pagina
        WebElement titluPaginii = driver.findElement(By.cssSelector("#content h3"));
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        // interactionam cu elementele de pe pagina
        System.out.println("Titlul paginii este: " + titluPaginii.getText());
        //checkbox1.click();
        checkbox2.click();

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testForgotPassword() {
        // Go to test URL
        driver.get("https://the-internet.herokuapp.com/");

        // Verificarea titlului paginii
        String expectedTabTitle = "The Internet";
        String actualTabTitle = driver.getTitle();
        System.out.println("Titlul tabului paginii este: " + actualTabTitle);
        Assert.assertEquals(actualTabTitle, expectedTabTitle, "[1] Tabul paginii nu este cel asteptat de noi");

        // Ne gasim elementul de link checkboxes si dam click pe acesta
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        // ne cautam elementele de pe pagina
        WebElement titlulPaginii = driver.findElement(By.cssSelector("#content h2"));
        WebElement textulInputului = driver.findElement(By.cssSelector("#forgot_password label"));
        WebElement inputElement = driver.findElement(By.cssSelector("#forgot_password #email"));
        WebElement buttonRetrievePassword = driver.findElement(By.cssSelector("#form_submit"));

        // intercationam cu elementele de pe pagina
        System.out.println("Titlul paginii este: " + titlulPaginii.getText());
        System.out.println("Textul inputului este: " + textulInputului.getText());
        inputElement.sendKeys("text introdus");

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonRetrievePassword.click();

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddRemoveElements() {
        // Go to test URL
        driver.get("https://the-internet.herokuapp.com/");

        // Verificarea titlului paginii
        String expectedTabTitle = "The Internet";
        String actualTabTitle = driver.getTitle();
        System.out.println("Titlul tabului paginii este: " + actualTabTitle);
        Assert.assertEquals(actualTabTitle, expectedTabTitle, "[1] Tabul paginii nu este cel asteptat de noi");

        // Ne gasim elementul de link checkboxes si dam click pe acesta
        WebElement addRemoveElementsLink = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveElementsLink.click();

        // ne cautam elementele de pe pagina
        WebElement titltulPaginii = driver.findElement(By.cssSelector("#content h3"));
        WebElement addButton = driver.findElement(By.cssSelector("#content > div > button"));
        try {
            WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button:nth-child(1)"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // interactiona cu elementele de pe pagina
        System.out.println("Titlul Paginii este: " + titltulPaginii.getText());
        addButton.click();
        addButton.click();
        addButton.click();

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            WebElement deleteButton = driver.findElement(By.cssSelector("#elements > button:nth-child(2)"));
            deleteButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }


        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemaEx1() {
        // Go to test URL
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // Navighez pe primul link de testat
        WebElement link1 = driver.findElement(By.cssSelector("#basicpagetest"));
        link1.click();

        // Cautam elementele de pe pagina si interactionam cu acestea
        WebElement titlulPaginii = driver.findElement(By.cssSelector(".page-body h1"));
        System.out.println("Titlul paginii este: " + titlulPaginii.getText());

        WebElement explanation = driver.findElement(By.cssSelector(".page-body .explanation"));
        System.out.println("Textul elementului explanation este: " + explanation.getText());

        WebElement footerlink1 = driver.findElement(By.linkText("EvilTester.com"));
        footerlink1.click();

        WebElement footerlink2 = driver.findElement(By.linkText("Compendium Developments"));
        footerlink2.click();

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemaEx2() {
        // Go to test URL
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // Navighez pe primul link de testat
        WebElement link2 = driver.findElement(By.linkText("Element Attributes Examples"));
        link2.click();

        // Cautam elementele de pe pagina si interactionam cu acestea
        try {
            WebElement subTitlu1 = driver.findElement(By.xpath("html/body/div[1]/h2[1]"));
            System.out.println("Primul subtitlu este: " + subTitlu1.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement paragraphAttribute = driver.findElement(By.cssSelector(".page-body #domattributes"));
        System.out.println("Textul paragrafului 1 este: " + paragraphAttribute.getText());

        WebElement paragraphDynamicJS = driver.findElement(By.cssSelector("#jsattributes"));
        System.out.println("Textul paragrafului 2 este: " + paragraphDynamicJS.getText());

        WebElement paragraphAutoAttributes = driver.findElement(By.cssSelector("#jsautoattributes"));
        System.out.println("Textul paragrafului 3 este: " + paragraphAutoAttributes.getText());


        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTemaEx3() {
        // Go to test URL
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // Navighez pe primul link de testat
        WebElement link3 = driver.findElement(By.cssSelector("#findbytest"));
        link3.click();

        // Cautam elementele de pe pagina si interactionam cu acestea
        WebElement paragraf1Xpath = driver.findElement(By.xpath("/html/body/div[2]/p[1]"));
        System.out.println("Textul paragrafului 1 este cu locator xpath: " + paragraf1Xpath.getText());

        WebElement paragraf1ID = driver.findElement(By.id("p1"));
        System.out.println("Textul paragrafului 1 este cu locator id: " + paragraf1ID.getText());

        WebElement paragrafCss = driver.findElement(By.cssSelector("p[name=\"pName1\"]"));
        System.out.println("Textul paragrafului 1 este cu locator css: " + paragrafCss.getText());

        WebElement paragrafNestedDivXpath = driver.findElement(By.xpath("/html/body/div[2]/div[1]/p"));
        System.out.println("Textul paragrafului 1 din seria de nested div este(xpath): " + paragrafNestedDivXpath.getText());

        WebElement paragrafNestedDivID = driver.findElement(By.id("p26"));
        System.out.println("Textul paragrafului 1 din seria de nested div este(id): " + paragrafNestedDivID.getText());

        WebElement paragrafNestedDivCss = driver.findElement(By.cssSelector("#p26"));
        System.out.println("Textul paragrafului 1 din seria de nested div este(css): " + paragrafNestedDivCss.getText());

        WebElement paragrafNestedDivCss2 = driver.findElement(By.cssSelector("p[name=\"pName26\"]"));
        System.out.println("Textul paragrafului 1 din seria de nested div este(css2): " + paragrafNestedDivCss2.getText());


        WebElement link2Xpath = driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/li[2]/a"));
        scrollToElement(driver, link2Xpath);
        link2Xpath.click();

        WebElement link2Id = driver.findElement(By.id("a27"));
        scrollToElement(driver, link2Xpath);
        link2Id.click();

        WebElement link2Css = driver.findElement(By.cssSelector("a[name=\"aName27\"]"));
        scrollToElement(driver, link2Css);
        link2Css.click();

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void scrollToElement(WebDriver driver, WebElement link2Xpath) {
    }


    @Test
    public void testTemaEx4() {
        // Go to test URL
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // Navighez pe primul link de testat
        WebElement link4 = driver.findElement(By.cssSelector("#webdriverexamplepage"));
        link4.click();

        // Cautam elementele de pe pagina si interactionam cu acestea
        WebElement listElement1 = driver.findElement(By.cssSelector("#main-example-list [data-locator=\"li1\"]"));
        System.out.println("Textul primului element din lista este: " + listElement1.getText());

        WebElement listElement3 = driver.findElement(By.cssSelector("#main-example-list [data-locator=\"li3\"]"));
        System.out.println("Textul celui de al treilea element din lista este: " + listElement3.getText());

        WebElement formInput = driver.findElement(By.cssSelector("#numentry"));
        formInput.sendKeys("1 2 3 4");

        WebElement inputMessage = driver.findElement(By.cssSelector("#message"));
        Assert.assertTrue(inputMessage.getText().isEmpty(), "Apare text pe element");

        WebElement showAsParaButton = driver.findElement(By.cssSelector("#show-as-para"));
        showAsParaButton.click();

        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        inputMessage = driver.findElement(By.cssSelector("#message"));
        System.out.println("Textul din input message este: " + inputMessage.getText());
        Assert.assertFalse(inputMessage.getText().isEmpty(), "Nu apare text pe element");

        WebElement showAsAlertButton = driver.findElement(By.cssSelector("#show-as-alert"));
        showAsAlertButton.click();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Textul din alert este: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        WebElement showFromLink = driver.findElement(By.cssSelector("#clickable-link"));
        showFromLink.click();
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        inputMessage = driver.findElement(By.cssSelector("#message"));
        System.out.println("Textul din input message este dupa apasarea linkului: " + inputMessage.getText());

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
