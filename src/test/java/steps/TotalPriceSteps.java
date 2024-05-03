package steps;

import baseitems.Locators;
import driver.DriverManager;
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

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before("@TotalPrice")
    public void initializeDriver() {
        driver = DriverManager.getDriver();
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
        loginPage.login(Locators.VALID_EMAIL, Locators.VALID_PASSWORD);

    }

    @And("I select Fruit&Vegetables tab")
    public void iSelectFruitVegetablesTab() {
        homePage.clickOnFruitAndVegetablesTab();
    }

    @And("I select all Fruit&Vegetables tab")
    public void iSelectAllFruitVegetablesTab() {
        homePage.clickOnAllFruitAndVegetablesTab();

    }

    @And("I add the first product to my shopping basket")
    public void iAddTheFirstProductToMyShoppingBasket() {
        homePage.addBananaToBasket();

    }

    @And("I add the second product to my shopping basket")
    public void iAddTheSecondProductToMyShoppingBasket() {
        homePage.addCucumberToBasket();

    }

    @When("I check the basket")
    public void iCheckTheBasket() throws InterruptedException {
        homePage.clickOnBasketButton();
        Thread.sleep(999);
    }

    @Then("the total price displayed in the basket is {string}")
    public void theTotalPriceDisplayedInTheBasketIs(String expectedTotalPrice) throws InterruptedException {
        String actualTotalPrice = homePage.getTotalPrice();
        Assertions.assertEquals(expectedTotalPrice, actualTotalPrice);
    }

    @After("@TotalPrice")
    public void tearDown() throws InterruptedException {
        homePage.removeCucumber();
        Thread.sleep(3000);
        homePage.removeBanana();
        Thread.sleep(3000);
        DriverManager.quitDriver();
    }


}
