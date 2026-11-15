package actions_08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsTest {
@Test
public void optionsTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--disable-gpu");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--disable-extensions");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-popup-blocking");
}
}
