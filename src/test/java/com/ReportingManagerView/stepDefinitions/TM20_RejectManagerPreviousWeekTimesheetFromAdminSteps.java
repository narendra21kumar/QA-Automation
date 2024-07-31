package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM20_RejectManagerPreviousWeekTimesheetFromAdminPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TM20_RejectManagerPreviousWeekTimesheetFromAdminSteps {

	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM20_RejectManagerPreviousWeekTimesheetFromAdminPage rejectManagerPreviousWeekTimesheetFromAdminPage;
	
	@Given("Admin login into the timesheet and reject the manager submitted timesheet")
	public void admin_login_into_the_timesheet_and_reject_the_manager_submitted_timesheet() {
		driver = WebDriverManager.getDriver();
	    loginPage = new PM01_LoginPage(driver);
	    rejectManagerPreviousWeekTimesheetFromAdminPage=new PM20_RejectManagerPreviousWeekTimesheetFromAdminPage(driver);
		loginPage.doLogInAsAdmin();
	}
	
	@When("Click on timesheet icon in admin view")
	public void click_on_timesheet_icon_in_admin_view() {
		rejectManagerPreviousWeekTimesheetFromAdminPage.submittedPage();
	}

	@And("Select previous week date from calendar in admin view")
	public void select_previous_week_date_from_calendar_in_admin_view() throws InterruptedException {
		rejectManagerPreviousWeekTimesheetFromAdminPage.selectPastWeekDate();
	}

	@And("Click on timesheet management icon based on empid {string} and enter the remarks {string} in text field")
	public void click_on_timesheet_management_icon_based_on_empid_and_enter_the_remarks_in_text_field(String empid, String remarks) {
		rejectManagerPreviousWeekTimesheetFromAdminPage.rejectTimesheet(empid, remarks);
	}

}
