package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE04_ApproveTimesheetPage;
import com.EmployeeViewTimeSheet.page.PE05_RejectedTimesheetPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE04_ApproveTimeSheetSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE04_ApproveTimesheetPage ApprovedTimesheet;

	@Then("click on Approved TimesheetIcon")
	public void click_on_approved_timesheet_icon() {
		ApprovedTimesheet.clickOnApprovedIcon();
	}
	@Then("Verify the Approved Status and approved On date")
	public void verify_the_approved_status_and_approved_on_date() {
		ApprovedTimesheet.ExpandArrowForVerify();
	}
	@Given("User login timesheet page with Username and Password")
	public void user_login_timesheet_page_with_username_and_password() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		ApprovedTimesheet = new PE04_ApproveTimesheetPage(driver);
		loginPage.doLogIn(); 
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
}
