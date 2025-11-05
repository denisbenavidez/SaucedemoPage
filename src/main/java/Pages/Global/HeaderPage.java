package Pages.Global;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends Page {

    public HeaderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "app_logo")
    private WebElement swagLabsLogo;

    @FindBy (className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy (className = "product_sort_container")
    private WebElement sortProductsBtn;

    public WebElement getSwagLabsLogo(){
        return this.findElement(swagLabsLogo);
    }

    public WebElement getShoppingCartLink(){
        return this.findElement(shoppingCartLink);
    }

    public WebElement getSortProductsBtn(){
        return this.findElement(sortProductsBtn);
    }
}
