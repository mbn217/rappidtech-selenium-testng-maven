package TestCases;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebDriverManagerDemoFireFox {
        WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    void setUp(@Optional("chrome") String browser) throws InterruptedException {
        driver = Driver.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
    }

    @Test
    void demo() throws InterruptedException {
        Assert.assertEquals(true,false);
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }


}
