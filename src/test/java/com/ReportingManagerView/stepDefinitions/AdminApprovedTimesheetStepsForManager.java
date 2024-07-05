package com.ReportingManagerView.stepDefinitions;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.ReportingManagerViewTimeSheet.page.AdminApprovedTimeSheetPageForManager;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AdminApprovedTimesheetStepsForManager {
 
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private AdminApprovedTimeSheetPageForManager approvedTimesheetPage;

	@Given("^Click on TimesheetManagementPage icon for manager view$")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws IOException {
		approvedTimesheetPage.TimeSheetSubmitted();
	}
	
	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is for manager view$")
	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
		approvedTimesheetPage.startCalendar();
		approvedTimesheetPage.selectStartDateandMonthforSubmitted(Startmonth,Startdate);
	}
	
	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" is for manager view$")
	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		approvedTimesheetPage.endCalendar();
		approvedTimesheetPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);
		
	}
	
	@And("^Enter Emp Id \"(.*)\" for Approval of Approved Timesheet Page for manager view$")
	public void enter_EmpId_for_Approve(String empid) {
		approvedTimesheetPage.approveTimesheet(empid);
	}
	
	@When("click on Approved TimesheetIcon In AdminView for manager view")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		approvedTimesheetPage.clickonapprovedIcon();
	}

	@Then("In Admin Approve Page Enter Start Month {string} and Enter Start date {string} is for manager view")
	public void in_admin_approve_page_enter_start_month_and_enter_start_date_is(String Startmonth, String Startdate) {
		approvedTimesheetPage.startCalendar();
		approvedTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
	}

	@Then("In Admin Approve Page Enter End Month {string} and Enter End date {string} is for manager view")
	public void in_admin_approve_page_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		approvedTimesheetPage.endCalendar();
		approvedTimesheetPage.selectEndDateandMonth(EndMonth, EndDate);
	}

	@Then("Verify the Approved Status based on Employee code for manager view")
	public void verify_the_approved_status_based_on_employee_code() {
		approvedTimesheetPage.verifyApprovedEmployees();
	}
	
	@Given("User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page for manager view")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		approvedTimesheetPage = new AdminApprovedTimeSheetPageForManager(driver);
		loginPage.doLogInAsAdmin();
	}
 
}