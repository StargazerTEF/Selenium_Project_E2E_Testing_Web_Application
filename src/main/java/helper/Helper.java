package helper;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
    public static void takeScreenshot(WebDriver driver, String downloadPath) throws IOException {
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f, new File(downloadPath));
    }

    public static void takeScreenshotWithDateTimeFormat(WebDriver driver, String testName) throws IOException {

        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String strDate = dateFormat.format(date);

        String downloadPath = "screenshots/screenshot-" + testName + " " + strDate + ".jpg";

        Helper.takeScreenshot(driver, downloadPath);
        Files.copy(f, new File(downloadPath));
    }
}

