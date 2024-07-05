package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM05_RejectedTimesheetPage;
import com.ReportingManagerViewTimeSheet.page.PM06_BulkApprovedPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class TM04_BulkApprovedTimesheetSteps {
	WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM06_BulkApprovedPage bulkapprove;;
	
	
	@Given("User login for bulkapproved timesheet page for manager view")
	public void user_login_for_bulkapproved_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		bulkapprove = new PM06_BulkApprovedPage(driver);
		loginPage.doLogIn();
	}

	@Given("Click on TimeSheet Management page for manager view")
	public void click_on_time_sheet_management_page() {
		bulkapprove.timesheetsubmittedicon();
	}

	@And("Select the  WeekDate from the calendar for manager view")
	public void select_the_week_date_from_the_calendar() {
		bulkapprove.selectstartandenddate();
	}

	@And("Click on checkbox for bulk approval for manager view")
	public void click_on_checkbox_for_bulk_approval() {
		bulkapprove.bulkapprove();
	}

}
