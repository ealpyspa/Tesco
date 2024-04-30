package tests;

import basetestitems.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class PromotionsPageTest extends BaseTest {
    @Test
    public void testPromotionsPage() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();
            homePage.clickOnPromotionsTab();
            Assertions.assertTrue(driver.getCurrentUrl().contains("promotions"));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
