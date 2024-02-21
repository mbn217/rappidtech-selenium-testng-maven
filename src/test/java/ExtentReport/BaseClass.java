package ExtentReport;

import Utilities.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    ExtentReports report;
    ExtentTest test;

    WebDriver driver ;
    @BeforeMethod
    void setUp() throws InterruptedException {
        driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        report = ExtentFactory.getInstance();
        test = report.startTest(getClass().getSimpleName());

    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
        report.endTest(test);
    }
    @AfterSuite
    void cleanUpReport(){
        report.flush();
    }

}
