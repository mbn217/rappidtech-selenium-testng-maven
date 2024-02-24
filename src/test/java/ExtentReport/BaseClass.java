package ExtentReport;

import Utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BaseClass {
    WebDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;


    @BeforeTest
    public void startReport() {
        //Initialize the Extent Reporter
        extentReports = ExtentFactory.getInstance();
    }

    @AfterTest
    public void endReport() {
        extentReports.flush();
    }


    @BeforeMethod
    void setUp() throws InterruptedException {
        extentReports = ExtentFactory.getInstance();
        driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @AfterMethod
    void tearDown(ITestResult result) {
        System.out.println(result.getName()  + "-------> { " + result.getStatus() + "  }  <---------");
            //   1            ==           2
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, "Test Case: " + result.getName() +" Failed\n" + result.getThrowable());
            String screenShotPath = this.getScreenShotPath(driver, result.getName());

            extentTest.addScreenCaptureFromPath(screenShotPath);
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "Test Case: " + result.getName() +" Passed");
        } else{
            extentTest.log(Status.PASS, "Test Case: " + result.getName() +" Passed");
        }


        Driver.closeDriver();
    }

    public static String  getScreenShotPath(WebDriver driver, String screenShotName){
        //give name to screenshot
        //give data and time
        // below code will get the current date in below format and return a string representation and assign it to date variable
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //This below code will take a screen shot with the helo of TakesScreenshot interface
        TakesScreenshot ts = (TakesScreenshot) driver;
        //This below code will output the screenshot as a file type
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        //Specify the path were we want to paste our screen shot
        String path = "./ScreenShots/" + screenShotName + date + ".png";
        //We will get the file from the source and put it into the destination path
        File destination = new File(path);
        try {
            FileHandler.copy(sourceFile , destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }




}
