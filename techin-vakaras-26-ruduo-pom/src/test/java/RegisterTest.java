import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest extends BaseTest {
    HomePage homePage;
    RegisterPage registerPage;

    //1. Nukeliauti i home page
    @Test
    public void registerTest(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);


        //2. Paspausti My Accaunt
        homePage.clickMyAccount();

        //3.Paspausti Register
        homePage.clickRegister();

        //4. Uzpildyti visus privalomus laukus ir sukurti Register page

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("input-firstname")));
        registerPage.fillFirstName("Julija");
        registerPage.fillLastName("Sindariene");
        registerPage.fillEmail("vardas@gmail.com");
        registerPage.fillTelephone("1234567890");

    }


}


