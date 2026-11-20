import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginPositiveTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLoginButton();

        assertEquals(
                "Dashboard",
                loginPage.getDashboardTitle()
        );
    }

    @Test
    public void loginNegativeTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.typeUsername("Admi");
        loginPage.typePassword("admin12");
        loginPage.clickLoginButton();

        assertEquals(
                "Invalid credentials",
                loginPage.getErrorMessage()
        );
    }
}
