package functional_tests;

import baseitems.Locators;
import basetestitems.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void testHomePageLoads() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();
            homePage.clickOnSignInButton();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.fillUserNameField(Locators.VALID_EMAIL);
            loginPage.fillPasswordField(Locators.INVALID_PWD);
            loginPage.clickOnSignInButton();
            String expectedError1 = "Unfortunately we do not recognise those details.";
            Assertions.assertEquals(expectedError1, loginPage.getErrorText());
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
