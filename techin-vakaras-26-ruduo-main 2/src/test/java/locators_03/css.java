package locators_03;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class css {
    @Test
    public void cssTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=product/search");
        driver.findElement(By.cssSelector("a")).click();
    }

    @Test
    void task(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
//        Isspausdint elemento (id=logo) teksta
        System.out.println(driver.findElement(By.id("logo")).getText());

        driver.findElement(By.cssSelector("#search button")).click();
//        driver.findElement(By.cssSelector(".fa-search")).click();
        driver.quit();

    }

//    ONLY By.cssSelector
    @Test
    void onlyCss() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        System.out.println(driver.findElement(By.cssSelector("#logo")).getText());
        driver.findElement(By.cssSelector("[name=search]")).sendKeys("abc");
        driver.findElement(By.cssSelector(".fa-search")).click();
        driver.findElement(By.cssSelector("[name=search]")).clear();
        driver.findElement(By.cssSelector("[name=search]")).sendKeys("iphone");
        driver.findElement(By.cssSelector("#search")).findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.cssSelector("#cart")).getText());
        System.out.println(driver.findElements(By.cssSelector(".product-thumb")).size());
        String iphonePrice = driver.findElement(By.cssSelector(".price")).getText();
        System.out.println(iphonePrice);
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("f-name");
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("l-name");
        driver.findElement(By.cssSelector("#input-email")).sendKeys("a@a.com");
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("123");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwqwqw");
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys("qwqwqw");
        driver.findElement(By.cssSelector("[name=agree]")).click();
        driver.findElements(By.cssSelector(".pull-right")).getLast()
                .findElements(By.cssSelector("input")).get(1).click();
        driver.quit();
    }

    //   ONLY By.xpath
    @Test
    void onlyXpath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");
        System.out.println(driver.findElement(By.xpath("//*[@id='logo']")).getText());
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@class='fa fa-search']")).click();
        driver.findElement(By.xpath("//*[@name='search']")).clear();
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("iphone");
        driver.findElement(By.xpath("//*[@id='search']")).findElement(By.tagName("button")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id='cart']")).getText());
        System.out.println(driver.findElements(By.xpath("//*[@class='product-thumb']")).size());
        String iphonePrice = driver.findElement(By.xpath("//*[@class='price']")).getText();
        System.out.println(iphonePrice);
        driver.get("https://opencart.abstracta.us/index.php?route=account/register");
        driver.findElement(By.xpath("//*[@id='input-firstname']")).sendKeys("f-name");
        driver.findElement(By.xpath("//*[@id='input-lastname']")).sendKeys("l-name");
        driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("a@a.com");
        driver.findElement(By.xpath("//*[@id='input-telephone']")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id='input-password']")).sendKeys("qwqwqw");
        driver.findElement(By.xpath("//*[@id='input-confirm']")).sendKeys("qwqwqw");
        driver.findElement(By.xpath("//*[@name='agree']")).click();
        driver.findElements(By.xpath("//*[@class='pull-right']")).getLast()
                .findElements(By.xpath("//input")).get(1).click();
        driver.quit();
    }
}
