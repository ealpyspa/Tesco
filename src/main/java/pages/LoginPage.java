package pages;

import baseitems.BasePage;
import baseitems.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = Locators.EMAIL)
    WebElement email;

    @FindBy(id = Locators.PASSWORD)
    WebElement password;

    @FindBy(id = Locators.LOGIN_BTN)
    WebElement signInButton;
    @FindBy(xpath = Locators.INV_PWD_ERROR1)
    WebElement error1;

    @FindBy(xpath = Locators.INV_PWD_ERROR2)
    WebElement error2;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void isLoaded() {
        wait.until(ExpectedConditions.titleIs("Sign in to your account"));
    }
    public void fillUserNameField(String text) {
        email.clear();
        email.sendKeys(text);
    }

    public void fillPasswordField(String text) {
        password.clear();
        password.sendKeys(text);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void login(String username, String password) {
        fillUserNameField(username);
        fillPasswordField(password);
        clickOnSignInButton();
    }
    public String getErrorText() {
        return error1.getText();
    }
}
