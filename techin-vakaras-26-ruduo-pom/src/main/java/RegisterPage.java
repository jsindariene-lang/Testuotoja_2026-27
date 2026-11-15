import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#input-firstname")
    private WebElement firstNameField;

    @FindBy(css = "#input-lastname")
    private WebElement lastNameField;

    @FindBy(css = "#input-email")
    private WebElement emailField;

    @FindBy(css = "#input-telephone")
    private WebElement telephoneField;


    public void fillFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }
    public void fillLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void fillEmail(String email){
        emailField.sendKeys(email);
    }
    public void fillTelephone(String telephone){
        telephoneField.sendKeys(telephone);
    }
}
