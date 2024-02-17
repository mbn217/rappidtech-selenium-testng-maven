package CrossBrowserTesting;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class CrossBrowserTestingDemo {
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
        Thread.sleep(5000);
    }

    @AfterMethod
    void tearDown(){
        Driver.closeDriver();
    }


}
