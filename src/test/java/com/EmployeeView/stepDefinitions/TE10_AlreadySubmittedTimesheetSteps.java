package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE10_AlreadySubmittedTimesheetSteps {
	
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;
	
	
	@Given("Log in as Employee Role")
	public void user_login_timesheet_page() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogInAsEmp();;
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
	
	@Given("Select Calender for current week to verify already submitted Functionality")
	public void select_calender_to_verify_already_submitted_functionality() throws InterruptedException {
		CreateTimeSheetPage.selectCurrentWeek();
	}

	@Then("Validate the timesheet Response As {string}")
	public void i_validate_the_outcomes(String AlreadySubmittedText) throws Exception {
		CreateTimeSheetPage.ValidateTimesheetResponse(AlreadySubmittedText);
	}

}
