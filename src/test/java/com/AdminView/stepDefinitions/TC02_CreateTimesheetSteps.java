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

public class TC02_CreateTimesheetSteps {
	WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA04_CreateTimeSheetPage createTimesheet;

	@Given("Access Timesheet as Admin for Current Week")
	public void user_login_to_managerview() {
		Logs.initLogs(TC02_CreateTimesheetSteps.class.getName());
//		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		createTimesheet = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on Create TimeSheetPage of Admin View")
	public void CreateTimesheetIcon() throws Exception {
		createTimesheet.createTimesheetIcon();
		CommonUtils.waitFor(3);
	}

	@And("Select the current week date of Admin View")
	public void select_the_current_week_date_of_admin_view() throws InterruptedException {
//		createTimesheet.selectcalendar();
//		CommonUtils.waitFor(3);
//		CommonUtils.selectAnyWeek(driver, 0);
//		createTimesheet.selectAnyWeek(1);
	}

	@And("Select the Previous Week Date In Admin View")
	public void SeletionOfPreviousDate() throws InterruptedException {
		createTimesheet.selectcalendar();
		createTimesheet.selectPastWeekDate();
//		CommonUtils.selectAnyWeek(driver, -1);
	}

	@And("Select the Future Week Date In Admin View")
	public void SeletionOfFutureDate() throws InterruptedException {
		createTimesheet.selectcalendar();
		createTimesheet.selectFutureWeekDate();
//		createTimesheet.selectfutureWeekDate();
//		CommonUtils.selectAnyWeek(driver, 1);
	}

	@And("Select and Enter the Task Description,Category & SubCategory and Hours Details for Admin View")
	public void select_and_enter_the_task_description_category_subcategory_and_hours_details_for_admin_view()
			throws Exception {
		createTimesheet.enterTaskDiscriptionCategorySubcategory("createTimesheet@Admin");
	}

	@And("Click On Save and Submit confirm The Timesheet in Admin View")
	public void ClickOnSaveSubmitConfirm() {
		createTimesheet.saveSubmitConfirm();
	}

	@Then("Validate the Message TimeSheet Already Submitted Is Displayed in Admin View")
	public void ValidateTimesheetResponse() throws Exception {
		createTimesheet.validateTimesheetResponse();
		CommonUtils.waitFor(3);
	}

}
