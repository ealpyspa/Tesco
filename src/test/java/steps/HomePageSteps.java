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

public class HomePageSteps {

    private WebDriver driver;
    private HomePage homePage;
    private String expectedTitle;
    private String actualTitle;

    @Before("@HomePage")
    public void setUp() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        homePage.openWebsite();
    }

    @And("I accept all cookies")
    public void iAcceptAllCookies() {
        homePage.acceptCookies();
    }

    @When("I check the title of the page")
    public void iCheckTheTitleOfThePage() {
        String expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        String actualTitle = driver.getTitle();
    }

    @Then("I see the Tesco home page")
    public void iSeeTheTescoHomePage() {
        Assertions.assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
    @After("@HomePage")
    public void tearDown() {
        DriverManager.quitDriver();
    }
}