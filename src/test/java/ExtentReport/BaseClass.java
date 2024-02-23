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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseClass {
    WebDriver driver ;
    ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;


    @BeforeTest
    public void startReport(){
        System.out.println("Before Test **********");
        sparkReporter = ExtentFactory.getInstance();
        //Initialize the Extent Reporter
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @AfterTest
    public void endReport(){
        System.out.println("After Test **********");
        extentReports.flush();
    }



    @BeforeMethod
    void setUp() throws InterruptedException {
        driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @AfterMethod
    void tearDown(ITestResult result){
        Driver.closeDriver();
    }


}
