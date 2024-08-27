package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM19_RejectManagerCurrentWeekTimesheetFromAdminPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TM19_RejectManagerCurrentWeekTimesheetFromAdminSteps {

	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM19_RejectManagerCurrentWeekTimesheetFromAdminPage rejectManagerCurrentWeekTimesheetFromAdminPage;

	@Given("Admin login into the timesheet and reject the manager approved timesheet")
	public void admin_login_into_the_timesheet_and_reject_the_manager_approved_timesheet() {
		Logs.initLogs(TM19_RejectManagerCurrentWeekTimesheetFromAdminSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		rejectManagerCurrentWeekTimesheetFromAdminPage = new PM19_RejectManagerCurrentWeekTimesheetFromAdminPage(
				driver);
		loginPage.doLogInAsAdmin();
	}
	
	@When("Click on approved icon in admin view")
	public void click_on_approved_icon_in_admin_view() {
		rejectManagerCurrentWeekTimesheetFromAdminPage.approveIconPage();
	}

	@And("Select current week date from calendar in admin view")
	public void select_current_week_date_from_calendar_in_admin_view() throws InterruptedException {
		rejectManagerCurrentWeekTimesheetFromAdminPage.selectCurrentWeek();
	}

	@And("Click on rejected timesheet icon based on empid {string} and enter the remarks {string} in text field")
	public void click_on_rejected_timesheet_icon_based_on_empid_and_enter_the_remarks_in_text_field(String empid,
			String remarks) {
		rejectManagerCurrentWeekTimesheetFromAdminPage.rejectTimesheet(empid, remarks);
	}
}
