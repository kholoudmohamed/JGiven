package PageElements;

import Utilities.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageMap extends  BasePageMap{
    public LoginPageMap(WebDriver webDriver)
    {
        super(webDriver);
    }
    // selectors
    @FindBy(how = How.ID,using = "username")
    public static WebElement Username ;

    @FindBy(how = How.ID,using = "password")
    public static WebElement Password ;

    @FindBy(how = How.CSS,using = "#submit>td>button")
    public static WebElement LoginBtn ;


    //Temp selectors
    @FindBy(how = How.ID,using = "_com_liferay_login_web_portlet_LoginPortlet_login")
    public static WebElement Username1 ;

    @FindBy(how = How.ID,using = "_com_liferay_login_web_portlet_LoginPortlet_password")
    public static WebElement Password1 ;

    @FindBy(how = How.CSS,using = "button[id*='_login_web_portlet_LoginPortlet_']")
    public static WebElement LoginBtn1;

    @FindBy(how = How.CSS,using = "button.btn.btn-primary.btn-default")
    public static WebElement AgreeBtn;

    // Change password page fields
    @FindBy(how = How.ID,using = "password1")
    public static WebElement ChangePassword_Password ;

    @FindBy(how = How.ID,using = "password2")
    public static WebElement ChangePassword_ConfirmPassword ;

    @FindBy(how = How.CSS,using = "button.btn.btn-primary.btn-default")
    public static WebElement ChangePassword_SubmitBtn;

    @FindBy(how = How.ID,using = "reminderQueryAnswer")
    public static WebElement ChangePassword_SecurityAnswer;

    // Microsoft login
    @FindBy(how = How.CSS,using = "input[type='email']")
    public static WebElement Microsoft_email;

    @FindBy(how = How.CSS,using = "input[type='password']")
    public static WebElement Microsoft_password;
    @FindBy(how = How.CSS,using = "input[type='submit']")
    public static WebElement Microsoft_submitBtn;


}
