package Listeners;

import Utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyTestsListener  implements ITestListener{
    WebDriver driver = Driver.getDriver("chrome");

    public void onTestStart(ITestResult result){
        System.out.println("On Test Start " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test success " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("On Test failure " + result.getName());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        //date and time
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        try{
            FileUtils.copyFile(srcFile , new File("./ScreenShots/"+ result.getName()+"-"+formattedDate+ ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void onStart(ITestContext context) {
        System.out.println("On Start " + context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("On Finish " + context.getName());
    }


}
