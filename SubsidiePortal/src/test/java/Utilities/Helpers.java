package Utilities;

import com.tngtech.jgiven.CurrentStep;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.attachment.Attachment;
import com.tngtech.jgiven.attachment.MediaType;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Helpers {
    private static PropertyReader data = new PropertyReader();

    //private static WebDriver webDriver = DriverFactory.getDriver();

    public static void WaitTillUrlMatch(WebDriver webDriver,int timeInSec, String expectedRelativeUrl)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSec);
        wait.until(ExpectedConditions.urlMatches(data.getSubsidieBaseUrl()+expectedRelativeUrl));
    }
    public static void WaitTillSubsidieUrlMatch(WebDriver webDriver,int timeInSec,String expectedRelativeUrl)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSec);
        wait.until(ExpectedConditions.urlMatches(data.getSubsidieBaseUrl()+expectedRelativeUrl));
    }
    public static void WaitTillUrlContain(WebDriver webDriver,int timeInSec,String expectedRelativeUrl)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSec);
        wait.until(ExpectedConditions.urlContains(data.getSubsidieBaseUrl()+expectedRelativeUrl));
    }

    public static void waitForLoad(WebDriver webDriver) {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(pageLoadCondition);
    }
    public static void SwitchToLatestTab(WebDriver webDriver) {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        int tabsSize=tabs.size();
        if (tabsSize>0)
            webDriver.switchTo().window(tabs.get(tabsSize-1));
    }
    public static void SwitchToFirstTab(WebDriver webDriver) {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(0));
    }

    public static void WaitTillAlertPresent(WebDriver webDriver,int timeInSec)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSec);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public static void WaitTillElementExist(WebDriver webDriver,int timeInSec, By locator)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSec);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static String CaptureScreenShot(WebDriver webDriver) {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
    }

    public static List<String> GetListOfStringFromListOfElements(List<WebElement> elements)
    {
        List<String> stringsList = new ArrayList<>(elements.size());
        for (WebElement element : elements) {
            stringsList.add(element.getText());
        }
        return stringsList;
    }



}
