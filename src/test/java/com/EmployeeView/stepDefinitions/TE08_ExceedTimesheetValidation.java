package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TE08_ExceedTimesheetValidation {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("User login timesheet page for TimesheetValidation")
	public void user_login_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	//////////// timing validation//////////
	@When("Enter task desc and hours,Click On save for time validation")
	public void enter_task_desc_and_hours_click_on_save_for_time_validation() throws Exception {
		CreateTimeSheetPage.CreateTimeSheetIconClick();
		CreateTimeSheetPage.selectcalendar();
		CommonUtils.CalenderSelectWithDate(driver, 1);
		CreateTimeSheetPage.taskdispAndHours();
	}

	@Then("verify error is displaying or not for time validation")
	public void verify_error_is_displaying_or_not_for_time_validation() throws Exception {
		CreateTimeSheetPage.validateHoursvalidation();
	}

	@Then("verify error is displaying or not for time validation for {int} hrs")
	public void verify_error_is_displaying_or_not_for_time_validation_for_hrs(Integer int1) throws Exception {
		CreateTimeSheetPage.validationFor40hrs();
	}
}
