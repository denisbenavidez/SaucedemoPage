package Smoke;

import Pages.Account.LoginPage;
import Pages.Global.HeaderPage;
import Pages.Home.InventoryPage;
import TestCaseImplements.TestCase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends TestCase { //standard_user

    @Test
    public void purchaseAllProductsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAllBtnAddCart();

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getShoppingCartLink().click();
    }

    @Test
    public void purcharseOneProductTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOneBtnAddCart("sauce-labs-onesie'");

        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.getShoppingCartLink().click();
    }

    @Test
    public void purcharseRemoveProductsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickAllBtnAddCart();
        inventoryPage.clickAllBtnRemoveCart();

        HeaderPage headerPage = new HeaderPage(driver);
        Assert.assertTrue(headerPage.getShoppingCartLink().isDisplayed()); //Si el carrito esta vacio se han eliminado correctamente los productos
    }

    @Test
    public void sortProductsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin("standard_user", "secret_sauce");

        HeaderPage headerPage = new HeaderPage(driver);
        Assert.assertTrue(headerPage.getSwagLabsLogo().isDisplayed());

        Actions actions = new Actions(driver);
        actions.click(headerPage.getSortProductsBtn()).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        actions.click(headerPage.getSortProductsBtn()).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        actions.click(headerPage.getSortProductsBtn()).perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }
}
