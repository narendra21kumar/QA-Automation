package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM03_PendingTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM03_PendingTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM03_PendingTimesheetPage pendingTimesheet;

	@Given("User login into the manager view for verifying the pending timesheet")
	public void user_login_into_the_manager_view_for_verifying_the_pending_timesheet() {
		Logs.initLogs(TM03_PendingTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		loginPage.doLogIn();
		pendingTimesheet = new PM03_PendingTimesheetPage(driver);
	}

	@When("Click on pending approval icon")
	public void click_on_pending_approval_icon() {
		pendingTimesheet.pendingIconClick();
	}

	@Then("Verify the pending timesheet status {string} approvename")
	public void verify_the_pending_timesheet_status_approvename(String status) {
		//pendingTimesheet.validateStatus(status);
	}
	@Then("Verify the manager name {string} and approver name {string} in pending page")
	public void verify_the_manager_name_and_approver_name_in_pending_page(String managername, String approvername) {
		pendingTimesheet.managerName(managername);
		pendingTimesheet.approverName(approvername);
	}
	
	
}