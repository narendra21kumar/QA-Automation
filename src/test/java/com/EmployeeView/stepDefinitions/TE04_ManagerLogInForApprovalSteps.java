package com.EmployeeView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;
 
import com.EmployeeViewTimeSheet.page.PE08_ManagerLoginForApprovalPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class TE04_ManagerLogInForApprovalSteps {
 
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE08_ManagerLoginForApprovalPage managerLoginForApproval;
 
	@Given("Login as Manager Role")
	public void login_as_manager_credentials() {
		Logs.initLogs(TE04_ManagerLogInForApprovalSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		 driver = WebDriverManager.getDriver();
		 loginPage = new PE01_LoginPage(driver);
		 loginPage.doLogInAsMananger();
		 managerLoginForApproval = new PE08_ManagerLoginForApprovalPage(driver);
	}
	@When("Click on TimeSheet Management Page in Manager View")
	public void click_on_time_sheet_management_page_in_manager_view_and() {
		managerLoginForApproval.clickonTimeSheetMangementIcon();
	}
 
	@And("Select the week to approve the Timesheet")
	public void timesheet_records_are_listed_to_that_respective_week() throws InterruptedException {
		managerLoginForApproval.startWeek();		
	
	}
 
	@And("Approved the timesheet for employee for the selected week")
	public void verify_manager_view_allows_to_approve_the_timesheet_and_approve_the_selected_timesheet() {
 
		managerLoginForApproval.getAttribute();
	}
 
	@Then("Click on Approved Timesheet Icon in Manager View and Verify the status, Approved date {string} , {string}")
	public void VerifyApprovedDate(String Empid,String approvedText) throws InterruptedException {
		managerLoginForApproval.empApprovedTimesheetandVerify(Empid,approvedText);
		Logs.endTestCase(this.getClass().getSimpleName());
	}
	////////////////////Reject The Timesheet//////////////
	@Then("Reject the timesheet {string} for employeeDeletion for the selected week {string}")
	public void RejectTimeSheet(String Empid,String rejectText) throws InterruptedException {
		managerLoginForApproval.rejectTimesheet(Empid,rejectText);
		Logs.endTestCase(this.getClass().getSimpleName());
	}

}