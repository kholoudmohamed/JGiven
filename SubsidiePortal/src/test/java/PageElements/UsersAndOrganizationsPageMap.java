package PageElements;

import Utilities.Helpers;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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


}
