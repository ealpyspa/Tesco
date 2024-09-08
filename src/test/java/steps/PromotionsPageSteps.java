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

public class PromotionsPageSteps {
    private WebDriver driver;
    private HomePage homePage;
    @Before("@PromotionsPage")
    public void setUp() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }
    @Given("I open Tesco home page")
    public void iOpenTescoHomePage() {
        homePage.openWebsite();
    }
    @And("I click on cookies button")
    public void iClickOnCookiesButton() {
        homePage.acceptCookies();
    }

    @When("I click on the Promotions tab")
    public void iClickOnThePromotionsTab() {
        homePage.clickOnPromotionsTab();
    }

    @Then("I should be on the Promotions page")
    public void iShouldBeOnThePromotionsPage() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("promotions"));
    }

    @After("@PromotionsPage")
    public void closeDriver() {
        DriverManager.quitDriver();
    }


}
