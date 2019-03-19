package PageMethods;

import PageElements.UsersAndOrganizationsPageMap;
import Utilities.Helpers;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

public class UsersAndOrganizationsPageMethods extends BasePageMethods{
    private static PropertyReader data = new PropertyReader();
    //Methods
    public static void Navigate(WebDriver webDriver)
    {
        webDriver.get(data.getSubsidieBaseUrl()+"/group/control_panel/manage?p_p_id=com_liferay_users_admin_web_portlet_UsersAdminPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_toolbarItem=view-all-users&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_usersListView=flat-users&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_status=0&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_emailAddress=&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_firstName=&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_lastName=&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_middleName=&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_organizationId=0&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_roleId=0&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_screenName=&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_userGroupId=0&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_orderByCol=last-name&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_orderByType=asc&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_resetCur=false&_com_liferay_users_admin_web_portlet_UsersAdminPortlet_delta2=20");
    }

    public static void ImpersonateUserWithName(WebDriver webDriver,String UserName) {
        int intendedUserIndex;
        int UsersListSize = UsersAndOrganizationsPageMap.UsersNameList.size();
        String ActualUsername = "";
        for (int i=0;i<UsersListSize ;i++)
        {
            ActualUsername=UsersAndOrganizationsPageMap.UsersNameList.get(i).getText();
            if (ActualUsername.equals(UserName))
            {
                intendedUserIndex=i;
                UsersAndOrganizationsPageMap.UsersDropDownToggleList.get(intendedUserIndex).click();
                break;
            }
        }

        UsersAndOrganizationsPageMap.ImpersonateUserLink.click();
        Helpers.SwitchToLatestTab(webDriver);
        Helpers.WaitTillUrlContain(webDriver,10,"/web/guest?doAsUserId=");
        Helpers.waitForLoad(webDriver);

    }
}
