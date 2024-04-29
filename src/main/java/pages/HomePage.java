package pages;

import baseitems.BasePage;
import driver.Settings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")
    WebElement cookiesButton;

    @FindBy(xpath = "//*[@id=\"groceries\"]/div/div/ul/li[2]")
    WebElement fruitAndVegetablesTab;

    @FindBy(xpath = "//*[@id=\"groceries\"]/div/div[2]/ul/li[2]/ul/li[2]/a")
    WebElement fruitsTab;

    @FindBy(xpath = "//*[@id=\"groceries\"]/div/div[2]/ul/li[2]/ul/li[2]/ul/li[1]/a")
    WebElement allFruitsTab;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openWebsite() {
        driver.get(Settings.BASE_URL);
        wait.until(ExpectedConditions.visibilityOf(cookiesButton));
    }

    public void acceptCookies() {
        cookiesButton.click();
    }


    public void clickOnFruitAndVegetablesTab() {
        wait.until(ExpectedConditions.visibilityOf(fruitAndVegetablesTab));
        fruitAndVegetablesTab.click();
    }

    public void clickOnFruitsTab() {
        fruitsTab.click();
    }

    public void clickOnAllFruitsTab() {
        allFruitsTab.click();
    }

}
