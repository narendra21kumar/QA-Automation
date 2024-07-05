package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.Admin_BulkRejection_Page;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA05_ApprovedTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AdminBulkApprovalsteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA05_ApprovedTimeSheetPage approvedTimesheetPage;
	//private TA08_AdminBulkApproval adminbulapprove;
 
	@Given("^User login for bulkapproved timesheet page for admin view bulk approval$")
	public void given_user_login_for_bulkapproved_timesheet_page_for_admin_view_bulk_approval() {

		loginPage = new PA01_LoginPage(driver);
		approvedTimesheetPage = new PA05_ApprovedTimeSheetPage(driver);
		loginPage.doLogIn();
	}
 
	@Given("^Click on TimeSheet Management page for admin view bulk approval$")
	public void given_click_on_timesheet_management_page_for_admin_view_bulk_approval() {
		approvedTimesheetPage.TimeSheetSubmitted();
	}
 
 
	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is for bulk admin approval$")
	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
		approvedTimesheetPage.startCalendar();
		approvedTimesheetPage.selectStartDateandMonthforSubmitted(Startmonth,Startdate);
	}
	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" is for bulk admin approval$")
	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		approvedTimesheetPage.endCalendar();
		approvedTimesheetPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);
	}
	@Given("search by {string} for bulk admin approval")
	public void search_by_name_and_click_on_check_box(String name) {
		approvedTimesheetPage.SearchByname(name);
		CommonUtils.waitFor(4);
	}
 
	@And("^Click on checkbox for bulk approval for admin view bulk approval$")
	public void and_click_on_checkbox_for_bulk_approval_for_admin_view_bulk_approval() {
		approvedTimesheetPage.bulkapprove();
	}
 
}