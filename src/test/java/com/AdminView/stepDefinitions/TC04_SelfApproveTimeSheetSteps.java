package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA08_ApproveSelfTimesheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC04_SelfApproveTimeSheetSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA08_ApproveSelfTimesheetPage selfapprovedTimesheetPage;

	@Given("Login as Admin for self approval of Timesheet")
	public void user_login_to_adminview() {
		Logs.initLogs(TC04_SelfApproveTimeSheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		selfapprovedTimesheetPage = new PA08_ApproveSelfTimesheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@And("^Click on Admin Timesheet Management Page Icon$")
	public void Click_on_TimesheetManagementPage_icon_for_Admin_View_for_self_Timesheet() throws IOException {
		selfapprovedTimesheetPage.timeSheetSubmitted();
	}

	@And("^Click on Enable Toggle icon$")
	public void enable_ToggleIcon() {
		selfapprovedTimesheetPage.enableToggle();
	}

	@And("^Click on checkbox for self Bulk Approval$")
	public void and_click_on_checkbox_for_bulk_approval_for_admin_view_bulk_approval() {
		selfapprovedTimesheetPage.bulkApprove();
	}

	@And("Approve the timesheet for Admin for current week record {string}")
	public void enter_EmpId_for_Approve(String empId) {
		selfapprovedTimesheetPage.approveTimesheet(empId);
	}

	@And("Click on Approved Timesheet Icon In AdminView for self approval of Timesheet")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		selfapprovedTimesheetPage.clickonapprovedIcon();
	}

	@Then("Verify the Approved Status based on Employee code for self timesheet {string}")
	public void verify_the_approved_status_based_on_employee_code(String Date) {
		// selfapprovedTimesheetPage.verifyApprovedEmployees();
		selfapprovedTimesheetPage.verifyApprovedEmployeDate(Date);
	}

//	@Then("In Admin Approve Page Enter Start Month {string} and Enter Start date {string} for self timesheet")
//	public void in_admin_approve_page_enter_start_month_and_enter_start_date_is(String Startmonth, String Startdate) {
//		selfapprovedTimesheetPage.startCalendar();
//		selfapprovedTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
//	}
//
//	@Then("In Admin Approve Page Enter End Month {string} and Enter End date {string} for self timesheet")
//	public void in_admin_approve_page_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
//		selfapprovedTimesheetPage.endCalendar();
//		selfapprovedTimesheetPage.selectEndDateandMonth(EndMonth, EndDate);
//	}

}
