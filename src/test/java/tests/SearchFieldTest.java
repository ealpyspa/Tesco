package tests;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchFieldTest {
    @Test
    public void homePageTest() {
        WebDriver driver = new ChromeDriver();
        driver.get(Settings.BASE_URL);

    }
}
