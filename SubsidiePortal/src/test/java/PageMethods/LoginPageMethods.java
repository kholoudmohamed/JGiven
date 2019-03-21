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


    public static void Login1(WebDriver webDriver,String username, String password)
    {
        LoginPageMap.Username1.clear();
        LoginPageMap.Username1.sendKeys(username);
        LoginPageMap.Password1.sendKeys(password);
        LoginPageMap.LoginBtn1.click();


        // This one could be removed from here
        Helpers.WaitTillUrlMatch(webDriver,10,"https://subsidie-demo.test.worth.systems");
    }

    public static void Agree()
    {
        LoginPageMap.AgreeBtn.click();
    }

    public static void SetNewPasswordAndSubmit(String password)
    {
        LoginPageMap.ChangePassword_Password.sendKeys(password);
        LoginPageMap.ChangePassword_ConfirmPassword.sendKeys(password);
        LoginPageMap.ChangePassword_SubmitBtn.click();
    }
    public static void SetSecurityQuestionAnswrAndSubmit(String answer)
    {
        LoginPageMap.ChangePassword_SecurityAnswer.sendKeys(answer);
        LoginPageMap.ChangePassword_SubmitBtn.click();
    }
}
