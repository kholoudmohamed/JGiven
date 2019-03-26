package TestScenarios;

import PageMethods.HomePageMethods;
import com.tngtech.jgiven.annotation.Hidden;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.NoSuchElementException;

public class CreateUsers extends BaseTest {

    @Tag("CreateNewUsers")
    @Test
    public void Login()
    {
        try {
            given().user_navigated_to_subsidie_demo_home_page();
            when().user_clicks_on_sign_in_link()
                    .and().user1_login_with_Credentials_$_and_$("kmohamed@worth.systems","Test123!");
        }
        catch (Exception ex)
        {
            System.out.println("Do Nothing");
        }

    }


    @Tag("CreateNewUsers")
    @ParameterizedTest
    @CsvFileSource(resources = "/usersList.csv", numLinesToSkip = 15)
    public void CreateUsers(String username, String email, String firstName, String lastName){

               when().user1_navigates_to_users_and_organizations_page()
                .and().click_on_add_new_button()
                .and().fill_in_new_user_details_and_submit(username,email,firstName,lastName)
                .and().click_on_password_tab_link()
                .and().fill_in_new_password_and_submit("Test123!");

    }

    @Tag("CreateNewUsers")
    @ParameterizedTest
    @CsvFileSource(resources = "/usersList.csv", numLinesToSkip = 6)
    public void AgreementUsers(String username, String email, String firstName, String lastName){

        given().user_navigated_to_subsidie_demo_home_page();
        when().user_clicks_on_sign_in_link()
                .and().user1_login_with_Credentials_$_and_$(email,"Test123!")
                .and().agree_on_terms_of_use()
                .and().change_password_and_submit("Test123@")
                .and().answer_security_question_and_submit(firstName)
                .and().log_out();

    }



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
        System.out.println("***************************************************************After each");
        HomePageMethods.Logout(webDriver);
    }
}
