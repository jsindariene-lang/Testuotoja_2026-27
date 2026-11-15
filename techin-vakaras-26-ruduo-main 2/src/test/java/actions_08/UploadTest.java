package actions_08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadTest {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void Upload() {
        WebElement input = driver.findElement(By.cssSelector("input"));
    }


}

