package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM07_VerifyManagerSubmittedTimesheetandRejectinAdminViewPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM07_VerifyManagerSubmittedTimesheetandRejectinAdminView {
	WebDriver driver;
	private PM01_LoginPage loginPage;
public PM07_VerifyManagerSubmittedTimesheetandRejectinAdminViewPage verifyManagerSubmittedTimesheetandRejectinAdminViewPage;
	


	@Given("Click on the submitted timesheet management icon")
	public void click_on_the_submitted_timesheet_management_icon() {
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage.timesheetSubmittedIcon();
	}

	@When("Select previous week date")
	public void select_previous_week_date() throws InterruptedException {
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage.selectPastWeekDate();
	}

	@Then("Validate the submitted timesheet based on emp id {string} and the status {string}")
	public void validate_the_submitted_timesheet_based_on_emp_id_and_the_status(String empid, String status) {
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage.submittedStatus(empid, status);
	}

	@And("Click on the reject timesheet icon based on empid {string} and enter the remarks {string}")
	public void click_on_the_reject_timesheet_icon_based_on_empid_and_enter_the_remarks(String empid, String remarks) {
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage.rejectIcon(empid,remarks);
		}

	@Then("validate the toast message response  as {string}")
	public void validate_the_toast_message_response_as(String toastmessagge) {
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage.validateToastMessage(toastmessagge);
	}
	@Given("verify the manager submitted timesheet and reject from admin view")
	public void verify_the_manager_submitted_timesheet_and_reject_from_admin_view() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		verifyManagerSubmittedTimesheetandRejectinAdminViewPage = new PM07_VerifyManagerSubmittedTimesheetandRejectinAdminViewPage(driver);
		loginPage.doLogInAsAdmin();
	}

}
