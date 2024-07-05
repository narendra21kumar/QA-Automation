package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TE09_EmployeeDraftTimesheet {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("User login timesheet page for Draft Timesheet")
	public void user_login_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
	
	@Given("Create Timesheet to verify draftFunc")
	public void create_timesheet_to_verify_draft_func() throws Exception {
		CreateTimeSheetPage.CreateTimesheetFordraftFunctionality();
	}

	@When("Click on Peding icon for verify the draftFunctionlity")
	public void click_on_peding_icon_for_verify_the_draft_functionlity() throws Exception {
		CreateTimeSheetPage.VerifydraftFunctionality();

	}
}
