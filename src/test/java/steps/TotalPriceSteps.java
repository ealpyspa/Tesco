package steps;

import driver.Settings;
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
import pages.LoginPage;

import java.time.Duration;

public class TotalPriceSteps {

    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("I am on a Home page")
    public void iAmOnAHomePage() {
        homePage.openWebsite();
    }

    @And("I accept cookies")
    public void iAcceptCookies() {
        homePage.acceptCookies();
    }

    @And("I am logged in")
    public void iAmLoggedIn() {
        homePage.clickOnSignInButton();
        loginPage.isLoaded();
        loginPage.login(Settings.EMAIL, Settings.PASSWORD);

    }

    @And("I select Fruit&Vegetables tab")
    public void iSelectFruitVegetablesTab() {
        homePage.clickOnFruitAndVegetablesTab();
    }

    @And("I select all Fruit&Vegetables tab")
    public void iSelectAllFruitVegetablesTab() {
        homePage.clickOnAllFruitAndVegetablesTab();

    }

    @When("I add the first product to my shopping basket")
    public void iAddTheFirstProductToMyShoppingBasket() {
        homePage.addBananaToBasket();

    }

    @And("I add the second product to my shopping basket")
    public void iAddTheSecondProductToMyShoppingBasket() {
        homePage.addCucumberToBasket();

    }

    @Then("the total price displayed in the basket is {string}")
    public void theTotalPriceDisplayedInTheBasketIs(String expectedTotalPrice) {
        String actualTotalPrice = homePage.getTotalPrice();
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);

    }
    @After
    public void closeDriver() {
        driver.quit();
    }

}
