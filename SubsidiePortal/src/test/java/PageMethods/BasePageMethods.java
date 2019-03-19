package PageMethods;

import PageElements.BasePageMap;
import Utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePageMethods {
    //Methods
    public static void openLiferayMenu(WebDriver webDriver){
        Helpers.waitForLoad(webDriver);
        if (isLiferayMenuOpen(webDriver) == false){
            BasePageMap.liferayMenuButtonWhenClosed.click();
            Helpers.waitForLoad(webDriver);
        }
    }
    public static void openSideBar(WebDriver webDriver){
        Helpers.waitForLoad(webDriver);
        if (isSideBarOpen(webDriver) == false){
            BasePageMap.sideBarButtonWhenClosed.click();
            Helpers.waitForLoad(webDriver);
        }
    }
    private static boolean isLiferayMenuOpen(WebDriver webDriver){
        Helpers.waitForLoad(webDriver);
        try{
            if (BasePageMap.liferayyMenu.isDisplayed()){
                return true;
            }
            else return false;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }
    private static boolean isSideBarOpen(WebDriver webDriver){
        Helpers.waitForLoad(webDriver);
        try{
            if (BasePageMap.sideBar.isDisplayed()){
                return true;
            }
            else return false;
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }

    public static void WaitTillAlertExist(WebDriver webDriver)
    {
        Helpers.WaitTillElementExist(webDriver,10, By.cssSelector("div#alertContainer>div"));
    }

    public static void SwitchToPopupAndClickDoneBtn(WebDriver webDriver)
    {
        try {
            webDriver.switchTo().frame(BasePageMap.WorkFLowDialogPopupFrame);
        }
        catch (NoSuchElementException ex)
        {
            System.out.println("WARNING: No iframe currently exists");
        }

        BasePageMap.WorkFLowDialogPopupDoneBtn.click();
        Helpers.waitForLoad(webDriver);
    }
    public static int GetUsersNotificationsNo() {
        return Integer.parseInt(BasePageMap.UserNotificationNum.getText());
    }
    public static void OpenFirstNotificationFromList()
    {
        BasePageMap.UnreadNotificationLinks.get(0).click();
    }

    public static void ClickOnLastPageLinkFromPagingPanel()
    {
        BasePageMap.PagesLinks.get(BasePageMap.PagesLinks.size()-1).click();
    }
}
