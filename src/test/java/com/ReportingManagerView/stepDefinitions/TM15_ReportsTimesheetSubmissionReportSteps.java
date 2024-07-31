package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM15_ReportsTimesheetSubmissionReportPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM15_ReportsTimesheetSubmissionReportSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM15_ReportsTimesheetSubmissionReportPage reportsTimesheetSubmissionReportPage;
	
	@Given("User login into the manager view for download the timesheet submission report")
	public void user_login_into_the_manager_view_for_download_the_timesheet_submission_report() {
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        reportsTimesheetSubmissionReportPage= new PM15_ReportsTimesheetSubmissionReportPage(driver);
		loginPage.doLogIn();
	}
	
	@When("Click on reports icon")
	public void click_on_reports_icon() {
		reportsTimesheetSubmissionReportPage.reports();
	}

	@And("Click on dropdown icon")
	public void click_on_dropdown_icon() {
		reportsTimesheetSubmissionReportPage.timesheetSubmissionReport();
	}

	@And("Click on export data icon")
	public void click_on_export_data_icon() {
		reportsTimesheetSubmissionReportPage.export();
	}

	@Then("validate the totalhours {string} on header part")
	public void validate_the_totalhours_on_header_part(String totalhours) {
		reportsTimesheetSubmissionReportPage.validatetotalhourstext(totalhours);
	}
}
