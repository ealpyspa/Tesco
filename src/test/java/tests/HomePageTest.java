package tests;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
    String expectedTitle;
    String actualTitle;
    @Test
    public void homePageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(Settings.BASE_URL);
        expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
        actualTitle = driver.getTitle();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }
}
