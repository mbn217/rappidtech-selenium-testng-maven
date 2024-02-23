package pageobjectdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsMainPage {
    WebDriver driver;// = Driver.getDriver("chrome");
    public SauceLabsMainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This binds the FindBy's to their webelements. They dont get found until they are used.
     * This reduces the effort of using a lot of driver.FindBy calls
     * PageFactory.initElements(driver, this);
     */


    @FindBy(xpath = "//span[.='Products']")
    WebElement productLabel;



    //*********************** Methods/ Functions ***************************//


    public String getProductLabelFromMainPage(){
        if(productLabel.isDisplayed()){
            return productLabel.getText();
        }
        return null;
    }









}
