package ExtentReport;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_VerifyLabel extends BaseClass {




    @Test
    void verifyMainPageLabel() throws InterruptedException {
        test.getTest().setDescription(" Verify main page label ");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //Verify main Label
        WebElement actualLabel = driver.findElement(By.xpath("//div[.='Swag Labs' and @class='app_logo']"));
        Assert.assertEquals(actualLabel.getText() , "Swag Labs");
        test.log(LogStatus.PASS , "Test {verifyMainPageLabel}  PASSED");
        Thread.sleep(1000);


    }

}
