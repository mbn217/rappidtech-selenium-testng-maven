package TestCases;

import Utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_FillForm {
    WebDriver driver;

    /**
     * Fill the form in the website https://testpages.eviltester.com/styled/basic-html-form-test.html
     * For the username , password and comment from the excel sheet using dataprovider
     */
    @DataProvider(name = "form-data-provider")
    public Object[][] fillFormDataSet() {
        return ExcelUtility.getDataSet("./testdata/testpages_data.xlsx", "Sheet1");
    }



    @Test(dataProvider = "form-data-provider")
    void fillForm(String password, String username, String comment) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//textarea[@name='comments']")).sendKeys(comment);
        Thread.sleep(4000);

    }

    @BeforeMethod
    void setUp() throws InterruptedException {
        //Step 1 : Set the driver path
        System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver");
        //Step 2 : Create an instance of ChromeDriver
        driver = new ChromeDriver(); // Upcasting
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

}
