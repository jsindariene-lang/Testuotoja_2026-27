package assertions_05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class aaaTest {
    @Test
    public void cssTest() {
        // RegisterTEST
        String a = "a";
        String b = "b";
        String aa = "a";
        assertEquals(a, aa);


//        booolean
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        boolean isLogoDisplayed = driver.findElement(By.xpath("//a[normalize-space()='Your Store']")).isDisplayed();
//        Assertions.assertEquals(true,true);
   //     assertTrue(false);


        String city = "aaa";
        String street = "str";
        String number = "500";
        assertAll("Should return address of Oracle's headquarter",
                () -> assertEquals("Redwood Shores", city),
                () -> assertEquals("Oracle Parkway", street),
                () -> assertEquals("500", number)
        );

    }


    @Test
    public void alertTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1. open https://opencart.abstracta.us/index.php?route=common/home

        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

        //  2. Atspausdina pirmos prekes kaina
        System.out.println(driver.findElement(By.xpath("//*[@class='price']")).getText());
        // ASSERT: patikrint kaina
        String expectedPrice = "$602.00\nEx Tax: $500.00";
        String actualPrice = driver.findElement(By.xpath("//*[@class='price']")).getText();
        assertEquals(expectedPrice, driver.findElement(By.xpath("//*[@class='price']")).getText());
        org.assertj.core.api.Assertions.assertThat(actualPrice).isEqualTo(expectedPrice);

        // 3. keiciam valiuta i eurus (virsuje, kaireje)
        driver.findElement(By.xpath("//*[contains(text(), 'Currency')]")).click();
        driver.findElement(By.xpath("//*[contains(text(), '€ Euro')]")).click();
        Thread.sleep(1000);
        // ASSERT: patikrint kad valiuta pasikeite
        String expectedCurrency = "€";
        String actualCurrency = driver.findElement(By.cssSelector("#form-currency strong")).getText();
        assertEquals(expectedCurrency, actualCurrency);
        org.assertj.core.api.Assertions.assertThat(actualCurrency).isEqualTo(expectedCurrency);

        // 4. Atspausdina pirmos prekes kaina
        System.out.println(driver.findElement(By.xpath("//*[@class='price']")).getText());
        // ASSERT: patikrint kaina
        String expected = "€";
        String actual = driver.findElement(By.xpath("//*[@class='price']")).getText();
        assertEquals(expected, actual);
        org.assertj.core.api.Assertions.assertThat(driver.findElement(By.xpath("//*[@class='price']")).isDisplayed());



        // 5. Pridedam antra preke i krepseli
        driver.findElements(By.xpath("//*[contains(text(), 'Add to Cart')]")).get(1).click();
        // ASSERT: patikrinam kad prideta
        String expectedWordToContain = "iPhone";
        String actualMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
        org.assertj.core.api.Assertions.assertThat(actualMessage).contains(expectedWordToContain);


        // 6. Atspausdinam zalia pranesima kad preke ideta i krepseli
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector(".alert-dismissible")).getText());
        // ASSERT: patikrinam kad atsairado zalias pranesimas
        String expectedWord = "iPhone";
        String actualMessage1 = driver.findElement(By.cssSelector(".alert-success")).getText();
        assertEquals(expectedWord, actualMessage1);
        org.assertj.core.api.Assertions.assertThat(actualMessage1).contains(expectedWord);


        // 7. Uzdarom ta pranesima
        driver.findElement(By.cssSelector(".close")).click();

        // ASSERT: patikrinam pranesimo nesimato
        assertTrue(driver.findElements(By.cssSelector(".alert-success")).isEmpty());
        org.assertj.core.api.Assertions.assertThat(driver.findElements(By.cssSelector(".alert-success"))).isEmpty();



        // 8. Idedam Canon EOS 5D i wishlist (spaudziam sirdute)
        driver.findElement(By.xpath("//a[text()='Canon EOS 5D']" +
                "    /ancestor::div[contains(@class,'product-thumb')]" +
                "    //button[@data-original-title='Add to Wish List']")).click();
        // ASSERT: patikrinam kad atsairado zalias pranesimas
        WebElement successAlert = driver.findElement(
                By.xpath("//div[contains(@class,'alert-success')]"));

        Assertions.assertTrue(successAlert.getText().contains("Canon EOS 5D"));

        // 9. pridedam Canon EOS 5D i product comparison
        driver.findElement(By.xpath("//div[contains(@class,'product-thumb')]" +
                "[.//a[contains(text(),'Canon EOS 5D')]]" +
                "//button[@data-original-title='Compare this Product']")).click();
        // 10. einam i product comparison
        driver.findElement(By.xpath("//a[contains(@href,'product/compare')]")).click();
        // ASSERT: patikrinam kad prisidejo Canon EOS 5D

        // 11. Spausdinam product comparison esancios prekes pavadinima
        System.out.println(driver.findElement(By.xpath("//td[text()='Product']/following-sibling::td//strong")).getText());
        driver.quit();
    }
}












