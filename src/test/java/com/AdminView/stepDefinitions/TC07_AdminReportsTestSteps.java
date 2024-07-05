package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.AdminViewTimeSheet.page.PA09_AdminReportsPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC07_AdminReportsTestSteps {
	public PA01_LoginPage loginPage;
	public WebDriver driver;
	public PA04_CreateTimeSheetPage createTimesheetPage;
	public PA09_AdminReportsPage adminReportsPage;
	
	
	@Then("^Click on Reports Icon in Home page$")
	public void click_on_reports_icon_in_home_page_() {
		adminReportsPage.clickonReportsIcon();
	}

	@And("^Select the values in Timesheet Submission Report Dropdown \"(.*)\"$")
	public void select_the_values_in_timesheet_submission_report_dropdown(String nameOfValue)  {
		adminReportsPage.selecttimeSheetSubmittReportDropDown(nameOfValue);
	}

	@And("^Select the Client from client dropdow in Timesheet Submission Report \"(.*)\"$")
	public void select_the_client_from_client_dropdow_in_timesheet_submission_report(String nameOfClient) {
		adminReportsPage.selectClient(nameOfClient);
	}
	
	@And("^Select the Team from Team dropdow in Timesheet Submission Report \"(.*)\"$")
	public void select_the_Team_from_Team_dropdow_in_timesheet_submission_report(String nameOfTeam) {
		adminReportsPage.selectTeam(nameOfTeam);
	}
	
	@And("^Select the Status from Status dropdown in Timesheet Submission Report of Admin View \"(.*)\"$")
	public void select_the_status_from_status_dropdown_in_timesheet_submission_report_of_admin_view(String nameOfStatus) throws InterruptedException {
		adminReportsPage.selectStatus(nameOfStatus);
		Thread.sleep(5000);
	}
	
	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is for reports page of Admin View$")
	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
		adminReportsPage.selectStartDateandMonthforSubmitted(Startmonth,Startdate);
	}
	
	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" is for reports page of Admin View$")
	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		adminReportsPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);
	}
	
	@And("Search for text and filter the reports records for Admin View {string}")
	public void Search_for_text_and_filter_the_reports_records_for_Admin_View(String text) {
		adminReportsPage.searchByOption(text);
	}
	
	@And("^Verify Employee Status from Reports based on \"(.*)\" and \"(.*)\" and \"(.*)\" of Admin View$")
	public void verify_employee_status_from_reports_based_on_empName_and_result_of_admin_view(String EmpName, String Status , String SubDate) {
		adminReportsPage.verifyFromReports(EmpName, Status, SubDate);
	}


	@Given("User Should Log in to Timesheet Admin View for Reports page validations")
	public void user_login_to_adminview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminReportsPage = new PA09_AdminReportsPage(driver);
		createTimesheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
	}
}
