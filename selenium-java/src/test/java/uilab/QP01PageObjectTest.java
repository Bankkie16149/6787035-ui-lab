package uilab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import uilab.pages.AdminPage;
import uilab.pages.HomePage;

class QP01PageObjectTest extends BaseTest {

    // QP-01 with page objects: a custom pizza keeps its restrictions,
    // rating it needs a login, and the admin sees the new pizza.
    @Test
    void customPizzaReachesTheAdminList() {
        String stamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String pizzaName = "Lab Pizza " + stamp;
        HomePage home = new HomePage(driver, wait);
        AdminPage admin = new AdminPage(driver, wait);

        home.open();                                        // step 1
        assertEquals("Looking to break out of your pizza routine?",
                home.heading());
        home.showAdvanced();                                // step 2
        home.setMaxCalories(600);                           // step 3
        assertEquals("600", home.maxCalories());
        home.excludeTool("Knife");
        home.mustBeVegetarian();
        home.nameThePizza(pizzaName);
        shot(stamp + "/step-3");
        home.askForPizza();                                 // step 4
        assertEquals(pizzaName, home.result("Name: "));
        String tool = home.result("Tool: ");
        assertNotEquals("Knife", tool);
        int perSlice =
                Integer.parseInt(home.result("Calories per slice: "));
        assertTrue(perSlice <= 600, "calories per slice: " + perSlice);
        shot(stamp + "/step-4");
        assertEquals("Please log in first.", home.loveIt());  // step 5
        shot(stamp + "/step-5");

        admin.open();                                       // step 6
        admin.logIn("admin", "admin");
        String line = admin.lineFor(pizzaName);             // step 7
        assertTrue(line.contains("(tool=" + tool + ","), line);
        shot(stamp + "/step-7");
    }
}
