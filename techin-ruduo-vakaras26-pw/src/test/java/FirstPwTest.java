import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

public class FirstPwTest extends BaseTest{
    @Test
    public void firstTest() {

        // Expect a title "to contain" a substring.
        PlaywrightAssertions.assertThat(page).hasTitle(Pattern.compile("Playwright"));

        // create a locator
        Locator getStarted = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Get Started"));
//        galima ir css (+) ar xpath
        Locator as = page.locator("//a[@href='/docs/intro']");

        // Expect an attribute "to be strictly equal" to the value.
        PlaywrightAssertions.assertThat(getStarted).hasAttribute("href", "/docs/intro");

        getStarted.click();

        // Expects page to have a heading with the name of Installation.
        PlaywrightAssertions.assertThat(page.getByRole(AriaRole.HEADING,
                new Page.GetByRoleOptions().setName("Installation"))).isVisible();

    }
    //upload trace https://trace.playwright.dev/
}


