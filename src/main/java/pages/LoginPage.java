package pages;

import baseitems.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "signin-button")
    WebElement signInButton;

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

}
