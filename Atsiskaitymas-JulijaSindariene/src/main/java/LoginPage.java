import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardTitle;

    @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String usernameText) {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.clear();
        username.sendKeys(usernameText);
    }

    public void typePassword(String passwordText) {
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(passwordText);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    public String getDashboardTitle() {
        return wait.until(
                ExpectedConditions.visibilityOf(dashboardTitle)
        ).getText();
    }

    public String getErrorMessage() {
        return wait.until(
                ExpectedConditions.visibilityOf(errorMessage)
        ).getText();
    }
}



