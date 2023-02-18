package pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@type=\"email\"]")
    WebElement userName;
    @FindBy(xpath = "//input[@type=\"password\"]")
    WebElement pas;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement logIn;
    @FindBy(xpath = "//a[@class=\"login__link\"]")
    public WebElement loink;

    @Step("Sent user: {user}, pass: {password}")
    @Description("Confirm form for login user")
    public void comfirm(String user, String password) {
        userName.sendKeys(user);
        pas.sendKeys(password);
        logIn.click();
    }
}
