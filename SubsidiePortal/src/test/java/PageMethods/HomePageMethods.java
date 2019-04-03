package PageMethods;

import PageElements.HomePageMap;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

public class HomePageMethods extends BasePageMethods{
    private static PropertyReader data = new PropertyReader();
    //Methods
    public static void NavigateToSubsidieHome(WebDriver webDriver)
    {
        webDriver.get(data.getSubsidieBaseUrl());
    }

    public static void ClickOnSignInLink()
    {
        HomePageMap.SignInLink.click();
    }

    public static void ClickOnApplicationForm()
    {
        int size=HomePageMap.MainMenuItems.size();
        int intendedIndex = 0;
        for(int i=0;i<size;i++)
        {
            String elementText = HomePageMap.MainMenuItems.get(i).getText();
            if (elementText.equals("Application Form"))
            {
                intendedIndex=i;
                break;
            }
        }
        HomePageMap.MainMenuItems.get(intendedIndex).click();
    }
    public static void OpenNotificationsListFromAvatarIcon()
    {
        HomePageMap.AvatarNotifications.click();
    }

    public static void NavigateToSubsidieDemoHome(WebDriver webDriver) {
        webDriver.get("https://subsidie-demo.test.worth.systems");
    }

    public static void ClickOnLoggedInUsernameLink()
    {
        HomePageMap.LoggedInUserNameLink.click();
    }
    public static void Logout(WebDriver webDriver)
    {
        webDriver.get("https://subsidie-demo.test.worth.systems/c/portal/logout");
    }


    public static void NavigateToAtosEnvironmentMainSiteLogin(WebDriver webDriver)
    {
        webDriver.get("https://acc-ls1.mfaservices.nl/c/portal/login");
    }
    public static void NavigateToAtosEnvironmentMainSiteLoginPage(WebDriver webDriver)
    {
        webDriver.get("https://acc-ls1.mfaservices.nl/login");
    }

}
