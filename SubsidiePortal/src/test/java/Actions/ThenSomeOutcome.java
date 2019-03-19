package Actions;

import PageMethods.HomePageMethods;
import PageMethods.WorkFlowTasksPageMethods;
import TestScenarios.BaseTest;
import Utilities.Helpers;
import com.tngtech.jgiven.CurrentStep;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;
import com.tngtech.jgiven.attachment.Attachment;
import com.tngtech.jgiven.attachment.MediaType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    public WebDriver webDriver;
    public ThenSomeOutcome()
    {
        webDriver= BaseTest.webDriver;
    }

    @ExpectedScenarioState(required = true)
    protected CurrentStep currentStep;

    @ExpectedScenarioState
    static String loggedInUserName;

    protected void AttachScreenShotToStage() {
        currentStep.addAttachment(Attachment.fromBase64(Helpers.CaptureScreenShot(webDriver), MediaType.PNG).withTitle("Screenshot"));
    }

    @Hidden
    public ThenSomeOutcome some_outcome() {
        return self();
    }

    public ThenSomeOutcome user_should_have_at_least_one_new_notification() {
        AttachScreenShotToStage();
        Assertions.assertTrue( HomePageMethods.GetUsersNotificationsNo()>0,"User has no notifications currently");
        return self();
    }

    @ExtendedDescription("This should be the current logged in/impersonated as username")
    public ThenSomeOutcome current_task_should_have_a_correct_assigned_to_value() {
        Helpers.WaitTillElementExist(webDriver,10, By.cssSelector("div.card-row>div.card-col-field>div>div>span"));
        AttachScreenShotToStage();
        Assertions.assertEquals(loggedInUserName, WorkFlowTasksPageMethods.GetTaskAssignee(),"Task assignee is not "+loggedInUserName);
        return self();
    }

    public ThenSomeOutcome task_state_should_be(String expectedState)
    {
        AttachScreenShotToStage();
        Assertions.assertEquals(expectedState, WorkFlowTasksPageMethods.GetTaskState(),"Task state is not "+expectedState);
        return self();
    }




}
