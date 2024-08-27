package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM21_DeleteTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM21_DeleteTimesheetSteps {

	private WebDriver driver;
	private PM01_LoginPage loginPage;
	PM21_DeleteTimesheetPage deleteTimesheetPage;

	
	@Given("Manager login into the timesheet application")
	public void manager_login_into_the_timesheet_application() {
		Logs.initLogs(TM21_DeleteTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
	    loginPage = new PM01_LoginPage(driver);
	    deleteTimesheetPage=new PM21_DeleteTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on create timesheet page in manager view")
	public void click_on_create_timesheet_page_in_manager_view() throws Exception {
		deleteTimesheetPage.createTimesheetIcon();
	}

	@And("Select the current week from calender in manager view")
	public void select_the_current_week_from_calender_in_manager_view() {
		deleteTimesheetPage.selectCurrentWeek();
	}
	@And("Select the past week from calender in manager view")
	public void select_the_past_week_from_calender_in_manager_view() throws InterruptedException {
		deleteTimesheetPage.selectPastWeekDate();
	}
	@And("Select the future week from calender in manager view")
	public void select_the_future_week_from_calender_in_manager_view() throws InterruptedException {
		deleteTimesheetPage.selectFutureWeekDate();
	}
	@And("Click on edit icon And add row icon in timesheet")
	public void click_on_edit_icon_and_add_row_icon_in_timesheet() throws Exception {
		deleteTimesheetPage.editIcon();
	}

	@And("Click on delete icons for delete the timeSheet")
	public void click_on_delete_icons_for_delete_the_time_sheet() throws Exception {
		deleteTimesheetPage.deleteTimesheet();
	}

	@Then("Validate the deletion of timesheet response as {string}")
	public void validate_the_deletion_of_timesheet_response_as(String draftText) throws Exception {
		deleteTimesheetPage.validateTimesheetResponse(draftText);
	}

	
}
