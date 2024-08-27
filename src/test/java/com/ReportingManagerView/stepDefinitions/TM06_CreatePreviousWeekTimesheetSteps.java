package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM06_CreatePreviousWeekTimesheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM06_CreatePreviousWeekTimesheetSteps {

	WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM06_CreatePreviousWeekTimesheetPage CreatePreviousWeekTimesheetPage;

	@Given("User can able to login into the manager view for previous create timesheet")
	public void user_can_able_to_login_into_the_manager_view_for_previous_create_timesheet() {
		Logs.initLogs(PM06_CreatePreviousWeekTimesheetPage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		CreatePreviousWeekTimesheetPage = new PM06_CreatePreviousWeekTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on create timesheet icon")
	public void click_on_create_timesheet_icon() throws Exception {
		CreatePreviousWeekTimesheetPage.createTimesheetIcon();
	}

	@And("Select the previous week date")
	public void select_the_previous_week_date() throws InterruptedException {
		CreatePreviousWeekTimesheetPage.selectPastWeekDate();
	}

	@And("Enter the task description,select the category,subcategory and entering hours to previous week timesheet {string}")
	public void enter_the_task_description_select_the_category_subcategory_and_entering_hours_to_previous_week_timesheet(
			String SheetName) throws Exception {
		CreatePreviousWeekTimesheetPage.enterTaskDescriptionCategorySubcategory(SheetName);
		CommonUtils.scrollTillTop(driver);
	}

	@And("Click on the save icon")
	public void click_on_the_save_icon() {
		CreatePreviousWeekTimesheetPage.saveIcon();
	}

	@And("Click on the submit button")
	public void click_on_the_submit_button() {
		CreatePreviousWeekTimesheetPage.submitButton();
	}

	@And("Click on the confirm button")
	public void click_on_the_confirm_button() {
		CreatePreviousWeekTimesheetPage.confirmButton();
	}

	@Then("Validate the submitted timesheet response as {string}")
	public void validate_the_submitted_timesheet_response_as(String string) throws Exception {
		CreatePreviousWeekTimesheetPage.validateTimesheetResponse();
	}

}
