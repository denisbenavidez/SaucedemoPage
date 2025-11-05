package Pages.Home;

import Pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InventoryPage extends Page {
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//button[starts-with(@id, 'add-to-cart-')]")
    private List<WebElement> allAddCartBtn;

    @FindBy (xpath = "//button[starts-with(@id, 'remove-')]")
    private List<WebElement> allRemoveCartBtn;

    public List<WebElement> getAllAddCartBtn(){
        return allAddCartBtn;
    }

    public List <WebElement> getAllRemoveCartBtn(){
        return allRemoveCartBtn;
    }

    public void clickAllBtnAddCart(){
        for (WebElement addCartBtn : allAddCartBtn){
            addCartBtn.click();
        }
    }

    public void clickOneBtnAddCart(String productName){
        String xpath = "//button[starts-with(@id, 'add-to-cart-"+productName+")]";
        WebElement addOneCartBtn = driver.findElement(By.xpath(xpath));
        addOneCartBtn.click();
    }

    public void clickAllBtnRemoveCart(){
        for (WebElement removeCartBtn : allRemoveCartBtn){
            removeCartBtn.click();
        }
    }
}
