package tests;

import basetestitems.BaseTest;
import driver.Settings;
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
import pages.HomePage;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageLoads() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.openWebsite();
            homePage.acceptCookies();
            String expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
            String actualTitle = driver.getTitle();
            Assertions.assertEquals(expectedTitle, actualTitle);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }
}