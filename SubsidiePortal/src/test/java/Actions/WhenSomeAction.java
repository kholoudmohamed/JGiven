package Actions;

import PageElements.*;
import PageMethods.*;
import TestScenarios.BaseTest;
import Utilities.Helpers;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.openqa.selenium.WebDriver;

import static TestScenarios.BaseTest.CloseDriver;

public class WhenSomeAction extends Stage<WhenSomeAction> {
    public WebDriver webDriver;
    public WhenSomeAction()
    {
        webDriver= BaseTest.webDriver;
    }


    @ProvidedScenarioState
    static String loggedInUserName;


    public WhenSomeAction user_clicks_on_sign_in_link() {
        HomePageMethods.ClickOnSignInLink();
        return self();
    }

    public WhenSomeAction user_login_with_Credentials_$_and_$(String username, String password) {
        LoginPageMethods.Login(webDriver,username,password);

        return self();
    }

    public WhenSomeAction user_navigates_to_users_and_organizations_page() {
        UsersAndOrganizationsPageMethods.Navigate(webDriver);
        return self();
    }
    public WhenSomeAction admin_impersonate_user_with_name(String username)  {
        loggedInUserName = username;
        UsersAndOrganizationsPageMethods.ImpersonateUserWithName(webDriver,username);
        Helpers.SwitchToLatestTab(webDriver);
        return self();
    }

    public WhenSomeAction click_on_application_form() {
        HomePageMethods.ClickOnApplicationForm();
        return self();
    }

    public WhenSomeAction fill_in_the_form_and_submit() {
        ApplicationFormPageMethods.FillinTheform();
        ApplicationFormPageMethods.Submit();
        ApplicationFormPageMethods.WaitTillAlertExist(webDriver);
        return self();
    }

    public WhenSomeAction close_current_tab_and_return_to_first_one() {
        CloseDriver();
        Helpers.SwitchToFirstTab(webDriver);
        return self();
    }

    public WhenSomeAction open_recent_notification() {
        HomePageMethods.OpenNotificationsListFromAvatarIcon();
        HomePageMethods.OpenFirstNotificationFromList();
        Helpers.WaitTillUrlContain(webDriver,10,"/group/control_panel/manage?p_p_id=com_liferay_portal_workflow_task_web_portlet_MyWorkflowTaskPortlet");
        Helpers.waitForLoad(webDriver);
        return self();
    }

    public WhenSomeAction open_toggle_and_choose_option(String desiredOption) {
        WorkFlowTasksPageMethods.ClickOnToggleMenuAndChooseOption(webDriver,desiredOption);
        WorkFlowTasksPageMethods.SwitchToPopupAndClickDoneBtn(webDriver);
        WorkFlowTasksPageMethods.WaitTillAlertExist(webDriver);
        Helpers.waitForLoad(webDriver);

        return self();
    }

    public WhenSomeAction user_opens_last_task() {
        WorkFlowTasksPageMethods.ClickOnLastPageLinkFromPagingPanel();
        WorkFlowTasksPageMethods.ClickOnLastTaskInTheList();
        return self();
    }
}
