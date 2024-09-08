package pages;

import baseitems.BasePage;
import baseitems.Locators;
import driver.Settings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = Locators.COOKIES_BTN)
    WebElement cookiesButton;

    @FindBy(id = Locators.SIGNIN_BTN)
    WebElement signInButton;

    @FindBy(id = Locators.PROMOTIONS)
    WebElement promotionsTab;

    @FindBy(id = Locators.SEARCH_FIELD)
    WebElement searchField;

    @FindBy(xpath = Locators.SEARCH_BTN)
    WebElement searchButton;

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

    public void clickOnPromotionsTab() {
        promotionsTab.click();
    }

    public void fillSearchField(String product){
        searchField.clear();
        searchField.sendKeys(product);
    }
    public void clickOnSearchButton() {
        searchButton.click();
    }

}
