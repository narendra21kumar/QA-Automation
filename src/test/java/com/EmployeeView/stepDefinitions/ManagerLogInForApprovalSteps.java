package com.EmployeeView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;
 
import com.EmployeeViewTimeSheet.page.ManagerLoginForApprovalPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class ManagerLogInForApprovalSteps {
 
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private ManagerLoginForApprovalPage managerLoginForApproval;
 
	
	@Given("Login as Manager credentials")
	public void login_as_manager_credentials() {
		 driver = WebDriverManager.getDriver();
		 loginPage = new PE01_LoginPage(driver);
			loginPage.doLogInAsMananger();
			managerLoginForApproval = new ManagerLoginForApprovalPage(driver);
	}
	@When("Click on TimeSheet Management Page in Manager View")
	public void click_on_time_sheet_management_page_in_manager_view_and() {
		managerLoginForApproval.clickonTimeSheetMaangementIcon();
	}
 
	@And("Select the week to approve")
	public void timesheet_records_are_listed_to_that_respective_week() {
		managerLoginForApproval.startCalendar();		
		managerLoginForApproval.selectDate();
	}
 
	@And("Approved the timesheet for employee for selected week")
	public void verify_manager_view_allows_to_approve_the_timesheet_and_approve_the_selected_timesheet() {
 
		managerLoginForApproval.getAttribute();
	}
 
	@Then("click on Approved TimesheetIcon in Manager View and Verify the status and Approved date")
	public void click_on_approved_timesheet_icon_in_manager_view_and_verify_the_status_and_approved_date() {
 
		managerLoginForApproval.EmpApprovedTimesheetandVerify();
	}
	
 
}