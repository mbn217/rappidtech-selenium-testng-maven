package pageobjectdemo;

import TestCases.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 extends TestBase {



    @Test
    public void login() throws InterruptedException {
        String loginLabel = loginPage.getLogoInMainPage();
        Assert.assertEquals(loginLabel , "Swag Labs");
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

//        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
//        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.xpath("//input[@id='login-button']")).click();


        Thread.sleep(1000);
    }
}
