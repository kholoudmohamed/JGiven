package PageMethods;

import PageElements.LoginPageMap;
import Utilities.Helpers;
import org.openqa.selenium.WebDriver;

public class LoginPageMethods extends BasePageMethods{
    // Methods
    public static void Login(WebDriver webDriver,String username, String password)
    {
        LoginPageMap.Username.sendKeys(username);
        LoginPageMap.Password.sendKeys(password);
        LoginPageMap.LoginBtn.click();

        // This one could be removed from here
        Helpers.WaitTillSubsidieUrlMatch(webDriver,10,"");
    }
}
