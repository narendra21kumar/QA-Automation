package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM10_ManagerEditTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM10_ManagerEditTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM10_ManagerEditTimesheetPage managerEditTimesheetPage;

	@Given("User login to the timesheet page for edit timesheet")
	public void user_login_to_the_timesheet_page_for_edit_timesheet() {
		Logs.initLogs(TM10_ManagerEditTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		managerEditTimesheetPage = new PM10_ManagerEditTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on create timeSheet icon")
	public void click_on_create_time_sheet_icon() throws Exception {
		managerEditTimesheetPage.createTimesheetIcon();
	}

	@And("Select the draft timesheet previous date")
	public void select_the_draft_timesheet_previous_date() throws InterruptedException {
		managerEditTimesheetPage.selectPastWeekDate();
	}

	@And("Click on edit icon in manager view")
	public void click_on_edit_icon() {
		managerEditTimesheetPage.editIcon();
	}

	@And("Edit the timesheet details {string}")
	public void edit_the_timesheet_details(String sheetName) throws Exception {
		managerEditTimesheetPage.editTimesheetDetails(sheetName);
	}

	@And("Click on save and submit")
	public void click_on_save_and_submit() {
		managerEditTimesheetPage.saveAndSubmit();
	}

	@And("Click on Confirm")
	public void click_on_confirm() {
		managerEditTimesheetPage.confirmButton();
	}

	@Then("Validate the edit timesheet response as {string}")
	public void validate_the_edit_timesheet_response_as(String string) throws Exception {
		managerEditTimesheetPage.validateTimesheetResponse();
	}

}
