package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM09_ManagerDraftTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM09_ManagerDraftTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM09_ManagerDraftTimesheetPage managerDraftTimesheetPage;

	@Given("Manager login into the timesheet for Draft Timesheet")
	public void manager_login_into_the_timesheet_for_draft_timesheet() {
		Logs.initLogs(TM09_ManagerDraftTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		managerDraftTimesheetPage = new PM09_ManagerDraftTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on view Timesheet")
	public void click_on_view_timesheet() throws Exception {
		managerDraftTimesheetPage.createTimesheetIcon();
	}

	@And("Select the past week from calendar icon")
	public void select_the_past_week_from_calendar_icon() throws InterruptedException {
		managerDraftTimesheetPage.selectPastWeekDate();
	}

	@Then("Verify the edit icon draft timesheet and page title as view timesheet {string}")
	public void verify_the_edit_icon_draft_timesheet_and_page_title_as_view_timesheet(String draftText)
			throws Exception {
		managerDraftTimesheetPage.verifyDraftFunctionality(draftText);
	}

}
