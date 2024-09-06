package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.AdminViewTimeSheet.page.PA08_AdminReportsPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC11_AdminReportsTestSteps {
	public PA01_LoginPage loginPage;
	public WebDriver driver;
	public PA04_CreateTimeSheetPage createTimesheetPage;
	public PA08_AdminReportsPage adminReportsPage;

	@Given("Login as Admin for Reports")
	public void user_login_to_adminview() {
		Logs.initLogs(TC11_AdminReportsTestSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminReportsPage = new PA08_AdminReportsPage(driver);
		createTimesheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("^Click on Reports Icon$")
	public void click_on_reports_icon_in_home_page_() {
		adminReportsPage.clickonReportsIcon();
	}

	@And("^Select values from Timesheet Submission Report Dropdown \"(.*)\"$")
	public void select_the_values_in_timesheet_submission_report_dropdown(String nameOfValue) {
		adminReportsPage.selectTimeSheetSubmittReportDropDown(nameOfValue);
		CommonUtils.waitFor(3);
	}

	@And("^Select Client from client dropdown in Timesheet Submission Report \"(.*)\"$")
	public void select_the_client_from_client_dropdow_in_timesheet_submission_report(String nameOfClient) {
		adminReportsPage.selectClient(nameOfClient);
		CommonUtils.waitFor(3);
	}

	@And("^Select Team from Team dropdown in Timesheet Submission Report \"(.*)\"$")
	public void select_the_Team_from_Team_dropdow_in_timesheet_submission_report(String nameOfTeam) {
		adminReportsPage.selectTeam(nameOfTeam);
		CommonUtils.waitFor(3);
	}

	@And("^Select Status from Status dropdown in Timesheet Submission Report of Admin View \"(.*)\"$")
	public void select_the_status_from_status_dropdown_in_timesheet_submission_report_of_admin_view(String nameOfStatus)
			throws InterruptedException {
		adminReportsPage.selectStatus(nameOfStatus);
		CommonUtils.waitFor(3);
	}

	@Then("Validate title of the page for Admin Reports")
	public void verify_title_of_the_page_for_admin_reports() {
		adminReportsPage.printAdminReportNames();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * @When("Click on Calendor Icon for Start Date") public void
	 * click_on_calendor_for_selection_of_Start_date() throws InterruptedException {
	 * adminReportsPage.clickOnCalendorStartIcon(); CommonUtils.waitFor(3); }
	 * 
	 * @Then("^Select Start Date$") public void
	 * select_start_date_for_previous_two_weeks() throws InterruptedException {
	 * adminReportsPage.selectAnyWeek(2, Calendar.SUNDAY); CommonUtils.waitFor(3);
	 * //adminReportsPage.selectStartDateInCal(); }
	 * 
	 * @And("Click on Calendor for selection of End Date") public void
	 * click_on_calendor_for_selection_of_End_Date() throws InterruptedException {
	 * adminReportsPage.clickOnCalendorEndIcon(); CommonUtils.waitFor(3); }
	 * 
	 * @And("^Select End Date$") public void select_start_date_for_current_week()
	 * throws InterruptedException { adminReportsPage.selectAnyWeek(-2,
	 * Calendar.SATURDAY); CommonUtils.waitFor(3);
	 * //adminReportsPage.selectEndDateInCal(); }
	 */

//	@And("Search for text and filter the reports records for Admin View {string}")
//	public void Search_for_text_and_filter_the_reports_records_for_Admin_View(String text) {
//		adminReportsPage.searchByOption(text);
//	}
//	
//	@And("^Verify Employee Status from Reports based on \"(.*)\" and \"(.*)\" and \"(.*)\" of Admin View$")
//	public void verify_employee_status_from_reports_based_on_empName_and_result_of_admin_view(String EmpName, String Status , String SubDate) {
//		adminReportsPage.verifyFromReports(EmpName, Status, SubDate);
//	}
//
//	@Then("Verify Employee Name is Exist {string}")
//	public void Verify_Employee_Name_is_Exist (String VerifyempName) throws InterruptedException {
//		adminReportsPage.VerifyEmpRecordExist(VerifyempName);
//		CommonUtils.waitFor(3);
//	}
//
//
//	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is for reports page of Admin View$")
//	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
//		adminReportsPage.selectStartDateandMonthforSubmitted(Startmonth,Startdate);
//		CommonUtils.waitFor(3);
//	}
//	
//	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" is for reports page of Admin View$")
//	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
//		adminReportsPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);
//		CommonUtils.waitFor(3);
//	}

	//////////////////////////////////////////////////////////////////////////////////////////

}
