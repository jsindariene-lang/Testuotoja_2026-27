import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
