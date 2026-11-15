import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "#add-sheet-button")
    private WebElement addSheetButton;


    public WebElement getCell(String coord) {
        return driver.findElement(By.cssSelector("[data-cell='" + coord + "']"));
    }

    public void typeToCell(String coord, String text) {
        WebElement cell = getCell(coord);
        new Actions(driver).doubleClick(cell).perform();
        cell.findElement(By.cssSelector("input")).sendKeys(text+ Keys.ENTER);
    }

    public String getCellText(String coord) {
        return getCell(coord).getText();
    }

    public void insertSheet() {
        addSheetButton.click();
    }

    public void
}
