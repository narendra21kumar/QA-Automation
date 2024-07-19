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
	
	@Given("Login as the Employee Role")
	public void user_login_timesheet_page_with_valid_credentials() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		pendingTimesheet = new PE03_PendingTimesheetPage(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	@When("Click on Pending Icon")
	public void click_on_pending_icon() throws InterruptedException {
		pendingTimesheet.pendingApprovalIconClick();
	}

	@Then("Click on Expand Icon to Verify the pending Status {string}")
	public void verify_the_pending_status(String pendingText) throws InterruptedException {
		pendingTimesheet.ExpandArrowtoVerify(pendingText);
	}


}
