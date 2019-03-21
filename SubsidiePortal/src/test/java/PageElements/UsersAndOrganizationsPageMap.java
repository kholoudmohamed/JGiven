package PageElements;

import Utilities.Helpers;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

public class UsersAndOrganizationsPageMap extends BasePageMap {

    public UsersAndOrganizationsPageMap(WebDriver webDriver)
    {
        super(webDriver);
    }
    private static PropertyReader data = new PropertyReader();

    // Selectors
    @FindBy(how = How.CSS,using = "td[class*='lfr-name-column']>a")
    public static List<WebElement> UsersNameList ;

    @FindBy(how = How.CSS,using = "a.direction-left-side.dropdown-toggle.icon-monospaced")
    public static List<WebElement> UsersDropDownToggleList ;

    @FindBy(how = How.CSS,using = "ul.dropdown-menu.dropdown-menu-left-side[role=\"menu\"]>li>a[id*='__menu__impersonate_2d_user']")
    public static WebElement ImpersonateUserLink ;



    @FindBy(how = How.CSS,using = "a.btn.btn-primary.nav-btn.nav-btn-monospaced")
    public static WebElement AddBtn ;


    //Create new user parameters
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_screenName']")
    public static WebElement NewUser_Username ;
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_emailAddress']")
    public static WebElement NewUser_Email ;
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_firstName']")
    public static WebElement NewUser_Firstname ;
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_lastName']")
    public static WebElement NewUser_Lastname ;
    @FindBy(how = How.CSS,using = "button[id*='_web_portlet_UsersAdminPortlet_']")
    public static WebElement NewUser_SubmitBtn ;


    @FindBy(how = How.CSS,using = "a[href*='_screenNavigationEntryKey=password']")
    public static WebElement UserDetails_PasswordTabLink ;
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_password1']")
    public static WebElement UserDetails_Passwordfield ;
    @FindBy(how = How.CSS,using = "input[id*='_UsersAdminPortlet_password2']")
    public static WebElement UserDetails_ConfirmPasswordfield ;
    @FindBy(how = How.CSS,using = "button[id*='_admin_web_portlet_UsersAdminPortlet_']")
    public static WebElement UserDetails_SubmitPasswordBtn ;



}
