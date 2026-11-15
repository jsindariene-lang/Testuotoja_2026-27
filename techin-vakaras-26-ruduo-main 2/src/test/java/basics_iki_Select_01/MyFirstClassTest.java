package basics_iki_Select_01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class MyFirstClassTest {
    @Test
    void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        driver.findElement(By.name("search")).sendKeys("test");

        System.out.println(
                driver.findElements(By.tagName("a")).size()
        );
        driver.quit();
    }

    @Test
    void task(){
        WebDriver driver = new ChromeDriver();
        // 2. Open page
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
       // 3. Click on wishlist
        driver.findElement(By.xpath("//*[@id='wishlist-total']")).click();
       // 4. Count and print a number ofseach boxes
        System.out.println(driver.findElements(By.xpath("//input[@name='search']")).size());
       // 5. Find element of email input field and enter email “email@email.com”
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("email@email.com");
        // 6.Clear previous field
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        // 7.Click Login
        driver.findElement(By.xpath("//*[@class='list-group-item']")).click();
        // 8.Click on register a new customer
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        // 9.Check if the field to input password is enabled and print the result
        System.out.println(driver.findElement(By.xpath("//*[@id='input-password']")).isEnabled());
        // 10.Check if cart element is displayed and print the result
        System.out.println(driver.findElement(By.xpath("//*[@id='cart']")).isDisplayed());
        // 11. Check if agree checkbox is selected and print the result
        System.out.println(driver.findElement(By.xpath("//*[@name='agree']")).isSelected());
        // 12. Go to top menu -> Desktops
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        driver.findElement(By.xpath("//a[text()='Show All Desktops']")).click();
        // 13. Select to show 25 items per page
        Select showItems = new Select(
                driver.findElement(By.xpath("//*[@id='input-limit']"))
        );

        showItems.selectByVisibleText("25");
        // 14. Print selected option from the dropbox

        showItems = new Select(
                driver.findElement(By.xpath("//*[@id='input-limit']"))
        );

        System.out.println(
                showItems.getFirstSelectedOption().getText()
        );
        // 15 .Select 4th option in show items per page dropbox
        driver.findElement(By.xpath("//*[@id='input-limit']"));
        showItems.selectByIndex(3);

        // 16.Print selected option
        showItems = new Select(
                driver.findElement(By.xpath("//*[@id='input-limit']"))
        );

        System.out.println(
                showItems.getFirstSelectedOption().getText()
        );

        // 17. Close the window
        driver.close();

    }

}
