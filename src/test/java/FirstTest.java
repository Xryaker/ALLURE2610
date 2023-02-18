import configuretions.BaseClass;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utils.Screen;
import watchers.MyWatch;

import java.io.IOException;

@Epic("Allure examples")
@Feature("Junit 4 support")
@DisplayName("Login page Suit")
public class FirstTest extends BaseClass {

    @Rule
    public MyWatch watch=new MyWatch();

    static LoginPage loginPage;
    @BeforeClass
    @Description("Open page and create pageObject")
    public static void b() {
        driver.get("https://lms.ithillel.ua/auth");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    @Story("Some story")
    @Description("This test checked login by no valid users ")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {
        loginPage.comfirm("Vasili@gmail.com", "login");
    }

    @Test
    @Description("Check button name")
    @Severity(SeverityLevel.MINOR)
    public void t() {
        Assert.assertEquals("Забули пароль?", loginPage.loink.getText());
    }

    @Test
    @Description("check forward link")
    @Severity(SeverityLevel.CRITICAL)
    public void t2() throws InterruptedException, IOException {
        loginPage.loink.click();
        Thread.sleep(2000);
        Screen.getElementScreen(loginPage.loink);
        Assert.assertEquals("https://lms.ithillel.ua/auth/restore", driver.getCurrentUrl());

    }

}
