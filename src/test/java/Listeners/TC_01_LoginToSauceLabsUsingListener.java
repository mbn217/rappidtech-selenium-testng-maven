package Listeners;

import Utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(MyTestsListener.class)
public class TC_01_LoginToSauceLabsUsingListener {

    WebDriver driver;


    @Test
    void loginToSauceLabs() throws InterruptedException {
        driver = Driver.getDriver("chrome");
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
        //Verify main Label
        WebElement actualLabel = driver.findElement(By.xpath("//div[.='Swag Labs' and @class='app_logo']"));
        Assert.assertEquals(actualLabel.getText() , "Swag");

    }


}
