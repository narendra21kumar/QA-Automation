package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.*;

public class TE09_EmployeeDraftTimesheetSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("Log In as the Employee Role")
	public void user_login_timesheet_page() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
	@And("Select the Past week from calender icon")
	public void create_timesheet_to_verify_draft_func() throws Exception {
		CreateTimeSheetPage.selectPastWeekDate();
	}

	@Then("Verify the Draft Functionlity by page Title as view Timesheet {string}")
	public void click_on_peding_icon_for_verify_the_draft_functionlity(String draftText) throws Exception {
		CreateTimeSheetPage.VerifydraftFunctionality(draftText);

	}
}
