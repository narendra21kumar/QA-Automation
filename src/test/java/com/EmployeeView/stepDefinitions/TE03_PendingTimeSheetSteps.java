package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE03_PendingTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TE03_PendingTimeSheetSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE03_PendingTimesheetPage pendingTimesheet;

	@When("click on pendingIcon")
	public void click_on_pending_icon() throws InterruptedException {
		pendingTimesheet.pendingApprovalIconClick();

	}

	@Then("Verify the pending Status")
	public void verify_the_pending_status() throws InterruptedException {
		pendingTimesheet.ExpandArrowtoVerify();
	}

	@Given("User login timesheet page with valid credentials")
	public void user_login_timesheet_page_with_valid_credentials() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		pendingTimesheet = new PE03_PendingTimesheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
}
