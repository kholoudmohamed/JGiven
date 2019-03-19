package PageMethods;

import Actions.ThenSomeOutcome;
import PageElements.WorkFlowTasksPageMap;
import Utilities.Helpers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class WorkFlowTasksPageMethods extends BasePageMethods{
    // Methods
    public static void ClickOnToggleMenuAndChooseOption(WebDriver webDriver,String desiredOption)
    {

        ClickOnRightDotsToggle(webDriver);
        try {
            Helpers.WaitTillElementExist(webDriver,5, By.cssSelector("div.overlay-focused"));
        }
        catch (TimeoutException ex)
        {
            System.out.println("WARNING: timeout exception couldn't find element");
            ClickOnRightDotsToggle(webDriver);
        }


        int size= WorkFlowTasksPageMap.DropDownToggleItems.size();
        List<String> dropDownItems = Helpers.GetListOfStringFromListOfElements(WorkFlowTasksPageMap.DropDownToggleItems);

        if (dropDownItems.contains(desiredOption)) {
            int intendedIndex;
            for (int i = 0; i < size; i++) {
                String elementText = WorkFlowTasksPageMap.DropDownToggleItems.get(i).getText();
                if (elementText.equals(desiredOption)) {
                    intendedIndex = i;
                    WorkFlowTasksPageMap.DropDownToggleItems.get(intendedIndex).click();
                    break;
                }
            }
        }
        else {
            System.out.println(dropDownItems);
            Assertions.fail("Desired option "+desiredOption+" is not available in the current list");
        }

    }

    public static void ClickOnRightDotsToggle(WebDriver webDriver)
    {
        Helpers.WaitTillElementExist(webDriver,10,By.cssSelector("a.dropdown-toggle.icon-monospaced>span>svg"));
        try {
            WorkFlowTasksPageMap.DropDownToggle.click();
        }
        catch (ElementNotVisibleException ex)
        {
            WorkFlowTasksPageMap.DropDownToggle.click();
        }

    }

    public static String GetTaskAssignee() {
        return WorkFlowTasksPageMap.TaskAssignee.getText();
    }

    public static String GetTaskState() {
        return WorkFlowTasksPageMap.TaskState.getText();
    }

    public static void ClickOnLastTaskInTheList()
    {
        int listSize = WorkFlowTasksPageMap.WorkFlowTasksTitleList.size();
        WorkFlowTasksPageMap.WorkFlowTasksTitleList.get(listSize-1).click();
    }
}
