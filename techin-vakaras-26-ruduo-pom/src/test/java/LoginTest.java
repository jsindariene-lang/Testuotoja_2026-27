import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;


    @Test
    public void userCanLogin() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccount();
        homePage.clickLogin();
        loginPage.typeEmail("your.email+fakedata79434@gmail.com");
        loginPage.typePassword("fc01WsZ77HP2jn6");
        loginPage.clickLoginButton();
        myAccountPage.getMyAccountTitle();
        String expectedTitle = "My Account";
        String actualTitle = myAccountPage.getMyAccountTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);

    }
    @Test
    public void userCantLoginIncorrect() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccount();
        homePage.clickLogin();
        loginPage.typeEmail("your.email+fakedata79434@gmail.comx");
        loginPage.typePassword("fc01WsZ77HP2jn6x");
        loginPage.clickLoginButton();

        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = loginPage.getAlertText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }

    @Test
    public void userIncorrectPassword() {
        homePage = new HomePage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        myAccountPage = new MyAccountPage(driver);

        homePage.clickMyAccount();
        homePage.clickLogin();
        loginPage.typeEmail("your.email+fakedata79434@gmail.com");
        loginPage.typePassword("fc01WsZ77HP2jn6x");
        loginPage.clickLoginButton();

        String expectedWarning = "Warning: No match for E-Mail Address and/or Password.";
        String actualWarning = loginPage.getAlertText();
        Assertions.assertEquals(expectedWarning, actualWarning);
    }
}
