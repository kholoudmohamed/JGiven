package TestScenarios;


import org.junit.jupiter.api.Test;

public class ApplicationRejectedScenarios extends BaseTest {

    @Test
    public void ApplicationRejectedAtVTCoordinatorReview()
    {
        given().user_navigated_to_subsidie_home_page();
        when().user_clicks_on_sign_in_link()
                .and().user_login_with_Credentials_$_and_$("admin2","admin2")
                .and().user_navigates_to_users_and_organizations_page()

        // Applicant submit new application
                .and().admin_impersonate_user_with_name("Kholoud Applicant")
                .and().click_on_application_form()
                .and().fill_in_the_form_and_submit()
                .and().close_current_tab_and_return_to_first_one()

        //  Intern forward application to VT
                .and().admin_impersonate_user_with_name("Jorik Tuinman")
                .and().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me")
                .and().open_toggle_and_choose_option("NAAR VT")
                .and().close_current_tab_and_return_to_first_one()

        // VT makes an advice and forward to coordinator
                .and().admin_impersonate_user_with_name("Rigoberto Castellan")
                .and().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me")
                .and().open_toggle_and_choose_option("Advies op VT")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews VT and reject application
                .and().admin_impersonate_user_with_name("Annemiek Bonnie")
                .and().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me")
                .and().open_toggle_and_choose_option("Afwijzen op VT")
                .and().close_current_tab_and_return_to_first_one()

        // Intern creates a rejection draft and forward application to rejection review team
                .and().admin_impersonate_user_with_name("Jorik Tuinman");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Opstellen concept AB");
        when().open_toggle_and_choose_option("Check AB")
                .and().close_current_tab_and_return_to_first_one()

        // Rejection review team reviews draft and rejects application
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Review AB");
        when().open_toggle_and_choose_option("Afwijzen definitief")
                .and().user_opens_last_task();
        then().task_state_should_be("Afgewezen");
    }
}
