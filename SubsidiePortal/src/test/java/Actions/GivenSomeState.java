package Actions;

import PageElements.*;
import PageMethods.HomePageMethods;
import TestScenarios.BaseTest;
import com.tngtech.jgiven.Stage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GivenSomeState extends Stage<GivenSomeState> {
    public WebDriver webDriver;
    public GivenSomeState()
    {
        webDriver= BaseTest.webDriver;
        PageFactory.initElements(webDriver, UsersAndOrganizationsPageMap.class);
        PageFactory.initElements(webDriver, WorkFlowTasksPageMap.class);
        PageFactory.initElements(webDriver, HomePageMap.class);
        PageFactory.initElements(webDriver, LoginPageMap.class);
        PageFactory.initElements(webDriver, ApplicationFormPageMap.class);
    }
    public GivenSomeState user_navigated_to_subsidie_home_page(){
        HomePageMethods.NavigateToSubsidieHome(webDriver);

        return self();
    }

}
