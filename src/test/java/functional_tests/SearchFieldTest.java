package functional_tests;

import basetestitems.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.HomePage;

public class SearchFieldTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"bread", "milk"})
    public void testSearchField(String product){
        try {
            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();

            homePage.fillSearchField(product);
            homePage.clickOnSearchButton();
            String currentUrl = driver.getCurrentUrl();
            Assertions.assertTrue(currentUrl.contains(product));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}
