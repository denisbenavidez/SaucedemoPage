package Pages.Home;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends Page {
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (className = "app_logo")
    private WebElement SwagLabsLogo;

    public WebElement getSwagLabsLogo(){
        return this.findElement(SwagLabsLogo);
    }
}
