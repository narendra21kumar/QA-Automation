package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA02_TimeSheetManagementPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TA01_TimeSheetManagementSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA02_TimeSheetManagementPage timesheetManagementPage;

	@Given("^click on timesheetManagementPage icon for Admin View$")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws IOException {
		timesheetManagementPage.clickonTimeSheetMaangementIcon();
	}
	
	@When("^Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" is$")
	public void enter_StartMonth_and_enter_Startdate_is(String Startmonth, String Startdate) {
		timesheetManagementPage.startCalendar();
		timesheetManagementPage.selectStartDateandMonth(Startmonth,Startdate);
	}
	
	
	@And("^Enter End Month \"(.*)\" and Enter End date \"(.*)\" is$")
	public void enter_EndMonth_and_enter_Enddate_is(String EndMonth, String EndDate) {
		timesheetManagementPage.endCalendar();
		timesheetManagementPage.selectStartDateandMonth(EndMonth,EndDate);
	}
	
	@And("^Enter Emp Id \"(.*)\" for Approval$")
	public void enter_EmpId_for_Approve(String empid) {
		//timesheetManagementPage.approveTimesheet(empid);
	}
	
	
	@Given("Validate Admin Response")
	public void validate_response() {
		// createTimesheet.CreateTimesheet();
	}

	@Given("user login to Admin View")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		timesheetManagementPage = new PA02_TimeSheetManagementPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

}
