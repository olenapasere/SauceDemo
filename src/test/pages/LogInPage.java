package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// We need LogInPage just to hold objects

public class LogInPage extends BasePage {
    protected WebDriver driver;

    public LogInPage(WebDriver driver){
        super(driver);                                // to set up the driver
        this.driver = driver;
        PageFactory.initElements(driver, this);  // to connect LogInPage with BasePage
    }

    @FindBy(id = "user-name")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement logInBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMsg;

    public void logIn(String userType){
        String username = "";
        String password = "secret_sauce";

        switch (userType){
            case "standard":
                username = "standard_user";
                break;
            case "locked":
                username = "locked_out_user";
                break;
            default:
                System.out.println("Invalid username");
        }
        sendKeys(usernameField, username);
        sendKeys(passwordField, password);
        click(logInBtn);
    }
}