package Smoke;

import Pages.Account.LoginPage;
import Pages.Global.HeaderPage;
import Pages.Home.InventoryPage;
import TestCaseImplements.TestCase;
import Util.DataProviderLogin;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestCase {

    @Test(dataProvider = "dataLogin", dataProviderClass = DataProviderLogin.class)
    public void LoginUsersWithProviderTest(String username, String password, int expectedLoginStatus) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.executeLogin(username, password);

        if (expectedLoginStatus == 1) { //LOGIN EXITOSO
            HeaderPage headerPage = new HeaderPage(driver);
            try {
                headerPage.fluentWaitElement(headerPage.getSwagLabsLogo());
                Assert.assertTrue(headerPage.getSwagLabsLogo().isDisplayed(), "Login exitoso para " + username);
            } catch (Exception e) {
                Assert.fail("Login debio ser exitoso para " + username + " pero no se pudo encontrar el logo");
            }
        } else if (expectedLoginStatus == 0) { //LOGIN FALLIDO POR USUARIO BLOQUEADO
            try {
                if (username.equals("locked_out_user")) {
                    Assert.assertEquals(loginPage.getErrorMsgLockedOutUser(), "Epic sadface: Sorry, this user has been locked out.");
                } else {
                    // Para cualquier otro fallo (credenciales incorrectas o vacías)
                    Assert.assertEquals(loginPage.getErrorMsgLockedOutUser(), "Epic sadface: Username and password do not match any user in this service" ,"Login incorrecto para credenciales inválidas.");
                }
            } catch (Exception e) {
                Assert.fail("El login fallo pero no se encontró el msg de error para " + username);
            }
        }
    }
}
