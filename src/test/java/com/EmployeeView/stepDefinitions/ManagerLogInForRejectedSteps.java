package com.EmployeeView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;
 
import com.EmployeeViewTimeSheet.page.ManagerLogInForRejectedPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class ManagerLogInForRejectedSteps {
 
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	private ManagerLogInForRejectedPage managerLoginForrejected;
 
	@When("Click on TimeSheet Management Page in Manager Views")
	public void click_on_time_sheet_management_page_in_manager_view_and() {
		managerLoginForrejected.clickonTimeSheetMaangementIcon();
	}
 
	@When("Select the week to reject the timesheet for employee")
	public void select_the_week_to_reject_the_timesheet_for_employee() {
		managerLoginForrejected.startCalendar();		
		managerLoginForrejected.selectDate();
		managerLoginForrejected.getAttribute();
	}
 
	@Then("click on reject TimesheetIcon in Manager View and Verify the status and remarks")
	public void click_on_reject_timesheet_icon_in_manager_view_and_verify_the_status_and_approved_date() {
		managerLoginForrejected.EmpRejectedTimesheetandVerify();
	}
	@Given("Login as Manager credentials for reject functionality")
	public void login_as_manager_credentials() {
		 driver = WebDriverManager.getDriver();
		 loginPage = new PE01_LoginPage(driver);
			loginPage.doLogInAsMananger();
			managerLoginForrejected = new ManagerLogInForRejectedPage(driver);		
	}
}