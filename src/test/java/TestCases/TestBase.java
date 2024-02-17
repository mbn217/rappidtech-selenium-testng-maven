package TestCases;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    public WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        driver = Driver.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
    }



    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }



}
