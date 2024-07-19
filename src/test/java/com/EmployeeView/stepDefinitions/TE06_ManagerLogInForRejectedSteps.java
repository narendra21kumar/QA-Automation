package com.EmployeeView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;
 
import com.EmployeeViewTimeSheet.page.PE07_ManagerLogInForRejectedPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class TE06_ManagerLogInForRejectedSteps {
 
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private PE07_ManagerLogInForRejectedPage managerLoginForrejected;
 
	@Given("Login as Manager's Role") 
	public void login_as_manager_credentials() {
		 driver = WebDriverManager.getDriver();
		 loginPage = new PE01_LoginPage(driver);
			loginPage.doLogInAsMananger();
			managerLoginForrejected = new PE07_ManagerLogInForRejectedPage(driver);		
	}
	@When("Click on TimeSheet Management Page in Manager's View")
	public void click_on_time_sheet_management_page_in_manager_view_and() {
		managerLoginForrejected.clickonTimeSheetMaangementIcon();
	}
 
	@When("Select the week to Reject the Employee Timesheet")
	public void select_the_week_to_reject_the_timesheet_for_employee() throws InterruptedException {
		managerLoginForrejected.selectPastWeekDate();		
		
	}
	@Then("Reject the timesheet for employee for the selected week {string}")
	public void rejectTheTimesheet(String Remarks) {
		managerLoginForrejected.getAttribute(Remarks);
		
	}
	@Then("Click on Reject Timesheet Icon in Manager View")
	public void RejectTimesheetIcon() throws InterruptedException {
		managerLoginForrejected.EmpRejectedTimesheetIcon();
	}
	@Then("Validate the status Rejected date")
	public void vadidatingTheStatus() throws InterruptedException {
		managerLoginForrejected.RejectedTimesheetValidating();
	}

}