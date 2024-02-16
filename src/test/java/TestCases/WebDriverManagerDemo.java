package TestCases;

import Utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class WebDriverManagerDemo {
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
