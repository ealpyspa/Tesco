package steps;

import baseitems.Locators;
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
import pages.LoginPage;

public class InvalidLoginSteps {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    @Before("@InvalidPassword")
    public void setUp() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }
    @Given("I am on the main Tesco page")
    public void iAmOnTheMainTescoPage() {
        homePage.openWebsite();
    }

    @And("I push the cookies button")
    public void iPushTheCookiesButton() {
        homePage.acceptCookies();
    }

    @And("I click on the sign in button")
    public void iClickOnTheSigInButton() {
        homePage.clickOnSignInButton();
    }

    @When("I enter a valid email and invalid password")
    public void iEnterAValidEmailAndInvalidPassword() throws InterruptedException {
        loginPage.fillUserNameField(Locators.VALID_EMAIL);
        loginPage.fillPasswordField(Locators.INVALID_PWD);
        loginPage.clickOnSignInButton();
    }

    @Then("I see the error message")
    public void iSeeTheErrorMessage() {
        String expectedError1 = "Unfortunately we do not recognise those details.";
        Assertions.assertEquals(expectedError1, loginPage.getErrorText());
    }
    @After("@InvalidPassword")
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
