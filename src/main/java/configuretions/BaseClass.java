package configuretions;


import io.qameta.allure.TmsLink;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.junit.BeforeClass;

public class BaseClass {
    public static WebDriver driver;
@BeforeClass
    public static void createDriver() {
        System.out.println("BEFORE BASECLASS");
        driver = DriverConfig.create(BROWSERS.CHROMEINCOGNITO);

    }

    @AfterClass
    public static void after() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("AFTER BASECLASS");
//        System.out.println(driver.getCurrentUrl());
            driver.quit();
    }
}
