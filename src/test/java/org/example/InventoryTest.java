package org.example;
import org.example.pageobjects.InventoryPage;
import org.example.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{
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
    public void testVerifyAddToCart(){
        // ne logam cu un utilizator valid
        loginPage.navigateTo();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        // validam logarea
        Assert.assertEquals(driver.getCurrentUrl(), inventoryPage.getPageUrl(), "Nu am fost redirectionati pe pagina asteptata");
        // adaugam primul produs in cos
        inventoryPage.addFirstProductToCart();
        // validam icoana de la cos
        Assert.assertEquals(inventoryPage.getCartBadgeText(), "1", "Numarul de elemente din cos nu este corect");
        // daca incercam sa adaugam din nou primul produs, cu acelasi buton il vom scoate din cos
        inventoryPage.addFirstProductToCart();
        // validam icoana de la cos
        Assert.assertFalse(inventoryPage.isCartBadgeDisplayed(), "Icoana de produse apare si dupa ce am scos prdusul din cos!");
    }
}
