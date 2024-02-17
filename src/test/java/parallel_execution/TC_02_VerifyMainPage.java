package parallel_execution;

import TestCases.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02_VerifyMainPage {
    WebDriver driver;

    @Test
    void verifyMainPageLabel() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);

        //Verify main Label
        WebElement actualLabel = driver.findElement(By.xpath("//div[.='Swag Labs' and @class='app_logo']"));
        Assert.assertEquals(actualLabel.getText() , "Swag Labs");

    }







}
