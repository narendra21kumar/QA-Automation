package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM16_ReportsTimesheetDetailsReportPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM16_ReportsTimesheetDetailsReportSteps {

	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM16_ReportsTimesheetDetailsReportPage reportsTimesheetDetailsReportPage;
	
	@Given("User login into the manager view for download the timesheet details report")
	public void user_login_into_the_manager_view_for_download_the_timesheet_details_report() {
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        reportsTimesheetDetailsReportPage=new PM16_ReportsTimesheetDetailsReportPage(driver);
		loginPage.doLogIn();
	}
	
	@When("Click on reports page icon")
	public void click_on_reports_page_icon() {
		reportsTimesheetDetailsReportPage.reports();
	}

	@And("Click on dropdown timesheet detail report")
	public void click_on_dropdown_timesheet_detail_report() {
		reportsTimesheetDetailsReportPage.timesheetDetailReport();
	}

	@And("Click on export data dwonload icon")
	public void click_on_export_data_dwonload_icon() {
		reportsTimesheetDetailsReportPage.export();
	}
	@Then("validate the total {string} on header part")
	public void validate_the_total_on_header_part(String total) {
		reportsTimesheetDetailsReportPage.valiadateTotalText(total);
	}
	
}
