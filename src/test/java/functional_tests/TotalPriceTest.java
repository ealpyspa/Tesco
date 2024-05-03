package functional_tests;

import baseitems.Locators;
import basetestitems.BaseTest;
import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

//Flaky test, it depends on the prices on the website

public class TotalPriceTest extends BaseTest {
    @Test
    public void testTotalPriceCalculation() {
        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();
            homePage.clickOnSignInButton();
            loginPage.login(Locators.VALID_EMAIL, Locators.VALID_PASSWORD);
            homePage.clickOnFruitAndVegetablesTab();
            homePage.clickOnAllFruitAndVegetablesTab();
            homePage.addBananaToBasket();
            homePage.addCucumberToBasket();
            homePage.clickOnBasketButton();
            Thread.sleep(999);

            String expectedTotalPrice = "257";
            String actualTotalPrice = homePage.getTotalPrice();
            Thread.sleep(2000);

            Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);

            homePage.removeCucumber();
            Thread.sleep(2000);
            homePage.removeBanana();
            Thread.sleep(2000);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
