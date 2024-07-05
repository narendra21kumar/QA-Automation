package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA08_ApproveSelfTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC06_ApproveSelfTimeSheetSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA08_ApproveSelfTimesheetPage selfapprovedTimesheetPage;

	
	@Given("^Click on TimesheetManagementPage icon for Admin View for self Timesheet$")
	public void Click_on_TimesheetManagementPage_icon_for_Admin_View_for_self_Timesheet() throws IOException {
		selfapprovedTimesheetPage.TimeSheetSubmitted();
	}
	
    @When("^Click on Enable Toggle icon$")
    public void enable_ToggleIcon() {
    	selfapprovedTimesheetPage.enableToggle();
    }   
	
	@And("^Enter Emp Id \"(.*)\" for Approval of Approved Timesheet Page of self$")
	public void enter_EmpId_for_Approve(String empid) {
		selfapprovedTimesheetPage.approveTimesheet(empid);
	}
	
	@When("click on Approved TimesheetIcon In AdminView for self timesheet")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		selfapprovedTimesheetPage.clickonapprovedIcon();
	}

	@Then("In Admin Approve Page Enter Start Month {string} and Enter Start date {string} for self timesheet")
	public void in_admin_approve_page_enter_start_month_and_enter_start_date_is(String Startmonth, String Startdate) {
		selfapprovedTimesheetPage.startCalendar();
		selfapprovedTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
	}

	@Then("In Admin Approve Page Enter End Month {string} and Enter End date {string} for self timesheet")
	public void in_admin_approve_page_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		selfapprovedTimesheetPage.endCalendar();
		selfapprovedTimesheetPage.selectEndDateandMonth(EndMonth, EndDate);
	}

	@Then("Verify the Approved Status based on Employee code for self timesheet {string}")
	public void verify_the_approved_status_based_on_employee_code(String Date) {
		//selfapprovedTimesheetPage.verifyApprovedEmployees();
		selfapprovedTimesheetPage.verifyApprovedEmployeDate(Date);
	}
	
	@Given("User should login to Admin View of Timesheet and Navigate to Approved Timesheet Page for self timesheet")
	public void user_login_to_adminview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		selfapprovedTimesheetPage = new PA08_ApproveSelfTimesheetPage(driver);
		loginPage.doLogIn();
	}
}