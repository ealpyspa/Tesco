package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class TotalPriceSteps {
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

    @Given("I am on a Home page")
    public void iAmOnAHomePage() {
        homePage.openWebsite();
    }
    @And("I accept cookies")
    public void iAcceptCookies() {
        homePage.acceptCookies();
    }

    @And("I select {string} tab")
    public void iSelectTab() {
        homePage.clickOnFruitAndVegetablesTab();

    }

    @And("I navigate to the {string} tab")
    public void iNavigateToTheTab() {
        homePage.clickOnFruitsTab();

    }

    @And("I select {string} sub tab")
    public void iSelectSubTab() {
        homePage.clickOnAllFruitsTab();

    }

    @And("I add the following fruits to my shopping basket")
    public void iAddTheFollowingFruitsToMyShoppingBasket(DataTable dataTable) {
        //homePage.clickOnFruitTab();
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String productName = product.get("Product");
            String price = product.get("Price");
            addProductToBasket(productName, price);
        }
    }

    private void addProductToBasket(String productName, String price) {
        WebElement addButton = driver.findElement(By.xpath("//*[@id=\"tile-2004005406742\"]/div[2]/div[3]/div/div/form/div/div/div[2]/div/div/button/span/span"));
        addButton.click();
    }


    @When("I view my shopping basket")
    public void iViewMyShoppingBasket() {

    }

    @Then("the total price displayed in the basket is {string}")
    public void theTotalPriceDisplayedInTheBasketIs(String arg0) {
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

}
