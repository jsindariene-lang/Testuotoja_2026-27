import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//a[contains(@href,'account/login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//*[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//a[contains(@href,'account/register')]")
    private WebElement registerLink;



    public void clickMyAccount(){
        myAccountLink.click();
    }

    public void clickLogin(){ loginLink.click();}

    public void clickRegister(){ registerLink.click();}

}

