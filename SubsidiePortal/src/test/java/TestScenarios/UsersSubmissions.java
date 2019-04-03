package TestScenarios;

import PageMethods.HomePageMethods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class UsersSubmissions extends BaseTest {

    @Tag("RunAfterPerformance")
    @ParameterizedTest
    @CsvFileSource(resources = "/usersList.csv", numLinesToSkip = 1)
    public void SubmittedApplicationsPerUser(String username, String email, String firstName, String lastName,int CurrentSubmissionsCount){
        given().user_navigated_to_subsidie_demo_home_page();
        when().user_clicks_on_sign_in_link()
                .and().user1_login_with_Credentials_$_and_$(email,"Test123@")
                .and().GoToMySubmissons();
        then().MySubmissionsAreMoreThan(email,CurrentSubmissionsCount);

    }
    @AfterEach
    public void After()
    {
        System.out.println("***************************************************************After each");
        HomePageMethods.Logout(webDriver);
    }
}
