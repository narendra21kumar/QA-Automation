package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM13_VerifyManagerApproveTimesheetForEmployeePage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM13_VerifyManagerApproveTimesheetForEmployeeSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM13_VerifyManagerApproveTimesheetForEmployeePage verifyManagerApproveTimesheetForEmployeePage;

	@Given("Manager login into the timesheet for verifying the approved timesheet for employee")
	public void manager_login_into_the_timesheet_for_verifying_the_approved_timesheet_for_employee() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		verifyManagerApproveTimesheetForEmployeePage = new PM13_VerifyManagerApproveTimesheetForEmployeePage(driver);
		loginPage.doLogIn();
	}

	@When("Click on approved timesheet page icon in manager view")
	public void click_on_approved_timesheet_page_icon_in_manager_view() {
		verifyManagerApproveTimesheetForEmployeePage.approvedPage();
	}

	@And("Select the current week from calendar")
	public void select_the_current_week_from_calendar() throws InterruptedException {
		verifyManagerApproveTimesheetForEmployeePage.selectCurrentWeek();
	}

	@Then("Verify the employee timesheet status {string} , {string}")
	public void verify_the_employee_timesheet_status(String empid, String Approvedtext) throws InterruptedException {
		verifyManagerApproveTimesheetForEmployeePage.validatesStatusText(empid, Approvedtext);
	}

}
