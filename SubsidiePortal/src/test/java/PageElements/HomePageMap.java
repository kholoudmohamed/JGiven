package PageElements;

import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePageMap extends BasePageMap {
    public HomePageMap(WebDriver webDriver)
    {
        super(webDriver);
    }



    @FindBy(how = How.CSS,using = "ul[role='menubar']>li>a[role='menuitem']")
    public static List<WebElement> MainMenuItems ;

    @FindBy(how = How.CSS,using = "[id*='_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_']>span>a")
    public static WebElement SignInLink ;

    @FindBy(how = How.CSS,using = "span.user-avatar-link>a>span.panel-notifications-count")
    public static WebElement AvatarNotifications ;

    @FindBy(how = How.CSS,using = "a[id*='_ProductNavigationUserPersonalBarPortlet_sidenavUserToggle']")
    public static WebElement LoggedInUserNameLink ;

    @FindBy(how = How.CSS,using = "a[href=\"/c/portal/logout\"]")
    public static WebElement LogOutLink ;


}
