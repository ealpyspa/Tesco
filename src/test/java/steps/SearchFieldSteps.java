package steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class SearchFieldSteps {
    private WebDriver driver;
    private HomePage homePage;

    @Before("@SearchField")
    public void setUp() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("I am on the Tesco homepage")
    public void iAmOnTheTescoHomepage() {
        homePage.openWebsite();
    }

    @And("I click on accept cookies button")
    public void iClickOnAcceptCookiesButton() {
        homePage.acceptCookies();
    }

    @When("I enter {string} into the search field")
    public void iEnterProductIntoTheSearchField(String product) {
        homePage.fillSearchField(product);
    }

    @And("I click on the search button")
    public void iClickOnTheSearchButton() {
        homePage.clickOnSearchButton();
    }

    @Then("the URL should contain {string}")
    public void theURLShouldContainProduct(String product) {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains(product));
    }

    @After("@SearchField")
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
