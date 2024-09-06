package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM05_VerifyManagerApprovedTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM05_VerifyManagerApprovedTimesheetSteps {
	WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM05_VerifyManagerApprovedTimesheetPage approvedtimesheet;

	@Given("User login into the manager view for verifying the approved timesheet")
	public void user_login_into_the_manager_view_for_verifying_the_approved_timesheet() {
		Logs.initLogs(TM05_VerifyManagerApprovedTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		approvedtimesheet = new PM05_VerifyManagerApprovedTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on approved icon")
	public void click_on_approved_icon() {
		approvedtimesheet.approvedIcon();
	}

	@And("Click on show self timesheet toggle")
	public void click_on_show_self_timesheet_toggle() {
		approvedtimesheet.showSelfTimesheetToggle();
	}

	@And("Click on arrow for expanding the approved timesheet")
	public void click_on_arrow_for_expanding_the_approved_timesheet() {
		approvedtimesheet.expandApprovedArrow();
	}

	@Then("Verify the approved timesheet record status")
	public void verify_the_approved_timesheet_record_status() {
		approvedtimesheet.verifyStatus();
	}

}