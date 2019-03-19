package PageElements;

import Utilities.Helpers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class WorkFlowTasksPageMap extends BasePageMap {
    public WorkFlowTasksPageMap(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(how = How.CSS,using = "a.dropdown-toggle.icon-monospaced>span")
    public static WebElement DropDownToggle ;

    @FindBy(how = How.CSS,using = "ul.dropdown-menu.dropdown-menu-left-side>li>a")
    public static List<WebElement> DropDownToggleItems ;

    @FindBy(how = How.CSS,using = "div.lfr-asset-assigned")
    public static WebElement TaskAssignee ;

    @FindBy(how = How.CSS,using = "div#Content>div.panel-body>div:nth-child(4)>div:nth-child(2)>fieldset>div#Content>div")
    public static WebElement TaskState ;

    @FindBy(how = How.CSS,using = "table[data-searchcontainerid*='_MyWorkflowTaskPortlet_workflowTasks']>tbody>tr>td.asset-title")
    public static List<WebElement> WorkFlowTasksTitleList ;



}
