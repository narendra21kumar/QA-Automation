package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM17_ManagerExceededTimesheetHoursPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM17_ManagerExceededTimesheetHoursSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM17_ManagerExceededTimesheetHoursPage managerExceededTimesheetHoursPage;

	@Given("Manager login into the timesheet for time validation")
	public void manager_login_into_the_timesheet_for_time_validation() {
		Logs.initLogs(TM17_ManagerExceededTimesheetHoursSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		managerExceededTimesheetHoursPage = new PM17_ManagerExceededTimesheetHoursPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on create timesheet page")
	public void click_on_create_timesheet_page() throws Exception {
		managerExceededTimesheetHoursPage.CreateTimesheetIcon();
	}

	@And("Select the future date from calendar")
	public void select_the_future_date_from_calendar() throws InterruptedException {
		managerExceededTimesheetHoursPage.selectFutureWeekDate();
	}

	@And("Enter timehseet details {string}")
	public void enter_timehseet_details(String sheetName) throws Exception {
		managerExceededTimesheetHoursPage.enterTaskDescriptionCategorySubcategory(sheetName);
	}

	@And("Click on saveall icon")
	public void click_on_saveall_icon() {
		managerExceededTimesheetHoursPage.saveAll();
	}

	@Then("Validate error is displaying for more than twenty four hours per day {string}")
	public void validate_error_is_displaying_for_more_than_twenty_four_hours_per_day(String HoursValidation)
			throws Exception {
		managerExceededTimesheetHoursPage.validateHoursValidation(HoursValidation);
	}
}
