package pages;

import baseitems.BasePage;
import driver.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")
    WebElement cookiesButton;

    @FindBy(xpath = "//*[@id=\"utility-header-login-link\"]/span")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"groceries\"]/div/div/ul/li[2]")
    WebElement fruitAndVegetablesTab;

    @FindBy(xpath = "//*[@id=\"groceries\"]/div/div[2]/ul/li[2]/ul/li[1]")
    WebElement allFruitAndVegetablesTab;

    @FindBy(xpath = "//*[@id=\"tile-2004005406742\"]/div[2]/div[3]/div/div/form/div/div/div[2]/div/div/button")
    WebElement addBananaButton;

    @FindBy(xpath = "//*[@id=\"tile-2004009252888\"]/div[2]/div[3]/div/div/form/div/div/div[2]/div/div/button")
    WebElement addCucumberButton;

    @FindBy(xpath = "//*[@id=\"mini-trolley\"]/div/header/div/div")
    WebElement totalPrice;

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

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void clickOnFruitAndVegetablesTab() {
        wait.until(ExpectedConditions.visibilityOf(fruitAndVegetablesTab));
        fruitAndVegetablesTab.click();
    }

    public void clickOnAllFruitAndVegetablesTab() {
        wait.until(ExpectedConditions.visibilityOf(allFruitAndVegetablesTab));
        allFruitAndVegetablesTab.click();
    }

    public void addBananaToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(addBananaButton));
        addBananaButton.click();
    }

    public void addCucumberToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(addCucumberButton));
        addCucumberButton.click();
    }

    public String getTotalPrice() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(totalPrice));
        return totalPrice.getText().trim();
    }

}
