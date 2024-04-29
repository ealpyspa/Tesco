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
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;

public class HomePageSteps {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    String expectedTitle;
    String actualTitle;

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

    @After
    public void closeDriver() {
        driver.quit();
    }
}