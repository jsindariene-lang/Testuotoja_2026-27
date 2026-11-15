import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://copilot-spreadsheet-app.vercel.app/");
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void tearDown() {
        // Teardown code here
        driver.quit();
    }
}
