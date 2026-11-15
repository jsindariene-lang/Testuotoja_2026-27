package actions_08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.awt.*;

public class ActionsTest {
    WebDriver driver;
   // @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("http://demoqa.com/buttons");
    }
    @Test
    public void clickButton() {
        Actions actions = new Actions(driver);
        WebElement buttonToWorkWith = driver.findElement(By.cssSelector("#doubleClickBtn"));
        actions.doubleClick(buttonToWorkWith).perform();
        WebElement button2 = driver.findElement(By.cssSelector("#rightClickBtn"));
        actions.contextClick(button2).perform();
    }

   // @AfterEach
   // public void teardown() {
   //     driver.quit();
   // }

    //@BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }
    @Test
    public void contextMenu() {
        Actions actions = new Actions(driver);
        WebElement button4 = driver.findElement(By.cssSelector("#hot-spot"));
        actions.contextClick(button4).perform();
        Alert alert = driver.switchTo().alert();
        String expectedText = "You selected a context menu";
        String actualText = alert.getText();
        Assertions.assertEquals(expectedText, actualText);
        System.out.println("Expected: " + expectedText);
        System.out.println("Actual: " + actualText);
        alert.accept();
    }

   // https://the-internet.herokuapp.com/upload isiakinti kaip uploadint faila

   // @BeforeEach
    public void dragAndDrop() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    }
    @Test
    public void drag() {
        Actions actions = new Actions(driver);
        WebElement button5 = driver.findElement(By.cssSelector("#column-a"));
        WebElement button6 = driver.findElement(By.cssSelector("#column-b"));
        actions.dragAndDrop(button5, button6).perform();
        driver.quit();
    }

   // https://the-internet.herokuapp.com/hovers hoverinam ir asertinam kad not found

   // @BeforeEach
    public void hoverUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");
    }
    @Test
    public void hover() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".figure"))).perform();
        driver.findElement(By.linkText("View profile")).click();
        String expectedText = "Not Found";
        String actualText = driver.findElement(By.cssSelector("h1")).getText();
        Assertions.assertEquals(expectedText, actualText);
        driver.quit();
    }

    //https://the-internet.herokuapp.com/dropdown isirinkti option1 ir patikrint kad pavyko
     @BeforeEach
    public void dropdown() {
         driver = new ChromeDriver();
         driver.get("https://the-internet.herokuapp.com/dropdown");
     }
     @AfterEach
     public void tearDown() {
        driver.quit();
     }
     @Test
    public void Dropdown() {
        Select dropdown = new Select(driver.findElement(By.cssSelector("#dropdown")));
        dropdown.selectByVisibleText("Option 1");
         String expectedOption = "Option 1";
         String actualOption = dropdown.getFirstSelectedOption().getText();
         Assertions.assertEquals(expectedOption, actualOption);
     }
}





