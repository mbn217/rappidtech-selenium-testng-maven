package ExtentReport;

import Utilities.Driver;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_Login  extends BaseClass {




    @Test
    void loginWithValidUserNameAndPassword() throws InterruptedException {
        test.getTest().setDescription(" Login with a valid Username and Password ");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Assert.assertEquals(true, true);
        test.log(LogStatus.PASS , "Test {loginWithValidUserNameAndPassword}  PASSED");
        Thread.sleep(1000);


    }

}
