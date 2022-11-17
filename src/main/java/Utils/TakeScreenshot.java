package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {

    public static void takeSnapShot(WebDriver driver,String screenshotName) throws IOException{
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        String homeDir = System.getProperty("user.dir") + "/Screenshots/" +screenshotName + ".png";
        File destination = new File(homeDir);

        try{
            FileUtils.copyFile(src,destination);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
