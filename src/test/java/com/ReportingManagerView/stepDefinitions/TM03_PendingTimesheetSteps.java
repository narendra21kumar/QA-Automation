package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM03_PendingTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

public class TM03_PendingTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM03_PendingTimesheetPage pendingTimesheet;

	@Given("User login into the manager view for verifying the pending timesheet")
	public void user_login_into_the_manager_view_for_verifying_the_pending_timesheet() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		loginPage.doLogIn();
		pendingTimesheet = new PM03_PendingTimesheetPage(driver);
	}

	@When("Click on pending approval icon")
	public void click_on_pending_approval_icon() {
		pendingTimesheet.pendingIconClick();
	}

	@Then("Verify the pending timesheet status {string}")
	public void verify_the_pending_timesheet_status(String status) {
		pendingTimesheet.validateStatus(status);
	}

}