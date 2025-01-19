package com.skillbrain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TemaB2  extends BaseTest{

    @Test
    public  void PageProtection() {

        //go to url
        driver.get("https://testpages.eviltester.com/styled/index.html");

        //dau click pe linkul Basic Authentication Page Protected
        WebElement pageProtected = driver.findElement(By.cssSelector(".page-body h1 "));
        pageProtected.click();

        // instructiuni pentru acces
        WebElement instructions = driver.findElement(By.cssSelector(".page-body p:nth-child(7) > a "));
        System.out.println(" Instructiunile sunt  urmatoarele : " + instructions);

        // Oprim executia testtului pentru a putea vedea stadiul final al paginii
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void windowsLinkTest(){

        //navighez catre url dorit
        driver.get("https://testpages.eviltester.com/styled/index.html");

        // dau click pe linkul de windows link test
        WebElement linkTest = driver.findElement(By.cssSelector(" .page-body > h1"));
        linkTest.click();

        //printam titlul paginii deschise
        WebElement pageTitle = driver.findElement(By.cssSelector(".page-body h1 "));
        System.out.println(" Titlul paginii este : " + pageTitle.getText() );

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
