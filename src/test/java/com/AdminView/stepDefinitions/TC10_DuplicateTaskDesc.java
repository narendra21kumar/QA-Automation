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

public class TC10_DuplicateTaskDesc {
	WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA04_CreateTimeSheetPage createTimesheet;

	@Given("Login as Admin for Duplicate Task Desc functionality")
	public void user_login_to_managerview() {
		Logs.initLogs(TC10_DuplicateTaskDesc.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		createTimesheet = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on Create Timesheet Icon for DuplicateTask Desc in Admin")
	public void CreateTimesheetIcon() throws Exception {
		createTimesheet.createTimesheetIcon();
		CommonUtils.waitFor(3);
	}

	@And("Select the date from calendor for DuplicateTask Desc in Admin")
	public void SeletionOfFutureDate() throws InterruptedException {
		createTimesheet.selectcalendar();
		CommonUtils.selectAnyWeek(driver, 1);
	}

	@And("Enter Duplicate Task Desc and Category and Subcategory in Admin")
	public void select_and_enter_the_task_description_category_subcategory_and_hours_details_for_admin_view()
			throws Exception {
		createTimesheet.enterTaskDiscriptionCategorySubcategory("duplicateTaskDesc@Admin");
	}

	@Then("Validate error triggered as Duplicate Task Desc in Admin")
	public void verify_error_is_displaying_or_not_for_time_validation() throws Exception {
		createTimesheet.validateTaskdesc();
	}

}
