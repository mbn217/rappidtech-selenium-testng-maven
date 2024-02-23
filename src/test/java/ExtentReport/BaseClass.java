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
        Driver.closeDriver();
    }


}
