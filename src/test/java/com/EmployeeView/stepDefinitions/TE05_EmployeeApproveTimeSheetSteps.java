package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE04_ApproveTimesheetPage;
import com.EmployeeViewTimeSheet.page.PE05_RejectedTimesheetPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE05_EmployeeApproveTimeSheetSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE04_ApproveTimesheetPage ApprovedTimesheet;
	
	@Given("Login as the Employee's Role")
	public void user_login_timesheet_page_with_username_and_password() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		ApprovedTimesheet = new PE04_ApproveTimesheetPage(driver);
		loginPage.doLogInAsEmp(); 
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	@Then("Click on Approved Timesheet Icon")
	public void click_on_approved_timesheet_icon() {
		ApprovedTimesheet.clickOnApprovedIcon();
	}
	@Then("Click on Expand Icon to Verify the Approved Status {string}")
	public void verify_the_approved_status_and_approved_on_date(String approvedText) {
		ApprovedTimesheet.ExpandArrowForVerify(approvedText);
	}

	

}
