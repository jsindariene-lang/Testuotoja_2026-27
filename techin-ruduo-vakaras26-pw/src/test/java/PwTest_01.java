import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PwTest_01 extends BaseTest{
    @Test
    public void pwTest_01(){

       // Atidarom
        page.navigate("https://copilot-spreadsheet-app.vercel.app/");

        // isjungiam auto save (settings)
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Settings")).click();
        page.locator("label:has-text('Auto Save')").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close settings")).click();

        //parasom kazka i cell
        //page.keyboard().type("hello");
        //page.keyboard().press("Enter");

        page.getByRole(AriaRole.GRIDCELL).first().dblclick();
        page.keyboard().type("hello");
        page.locator("td.cell.selected.active").press("Enter");

        //patikrinam kad yra uzrasas "Unsaved changes"
        assertThat(page.getByText("Unsaved changes")).isVisible();

        //spaudziam save
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();

        //patikrinam kad uzraso nebera
        page.locator("[data-cell='A1']").click();
        page.keyboard().press("Delete");
        assertThat( page.locator("[data-cell='A1']")).isEmpty();

        // save mygtukas disabled

    }



}
