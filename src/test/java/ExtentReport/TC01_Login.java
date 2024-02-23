package ExtentReport;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_Login  extends BaseClass {




    @Test
    void loginWithValidUserNameAndPassword() throws InterruptedException {
        extentTest = extentReports.createTest(" Login with valid username and password");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Assert.assertEquals(true, false);
        Thread.sleep(1000);


    }

}
