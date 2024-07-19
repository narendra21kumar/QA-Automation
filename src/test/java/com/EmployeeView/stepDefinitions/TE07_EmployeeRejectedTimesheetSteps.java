package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE05_RejectedTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TE07_EmployeeRejectedTimesheetSteps {
	WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE05_RejectedTimesheetPage ApprovedTimesheet;

	@Given("User login timesheet page with Username and Passwords")
	public void user_login_timesheet_page_with_username_and_password() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		ApprovedTimesheet = new PE05_RejectedTimesheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	@When("Click on  Rejected TimesheetIcon")
	public void click_on_rejected_timesheet_icon() {
		ApprovedTimesheet.ClickOnRejectIcon();
	}

	@Then("Validate the outcomes for Rejection")
	public void i_validate_the_outcomes_for_rejection() {
		ApprovedTimesheet.ExpandArrowForVerify();
	}


}
