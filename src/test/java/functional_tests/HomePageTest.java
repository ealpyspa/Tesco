package functional_tests;

import basetestitems.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageLoads() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();
            String expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
            String actualTitle = driver.getTitle();
            Assertions.assertEquals(expectedTitle, actualTitle);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}