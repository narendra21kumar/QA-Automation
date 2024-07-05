package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE07_AlreadySubmitted {
	
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;
	
	
	@Given("User login timesheet page for already Submitted")
	public void user_login_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
	
	@Given("Select Calender to verify already submitted Functionality")
	public void select_calender_to_verify_already_submitted_functionality() {
		CreateTimeSheetPage.selectCalenderToVerifyalreadysubmittedFunctionality();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		//CreateTimeSheetPage.alreadysubmittedtimesheet();
	}

}
