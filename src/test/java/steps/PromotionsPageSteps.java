package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class PromotionsPageSteps {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
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
        wait.until(ExpectedConditions.urlContains("promotions"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("promotions"));
    }

    @After
    public void closeDriver() {
        driver.quit();
    }


}
