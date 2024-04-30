package pages;

import baseitems.BasePage;
import baseitems.Locators;
import driver.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(xpath = Locators.COOKIES_BTN)
    WebElement cookiesButton;

    @FindBy(xpath = Locators.SIGNIN_BTN)
    WebElement signInButton;

    @FindBy(xpath = Locators.FRUIT_AND_VEG_TAB)
    WebElement fruitAndVegetablesTab;

    @FindBy(xpath = Locators.ALL_FRUIT_AND_VEG)
    WebElement allFruitAndVegetablesTab;

    @FindBy(xpath = Locators.ADD_BANANA_BTN)
    WebElement addBananaButton;

    @FindBy(xpath = Locators.ADD_CUCUMBER_BTN)
    WebElement addCucumberButton;

    @FindBy(xpath = Locators.BASKET_BTN)
    WebElement basketButton;

    @FindBy(xpath = Locators.TOTAL_PRICE)
    WebElement totalPrice;
    @FindBy(xpath = Locators.REMOVE_CUCUMBER)
    WebElement removeCucumberBtn;

    @FindBy(xpath = Locators.REMOVE_BANANA)
    WebElement removeBananaBtn;

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

    public void clickOnBasketButton() {
        wait.until(ExpectedConditions.elementToBeClickable(basketButton));
        basketButton.click();
    }

    public String getTotalPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(totalPrice));
        return totalPrice.getText();
    }

    public void removeCucumber() {
        removeCucumberBtn.click();
    }
    public void removeBanana() {
        removeBananaBtn.click();
    }


}
