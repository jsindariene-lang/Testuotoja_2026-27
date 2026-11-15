import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h2")
    private WebElement MyAccountTitle;

    public String getMyAccountTitle()
    {
       return MyAccountTitle.getText();
    }

}
