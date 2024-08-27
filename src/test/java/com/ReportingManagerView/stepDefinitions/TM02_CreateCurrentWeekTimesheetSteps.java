package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM02_CreateCurrentWeekTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM02_CreateCurrentWeekTimesheetSteps {

	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM02_CreateCurrentWeekTimeSheetPage createTimesheet;

	@Given("User can able to login into the manager view for create timesheet")
	public void user_can_able_to_login_into_the_manager_view_for_create_timesheet() {
		Logs.initLogs(TM02_CreateCurrentWeekTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		loginPage.doLogIn();
		createTimesheet = new PM02_CreateCurrentWeekTimeSheetPage(driver);
	}
	@When("Click on create timesheet icon in manager view")
	public void click_on_create_timesheet_icon_in_manager_view() throws Exception {
		createTimesheet.createTimesheetIcon();
	}
	@And("Select the current week from calendar icon")
	public void select_the_current_week_from_calendar_icon() {
		createTimesheet.selectCurrentWeek();
	}
	@Then("Verify the manager name {string} and approver name {string} in create timesheet page")
	public void verify_the_manager_name_and_approver_name_in_create_timesheet_page(String managername, String approvername) {
		createTimesheet.managerName(managername);
		//createTimesheet.approverName(approvername);
	}
	@And("Enter the task description,select the category,subcategory and entering hours to current week timesheet {string}")
	public void enter_the_task_description_select_the_category_subcategory_and_entering_hours_to_current_week_timesheet(
			String SheetName) throws Exception {
		createTimesheet.enterTaskDescriptionCategorySubcategory(SheetName);
		CommonUtils.scrollTillTop(driver);
	}
	@And("Click on save icon")
	public void click_on_save_icon() {
		createTimesheet.saveIcon();
	}
	@And("Click on submit button")
	public void click_on_submit_button() {
		createTimesheet.submitButton();
	}
	@And("Click on confirm button")
	public void click_on_confirm_button() {
		createTimesheet.confirmButton();
	}
	@Then("Validate the timesheet response as {string}")
	public void validate_the_time_sheet_response_as(String string) throws Exception {
		createTimesheet.validateTimesheetResponse();
	}
}