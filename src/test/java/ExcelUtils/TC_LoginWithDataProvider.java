package ExcelUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginWithDataProvider {

    WebDriver driver;
    @BeforeMethod
    void setup() throws InterruptedException {
        //Step 1 : Set the driver path
        System.setProperty("webdriver.chrome.driver", "./browserdrivers/chromedriver");
        //Step 2 : Create an instance of ChromeDriver
        driver = new ChromeDriver(); // Upcasting
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }


    @Test(dataProvider = "data-login")
    void verifyMainLabel(String username, String password) throws InterruptedException {
        //System.out.println(username + " | " + password);
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(3000);

    }


    @DataProvider(name = "data-login")
    public Object[][] loginDataSet(){
        return getLoginDataSet();
    }


    /**
     * This methold will read excel sheet data set and return them
     * in the form of two dimensional array
     * @return two dimensional array of the excel dataset
     */
    public Object[][] getDataSet(){
        ExcelUtility.getExcelInstance("./testdata/data.xlsx", "Sheet1");
        int rowCount = ExcelUtility.getRowCount();
        int colCount = ExcelUtility.getColCount();
        Object [][] data  = new Object[rowCount][colCount];

        for(int i = 0 ; i < rowCount ; i++){
            for(int j = 0 ; j < colCount ; j++){
                String cellData = ExcelUtility.getCellDataString(i,j);
                data[i][j] = cellData;
            }
        }
        return data;
    }


}
