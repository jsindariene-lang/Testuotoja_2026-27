package Waiters_07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class waitersTest {

    @Test
    public void waitersTest() {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://demoqa.com/progress-bar");
        driver.findElement(By.xpath("//button[@id='startStopButton']")).click();

        assertTrue(driver.findElement(By.id("resetButton")).isDisplayed());
        String expected = "100%";
        String actual = driver.findElement(By.xpath("//*[@role='progressbar']")).getText();
        assertEquals(expected, actual);


    }

 @Test
    public void waitersTest2() {
        WebDriver driver = new ChromeDriver();

     driver.get("https://demoqa.com/progress-bar");
     driver.findElement(By.xpath("//button[@id='startStopButton']")).click();

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     wait.until(ExpectedConditions.textToBe(By.xpath("//*[@role='progressbar']"), "100%"));

     assertTrue(driver.findElement(By.id("resetButton")).isDisplayed());
     String expected = "100%";
     String actual = driver.findElement(By.xpath("//*[@role='progressbar']")).getText();
     assertEquals(expected, actual);
    }

    @Test
    public void waitersTest3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enable After
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#enableAfter")));
        String expectedResult = "true";
        String actualResult = String.valueOf(button.isEnabled());
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual: " + actualResult);
        Assertions.assertEquals(expectedResult, actualResult);

        // Color Change
        WebElement colorButton = driver.findElement(By.cssSelector("#colorChange"));

        String expectedColor = colorButton.getCssValue("color");

        wait.until(webDriver ->
                !colorButton.getCssValue("color").equals(expectedColor));

        String actualColor = colorButton.getCssValue("color");

        System.out.println("Expected: " + expectedColor);
        System.out.println("Actual: " + actualColor);

        Assertions.assertNotEquals(expectedColor, actualColor);

        // Visible After
        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));
        String expectedVisibleText = "Visible After 5 Seconds";
        String actualVisibleText = visibleButton.getText();
        System.out.println("Expected: " + expectedVisibleText);
        System.out.println("Actual: " + actualVisibleText);
        Assertions.assertEquals(expectedVisibleText, actualVisibleText);

        driver.quit();

    }
}

