package pageobjectdemo;

import TestCases.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends TestBase {



    @Test
    public void login() throws InterruptedException {

        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        String actualProductLabel = sauceLabsMainPage.getProductLabelFromMainPage();
        Assert.assertEquals(actualProductLabel , "Products");

        Thread.sleep(1000);
    }
}
