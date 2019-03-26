package PageElements;

import Utilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public abstract class BasePageMap {
    public static WebDriver webDriver;
    public BasePageMap(WebDriver webDriver)
    {
        BasePageMap.webDriver=webDriver;
    }

    // Main Menu Selectors
    @FindBy(how = How.ID,using = "_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_Accordion")
    public static WebElement liferayyMenu ;

    @FindBy(how = How.ID,using = "_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_Accordion")
    public static WebElement sideBar ;

    @FindBy(how = How.ID,using = "_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_sidenavToggleId")
    public static WebElement liferayMenuButtonWhenClosed ;

    @FindBy(how = How.ID,using = "_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addToggleId")
    public static WebElement sideBarButtonWhenClosed ;

    // Notification List selectors
    @FindBy(how = How.CSS,using = "li.list-group-item-flex.list-group-item-primary>div:nth-child(3)>*>a")
    public static List<WebElement> UnreadNotificationLinks ;

    @FindBy(how = How.CSS,using = "a[href*=\"group\"]>span.panel-notifications-count")
    public static WebElement UserNotificationNum;

    //Popup Iframe
    @FindBy(how = How.CSS,using = "iframe.dialog-iframe-node")
    public static WebElement WorkFLowDialogPopupFrame ;

    @FindBy(how = How.CSS,using = "button[type=\"button\"].btn.btn-primary.btn-default:not([class*='disabled'])")
    public static WebElement WorkFLowDialogPopupDoneBtn ;

    //Paging panel
    @FindBy(how = How.CSS,using = "ul.pagination>li>a")
    public static List<WebElement> PagesLinks ;


    // My submissions page
    @FindBy(how = How.CSS,using = "table[data-searchcontainerid*='_UserWorkflowPortlet_workflowInstances']>tbody>tr>td:nth-child(1)>a")
    public static List<WebElement> MySubmissionsList ;

}
