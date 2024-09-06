package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM11_BulkApprovedTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM11_BulkApprovedTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM11_BulkApprovedTimesheetPage bulkapprovepage;
	
	@Given("User login into the manager view for bulkapproved timesheets in timesheet management page")
	public void user_login_into_the_manager_view_for_bulkapproved_timesheets_in_timesheet_management_page() {
		Logs.initLogs(TM11_BulkApprovedTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		bulkapprovepage = new PM11_BulkApprovedTimesheetPage(driver);
		loginPage.doLogIn();
	}
	
	@When("Click on timeSheet management page")
	public void click_on_time_sheet_management_page() {
		bulkapprovepage.timesheetSubmittedIcon();
	}
	@And("Select the previous date in timesheet management page from calender icon")
	public void select_the_previous_date_in_timesheet_management_page_from_calender_icon() throws InterruptedException {
		bulkapprovepage.selectPastWeekDate();
	}
	@And("Check the header part checkbox")
	public void check_the_header_part_checkbox() {
		bulkapprovepage.checkBox();
	}
	@And("Click on approve button")
	public void click_on_approve_button() {
		bulkapprovepage.bulkApproveButton();
	}
	@Then("Validate the bulk approved timesheet response as {string} and {string}")
	public void validate_the_bulk_approved_timesheet_response_as_and(String recordtext, String norecordmessage) {
		bulkapprovepage.validateToastmessage(recordtext, norecordmessage);
	}	
	
}
