package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM05_RejectedTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

public class TM07_RejectedTimesheetSteps {
	WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM05_RejectedTimesheetPage rejectedTimesheet;

	@Given("Click on Reject TimeSheet Master page for manager view")
	public void click_on_reject_time_sheet_master_page() {
		rejectedTimesheet.rejectIcon();
	}

	@Given("Enter the select weekDate for manager view")
	public void enter_the_select_week_date() {
		rejectedTimesheet.selectweekDate();
	}

	@Given("Expand the icon to verify the status for manager view")
	public void expand_the_icon_to_verify_the_status() {
		rejectedTimesheet.ExpandArrowToVerify("05 May 2024");
	}

	@Given("User login for rejected timesheet page for manager view")
	public void user_login_for_rejected_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		rejectedTimesheet = new PM05_RejectedTimesheetPage(driver);
		loginPage.doLogIn();
	}
}