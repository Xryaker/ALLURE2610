package utils;



import configuretions.BaseClass;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screen extends BaseClass {
    @Step("Make Screenshot")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] takeScreen( String fileName){
        File screenshotfile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotfile,new File("screen/",fileName+".png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment
    @Step("public static String getString(){\\n\" +\n" +
            "            \"        return \\\"Some String from vasiliy\\\";\\n\" +\n" +
            "            \"    }")

    public static String getString(){
        return "Some String from vasiliy";
    }
    @Step("Make Screenshot")
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] onlyScreenForAllure(){
        return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] getElementScreen(WebElement ele) throws IOException {


// Get entire page screenshot
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

// Get the location of element on the page
        Point point = ele.getLocation();

// Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotLocation = new File("GoogleLogo_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotLocation);
// Copy the element screenshot to disk
       return Files.readAllBytes(screenshot.toPath());
    }



}
