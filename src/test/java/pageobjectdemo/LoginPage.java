package pageobjectdemo;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;// = Driver.getDriver("chrome");
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * This binds the FindBy's to their webelements. They dont get found until they are used.
     * This reduces the effort of using a lot of driver.FindBy calls
     * PageFactory.initElements(driver, this);
     */


    //This is the old way of initializing the webelement , its suggested to use @FindBy
    //By userNameElement = By.xpath("//input[@id='usernamexyz']");

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement loginLogo;



    //*********************** Methods/ Functions ***************************//


    public void enterUserName(String username){
        userNameField.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void loginToSauceLabs(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();
    }


    public String getLogoInMainPage(){
        return loginLogo.getText();
    }









}
