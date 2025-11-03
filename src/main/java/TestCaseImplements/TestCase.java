package TestCaseImplements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class TestCase {

    protected static WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod(alwaysRun = true) //ANTES DE CADA TEST ABRE LA URL
    public void beforeMethod(){
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterMethod(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass(){ //Cierra navegador una vez terminada toda la clase
        if (driver != null){
            driver.quit();
        }
    }
}
