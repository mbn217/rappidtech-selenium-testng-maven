package SoftAssertHardAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallenegSoftAssert {

    /**
     * Go to sauce Labs
     * Login
     * Verify that {Sauce Labs Backpack}  equal to {Sauce Labs}    --> Should fail
     * Verify that {Sauce Labs Bike Light}  equal {Sauce Labs Bike Light}  --> Should pass
     *
     * -- Use Soft Assert
     */


    @Test
    void verifyLabelsInMainPage() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        Thread.sleep(5000);
        SoftAssert softAssert = new SoftAssert();

        String expectedBackpackLabel = "Sauce Labs";
        String actualBackpackLabel = driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
        softAssert.assertEquals(actualBackpackLabel , expectedBackpackLabel);


        //===========================
        System.out.println("This will not print if its hard assert");
        String expectedBikeLightLabel = "Sauce Labs Bike Light";
        String actualBikeLightLabel = driver.findElement(By.xpath("//div[.='Sauce Labs Bike Light']")).getText();
        softAssert.assertEquals(actualBikeLightLabel , expectedBikeLightLabel);

        softAssert.assertAll();
    }







}
