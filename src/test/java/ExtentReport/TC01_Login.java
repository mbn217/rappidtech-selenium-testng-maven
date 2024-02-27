package ExtentReport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC01_Login  extends BaseClass {


    @Test
    void loginWithValidUserNameAndPassword() throws InterruptedException {
        extentTest = extentReports.createTest(" Login with valid username and password");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(1000);

    }

}
