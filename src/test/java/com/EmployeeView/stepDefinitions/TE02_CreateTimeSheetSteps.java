package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TE02_CreateTimeSheetSteps {

	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@When("Click on Create TimeSheet Master page")
	public void click_on_create_time_sheet_master_page() {
		CreateTimeSheetPage.CreateTimeSheetIconClick();
	}

	@Then("^Select the current week date$")
	public void select_the_current_week_date() throws InterruptedException {
		CreateTimeSheetPage.selectcalendar();
		CreateTimeSheetPage.selectCurrentWeek();
	   // CreateTimeSheetPage.futureWeekSelect();
		// PE02_CreateTimeSheetPage.datePickerAutomaticFuture();
	}

	@And("select and Enter the task disc,hours and category for Employee")
	public void select_and_enter_the_task_disc_hours_and_category_for_employee() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "14th Week");
		CreateTimeSheetPage.saveAll();
		CreateTimeSheetPage.submit();
		CreateTimeSheetPage.confirm();
	}

	@When("Enter task Description and Click On save")
	public void enter_task_description_and_click_on_save() throws Exception {
		CreateTimeSheetPage.CreateTimeSheetIconClick();
		CreateTimeSheetPage.selectcalendar();
		CommonUtils.CalenderSelectWithDate(driver, 1);
		CreateTimeSheetPage.taskdesc();
	}

	@Then("validate task Description")
	public void validate_task_description() throws Exception {
		// CreateTimeSheetPage.validateTaskdesc();
	}

	@Given("User login timesheet page")
	public void user_login_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

}
