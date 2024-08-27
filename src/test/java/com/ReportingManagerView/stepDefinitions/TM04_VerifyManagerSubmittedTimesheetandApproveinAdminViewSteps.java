package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewPage managersubmittedtimesheet;

	@Given("verify the manager submitted timesheet and approve from admin view")
	public void verify_the_manager_submitted_timesheet_and_approve_from_admin_view() {
		Logs.initLogs(TM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		managersubmittedtimesheet = new PM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewPage(driver);
		loginPage.doLogInAsAdmin();
	}

	@When("Click on submitted timesheet management icon")
	public void click_on_submitted_timesheet_management_icon() {
		managersubmittedtimesheet.timesheetSubmittedIcon();
	}

	@And("Select current week date")
	public void select_current_week_date() throws InterruptedException {
		managersubmittedtimesheet.selectCurrentWeek();
	}

	@Then("Validate the status {string} of the submitted timesheet based on emp id {string}")
	public void validate_the_status_of_the_submitted_timesheet_based_on_emp_id(String status, String empid) {
		managersubmittedtimesheet.submittedStatus(status, empid);
	}

	@And("Click on approve timesheet icon based on empid {string}")
	public void click_on_approve_timesheet_icon_based_on_empid(String empid) {
		managersubmittedtimesheet.approveIcon(empid);
	}

	@Then("validate the toast message as {string}")
	public void validate_the_toast_message_as(String toastmessagge) {
		managersubmittedtimesheet.validateToastMessage(toastmessagge);
	}

}



