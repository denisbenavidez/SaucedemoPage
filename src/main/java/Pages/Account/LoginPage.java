package Pages.Account;

import Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "user-name")
    private WebElement usernameInput;

    @FindBy (id = "password")
    private WebElement passwordInput;

    @FindBy (id = "login-button")
    private WebElement loginBtn;

    @FindBy (xpath = "//h3[@data-test='error']")
    private WebElement errorMsgUser;

    public void executeLogin (String username, String password){
        this.findElement(usernameInput).sendKeys(username);
        this.findElement(passwordInput).sendKeys(password);
        this.findElement(loginBtn).click();
    }

    public String getErrorMsgLockedOutUser(){
        return this.findElement(errorMsgUser).getText();
    }
}
