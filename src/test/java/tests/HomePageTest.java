package tests;

import driver.Settings;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest {
    WebDriver driver;

    WebDriverWait wait;
    String expectedTitle;
    String actualTitle;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterEach
    public void shutDown() {
        driver.quit();
    }

    @Test
    public void testHomePageLoads() {
        driver.get(Settings.BASE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")));
        String expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        String actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

}
