package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA02_TimeSheetManagementPage;
import com.AdminViewTimeSheet.page.PA05_ApprovedTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TA04_ApprovedTimesheetSteps {

	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA05_ApprovedTimeSheetPage approvedTimesheetPage;

	@Given("^Click on TimesheetManagementPage icon for Admin View$")
	public void Click_on_TimesheetManagementPage_icon_for_Admin_View() throws IOException {
		approvedTimesheetPage.TimeSheetSubmitted();
	}
	
	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is$")
	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
		approvedTimesheetPage.startCalendar();
		approvedTimesheetPage.selectStartDateandMonthforSubmitted(Startmonth,Startdate);
	}
	
	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" is$")
	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		approvedTimesheetPage.endCalendar();
		approvedTimesheetPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);
		
	}
	
	@And("^Enter Emp Id \"(.*)\" for Approval of Approved Timesheet Page$")
	public void enter_EmpId_for_Approve(String empid) {
		approvedTimesheetPage.approveTimesheet(empid);
	}
	
	@When("click on Approved TimesheetIcon In AdminView")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		approvedTimesheetPage.clickonapprovedIcon();
	}

	@Then("In Admin Approve Page Enter Start Month {string} and Enter Start date {string} is")
	public void in_admin_approve_page_enter_start_month_and_enter_start_date_is(String Startmonth, String Startdate) {
		approvedTimesheetPage.startCalendar();
		approvedTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
	}

	@Then("In Admin Approve Page Enter End Month {string} and Enter End date {string} is")
	public void in_admin_approve_page_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		approvedTimesheetPage.endCalendar();
		approvedTimesheetPage.selectEndDateandMonth(EndMonth, EndDate);
	}

	@Then("Verify the Approved Status based on Employee code")
	public void verify_the_approved_status_based_on_employee_code() {
		approvedTimesheetPage.verifyApprovedEmployees();
	}
	
	@Given("User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		approvedTimesheetPage = new PA05_ApprovedTimeSheetPage(driver);
		loginPage.doLogIn();
	}
}
