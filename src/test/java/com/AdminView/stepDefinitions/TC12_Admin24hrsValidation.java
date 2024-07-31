package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC12_Admin24hrsValidation {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	public PA04_CreateTimeSheetPage createTimeSheetPage;

	@Given("Login as Admin with credentials for exceed hrs")
	public void user_login_timesheet_page() {
		Logs.initLogs(TC12_Admin24hrsValidation.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		createTimeSheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("^Click on Create Timesheet Icon for exceed hrs$")
	public void click_on_create_timesheet_icon_for_validation() throws Exception {
		createTimeSheetPage.createTimesheetIcon();
		CommonUtils.waitFor(3);
	}

	@And("Select the date from calendor for Admin exceed hrs")
	public void select_the_date_from_calendor_for_validating_less_than_40hrs_validation() throws InterruptedException {
		createTimeSheetPage.selectcalendar();
		CommonUtils.selectAnyWeek(driver, 1);
	}

	@And("Create Timesheet by exceeding more than 24hrs in a day")
	public void create_timesheet_by_filling_more_than_24hrs_in_a_any_day() throws Exception {
		createTimeSheetPage.exceedHoursPerDay();
	}

	@Then("Validate the Error while saving record")
	public void verify_error_is_displaying_or_not_for_time_validation() throws Exception {
		createTimeSheetPage.validateHoursvalidation();
	}

//
//	@And("Enter task desc and hours,Click On save for time validation in Admin")
//	public void enter_task_desc_and_hours_click_on_save_for_time_validation()throws Exception {
//		createTimeSheetPage.moreThan40Hrs();
//		CommonUtils.waitFor(3);
//	}
//	
//	@Then("Verify Validation of less than 40 hours a week is being displayed in Admin")
//	public void verify_validation_of_less_than_40_hours_a_week_is_being_displayed() throws Exception {
//		createTimeSheetPage.validationFor40hrs();
//	}
}
