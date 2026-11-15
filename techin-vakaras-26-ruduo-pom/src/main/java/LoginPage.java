import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@href,'account/login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//*[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(css = ".alert-danger")
     private  WebElement alert;


    public void typeEmail(String email) {
        emailField.sendKeys(email);
    }
    public void typePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }

    public String getAlertText() {
        return alert.getText();
    }
}
