package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM14_VerifyManagerRejectedTimesheetForEmployeePage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM14_VerifyManagerRejectedTimesheetForEmployeeSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM14_VerifyManagerRejectedTimesheetForEmployeePage verifyManagerRejectedTimesheetForEmployeePage;

	@Given("Manager login into the timesheet for verifying the rejected timesheet for employee")
	public void manager_login_into_the_timesheet_for_verifying_the_rejected_timesheet_for_employee() {
		Logs.initLogs(TM14_VerifyManagerRejectedTimesheetForEmployeeSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		verifyManagerRejectedTimesheetForEmployeePage = new PM14_VerifyManagerRejectedTimesheetForEmployeePage(driver);
		loginPage.doLogIn();
	}

	@When("Click on rejected timesheet page icon in manager view")
	public void click_on_rejected_timesheet_page_icon_in_manager_view() {
		verifyManagerRejectedTimesheetForEmployeePage.rejectedIcon();
	}

	@And("Select the previous week from calendar")
	public void select_the_previous_week_from_calendar() throws InterruptedException {
		verifyManagerRejectedTimesheetForEmployeePage.selectPastWeekDate();
	}

	@Then("Verify the employee rejected timesheet status {string} , {string}")
	public void verify_the_employee_rejected_timesheet_status(String empid, String RejectedText)
			throws InterruptedException {
		verifyManagerRejectedTimesheetForEmployeePage.validateStatusText(empid, RejectedText);
	}

}
