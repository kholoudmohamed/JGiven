package Actions;

import PageElements.*;
import PageMethods.*;
import TestScenarios.BaseTest;
import Utilities.Helpers;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.BitSet;

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


    //Temp methods
    public WhenSomeAction user1_login_with_Credentials_$_and_$(String username, String password) {
        LoginPageMethods.Login1(webDriver,username,password);

        return self();
    }

    public WhenSomeAction user1_navigates_to_users_and_organizations_page() {
        UsersAndOrganizationsPageMethods.Navigate1(webDriver);
        return self();
    }

    public WhenSomeAction click_on_add_new_button() {
        UsersAndOrganizationsPageMethods.ClickOnAddBtn();
        return self();
    }

    public WhenSomeAction fill_in_new_user_details_and_submit(String username, String email, String firstName, String lastName) {
        UsersAndOrganizationsPageMethods.FillinNewUserInfoAndSubmit(username,email,firstName,lastName);
        return self();
    }

    public WhenSomeAction open_user_with_name(String username) {
        UsersAndOrganizationsPageMethods.OpenUserWithName(webDriver,username);
        return self();
    }

    public WhenSomeAction click_on_password_tab_link() {
        UsersAndOrganizationsPageMethods.ClickOnPasswordTabLink();
        return self();
    }

    public WhenSomeAction fill_in_new_password_and_submit(String password) {
        UsersAndOrganizationsPageMethods.FillInPasswordAndSubmit(webDriver,password);
        return self();
    }

    public WhenSomeAction agree_on_terms_of_use() {
        LoginPageMethods.Agree();
        return self();
    }

    public WhenSomeAction change_password_and_submit(String password) {
        LoginPageMethods.SetNewPasswordAndSubmit(password);
        return self();
    }

    public WhenSomeAction answer_security_question_and_submit(String answer) {
        LoginPageMethods.SetSecurityQuestionAnswrAndSubmit(answer);
        return self();
    }

    public WhenSomeAction log_out() throws InterruptedException {

        Thread.sleep(2000);
        HomePageMethods.Logout(webDriver);
        return self();
    }

    public WhenSomeAction GoToMySubmissons() {
        BasePageMethods.GoToMySubmissions(webDriver);
        return self();
    }

    public WhenSomeAction  printMySubmittionsCount(String email) {
        System.out.println("********************************************* Submissions count for user "+email+" is "+BasePageMethods.GetMySubmissionsCount());
        return self();
    }
    // microsoft login
    public WhenSomeAction  LoginWithMicrosoftAccount() throws InterruptedException {
       LoginPageMethods.Microsoft_login();
        return self();
    }

}
