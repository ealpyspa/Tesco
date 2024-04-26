/*

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFieldSteps {

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

    @And("I enter {string} into a search field")
    public void iEnterIntoASearchField(String arg0) {
        driver.findElement(By.id("search-input")).sendKeys("dog");
    }

    @When("I click on a search button")
    public void iClickOnASearchButton() {
        driver.findElement(By.xpath("//*[@id=\"search-form\"]/button")).click();
    }

    @Then("I see result for dog")
    public void iSeeResultForDog() {
        WebElement productList = driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[2]/div[4]/div/div/div[2]/div/ul/li"));
        int productCount = productList.findElements(By.tagName("li")).size();
        Assertions.assertEquals(24, productCount);
    }
}

*/
