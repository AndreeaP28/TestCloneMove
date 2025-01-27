package org.example;

import org.example.pageobjects.InventoryPage;
import org.example.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @Parameters("viewMode") // Declaram paramatrul din fisierul XML
    @BeforeClass
    public void setUp(String viewMode){
        super.setUp(viewMode); // fac apel la clasa de baza setUp cu paramatrul de viewMode
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void testInvalidLogin(){
        loginPage.navigateTo();
        loginPage.enterUsername("invalid_username");
        loginPage.enterPassword("invalid_password");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertNotNull(errorMessage, "Mesajul de eroare nu a aparut");
        Assert.assertEquals(errorMessage, "Epic sadface: Usernames and password do not match any user in this service",
                "Textul erorii nu este cel asteptat");
    }

    @DataProvider(name = "validCredentials")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "standard_user", "secret_sauce"},
                { "problem_user", "secret_sauce" },
                { "performance_glitch_user", "secret_sauce" }
        };
    }

    @Test(dataProvider = "validCredentials")
    public void testValidLogin(String user, String parola){
        loginPage.navigateTo();
        loginPage.enterUsername(user);
        loginPage.enterPassword(parola);
        loginPage.clickLogin();
//        System.out.println("Url paginii luat cu driver: "  + driver.getCurrentUrl());
//        System.out.println("Url paginii luat din inventori page: "  + inventoryPage.getPageUrl());

        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageUrl(), "Nu am fost redirectionati pe pagina asteptata");
    }


}

