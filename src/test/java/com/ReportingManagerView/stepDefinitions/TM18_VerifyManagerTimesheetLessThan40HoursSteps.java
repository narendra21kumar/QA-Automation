package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM18_VerifyManagerTimesheetLessThan40HoursPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM18_VerifyManagerTimesheetLessThan40HoursSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM18_VerifyManagerTimesheetLessThan40HoursPage verifyManagerTimesheetLessThan40HoursPage;

	@Given("Manager login into the timesheet for verifying the less than fourty hours for complete week")
	public void manager_login_into_the_timesheet_for_verifying_the_less_than_fourty_hours_for_complete_week() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		verifyManagerTimesheetLessThan40HoursPage = new PM18_VerifyManagerTimesheetLessThan40HoursPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on create timesheet icon page")
	public void click_on_create_timesheet_icon_page() throws Exception {
		verifyManagerTimesheetLessThan40HoursPage.CreateTimesheetIcon();
	}

	@And("Select the future week date from calender icon")
	public void select_the_future_week_date_from_calender_icon() throws InterruptedException {
		verifyManagerTimesheetLessThan40HoursPage.selectFutureWeekDate();
	}

	@And("Enter task description,category,subcategory and hours {string}")
	public void enter_task_description_category_subcategory_and_hours(String sheetName) throws Exception {
		verifyManagerTimesheetLessThan40HoursPage.enterTaskDescriptionCategorySubcategory(sheetName);
	}

	@And("Click on save,submit and confirm button")
	public void click_on_save_submit_and_confirm_button() {
		verifyManagerTimesheetLessThan40HoursPage.saveSubmitAndConfirm();
	}

	@Then("Validate error is displaying for less then fourty hours per week {string}")
	public void validate_error_is_displaying_for_less_then_fourty_hours_per_week(String HoursValidation)
			throws Exception {
		verifyManagerTimesheetLessThan40HoursPage.validationFor40hrs(HoursValidation);
	}

}
