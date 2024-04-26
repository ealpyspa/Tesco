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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePageSteps {

    WebDriver driver;
    WebDriverWait wait;
    String expectedTitle;
    String actualTitle;

    @Before
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")));
    }

    @And("I accept all cookies")
    public void iAcceptAllCookies() {
        driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")).click();
    }

    @When("I check the title of the page")
    public void iCheckTheTitleOfThePage() {
        expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        actualTitle = driver.getTitle();
    }

    @Then("I see the Tesco home page")
    public void iSeeTheTescoHomePage() {
        Assertions.assertEquals(expectedTitle, actualTitle);
        driver.quit();
    }
}
