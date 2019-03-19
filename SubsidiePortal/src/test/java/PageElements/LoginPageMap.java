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


}
