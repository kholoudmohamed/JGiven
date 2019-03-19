package TestScenarios;


import org.junit.jupiter.api.Test;

public class ApplicationApprovedScenarios extends BaseTest{

    @Test
    public void EndToEndScenarioTillApproval() {
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
                .and().admin_impersonate_user_with_name("Jorik Tuinman");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("ID toewijzen FSO");
        when().open_toggle_and_choose_option("NAAR VT")
                .and().close_current_tab_and_return_to_first_one()

        // VT makes an advice and forward to coordinator
                .and().admin_impersonate_user_with_name("Rigoberto Castellan");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("VT toets");
        when().open_toggle_and_choose_option("Advies op VT")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews VT and approve
                .and().admin_impersonate_user_with_name("Annemiek Bonnie");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Review VT");
        when().open_toggle_and_choose_option("Goedkeuren VT")
                .and().close_current_tab_and_return_to_first_one()

        // MRF and CU created for DT and forward application to coordinator
                .and().admin_impersonate_user_with_name("Rigoberto Castellan");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork DT");
        when().open_toggle_and_choose_option("Advies op DT vanuit MRF")
                .and().close_current_tab_and_return_to_first_one()
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork DT");
        when().open_toggle_and_choose_option("Advies op DT vanuit CU")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews DT and approve
                .and().admin_impersonate_user_with_name("Annemiek Bonnie");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Review DT");
        when().open_toggle_and_choose_option("Goedkeuren DT")
                .and().close_current_tab_and_return_to_first_one()

        // CU and BMW created for IT and forward application to consistency check
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork IT");
        when().open_toggle_and_choose_option("Advies op IT vanuit CU")
                .and().close_current_tab_and_return_to_first_one()
                .and().admin_impersonate_user_with_name("Yolanda Reis Carrer");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork IT");
        when().open_toggle_and_choose_option("Advies op IT vanuit BMW")
                .and().close_current_tab_and_return_to_first_one()

        // Consistency check do their job and forward application to coordinator
                .and().admin_impersonate_user_with_name("Dave Cunningham");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Consistentie check");
        when().open_toggle_and_choose_option("Goedkeuren consistentie check")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews IT and forward application to ORIA
                .and().admin_impersonate_user_with_name("Annemiek Bonnie");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("IT review CO");
        when().open_toggle_and_choose_option("Goedkeuren naar ORIA")
                .and().close_current_tab_and_return_to_first_one()

        // CU and BMW created for ORIA and forward application to coordinator
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork ORIA");
        when().open_toggle_and_choose_option("Advies op ORIA vanuit CU")
                .and().close_current_tab_and_return_to_first_one()
                .and().admin_impersonate_user_with_name("Yolanda Reis Carrer");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Fork ORIA");
        when().open_toggle_and_choose_option("Advies op ORIA vanuit BMW")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews application and forward to Intern
                .and().admin_impersonate_user_with_name("Annemiek Bonnie");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Eindoordeel CO");
        when().open_toggle_and_choose_option("Goedkeuren aanvraag naar UITMO")
                .and().close_current_tab_and_return_to_first_one()

        // Intern creates BEMO and forward to BEMO BMW
                .and().admin_impersonate_user_with_name("Jorik Tuinman");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("BEMO stagiairs");
        when().open_toggle_and_choose_option("Doorzetten UITMO BMW")
                .and().close_current_tab_and_return_to_first_one()

        // BMW created for BEMO and forward application to CU
                .and().admin_impersonate_user_with_name("Yolanda Reis Carrer");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("BEMO BMW");
        when().open_toggle_and_choose_option("Doorzetten UITMO CU")
                .and().close_current_tab_and_return_to_first_one()

        // CU created for BEMO and forward application to Intern
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("BEMO CU");
        when().open_toggle_and_choose_option("UITMO is opgesteld, door naar beschikking")
                .and().close_current_tab_and_return_to_first_one()

        // Intern forward application to beschikking
                .and().admin_impersonate_user_with_name("Jorik Tuinman");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Besch. stagiairs");
        when().open_toggle_and_choose_option("Doorzetten beschikking BMW")
                .and().close_current_tab_and_return_to_first_one()

        // BMW created for beschikking and forward application to CU
                .and().admin_impersonate_user_with_name("Yolanda Reis Carrer");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Besch. BMW");
        when().open_toggle_and_choose_option("Doorzetten beschikking CU")
                .and().close_current_tab_and_return_to_first_one()

        // CU created for beschikking and forward application to to coordinator (regular concept)
                .and().admin_impersonate_user_with_name("Cesar Hernandez");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Besch. CU");
        when().open_toggle_and_choose_option("Normaal concept naar CO")
                .and().close_current_tab_and_return_to_first_one()

        // Coordinator reviews application and approve it finally
                .and().admin_impersonate_user_with_name("Annemiek Bonnie");
        then().user_should_have_at_least_one_new_notification();
        when().open_recent_notification()
                .and().open_toggle_and_choose_option("Assign to Me");
        then().current_task_should_have_a_correct_assigned_to_value()
                .and().task_state_should_be("Check Besch. CO");
        when().open_toggle_and_choose_option("Goedgekeurd")
                .and().close_current_tab_and_return_to_first_one();

    }


}
