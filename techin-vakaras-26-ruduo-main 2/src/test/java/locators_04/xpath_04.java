package locators_04;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_04 {
@Test
    public void task() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // 1. open https://opencart.abstracta.us/index.php?route=common/home
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        // 2. Atspausdina pirmos prekes kaina
        System.out.println(driver.findElement(By.xpath("//*[@class='price']")).getText());

       //  3. keiciam valiuta i eurus (virsuje, kaireje)
        driver.findElement(By.xpath("//*[contains(text(), 'Currency')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), '€ Euro')]")).click();
        Thread.sleep(1000);

        // 4. Atspausdina pirmos prekes kaina
        System.out.println(driver.findElement(By.xpath("//*[@class='price']")).getText());

        //5. Pridedam antra preke i krepseli
        driver.findElements(By.xpath("//*[contains(text(), 'Add to Cart')]")).get(1).click();

        // 6. Atspausdinam zalia pranesima kad preke ideta i krepseli
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector(".alert-dismissible")).getText());

        // 7. Uzdarom ta pranesima
        driver.quit();
}
}
