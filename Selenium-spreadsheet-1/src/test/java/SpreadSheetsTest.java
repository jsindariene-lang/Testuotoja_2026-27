import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpreadSheetsTest extends BaseTest {
    @Test
    void addCellText() {
        mainPage.typeToCell("A1", "text");

        verifyCellText("A1", "text");
    }

    private void verifyCellText(String cell, String expectedText) {
        String actualText = mainPage.getCellText(cell);
        Assertions.assertEquals(expectedText, actualText);
    }


    @Test
    void addCell() {
        // Paspaudžiame ant pliuso
        mainPage.insertSheet();

        // Laukiame, kol atsiras Sheet2
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

      //  WebElement sheet2 = wait.until(
              //  ExpectedConditions.visibilityOfElementLocated(
                       // By.xpath("//button[normalize-space()='Sheet2']")));

        // Patikriname, ar Sheet2 matomas
       // mainPage.getSheet2 
        String actualText = driver.findElement(
                By.xpath("//*[normalize-space()='Sheet2']")
        ).getText();

        String expectedText = "Sheet2";
        Assertions.assertEquals(expectedText, actualText);
    }

}
