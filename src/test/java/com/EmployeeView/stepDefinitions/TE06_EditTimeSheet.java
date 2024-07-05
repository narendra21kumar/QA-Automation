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

public class TE06_EditTimeSheet {

	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("User login to timesheet page for edit timesheet")
	public void user_login_timesheet_page() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

//////////////edit//////////////////
	@When("Click on Create TimeSheet icon and select the draft Timesheet Date")
	public void click_on_create_time_sheet_icon_and_select_the_draft_timesheet_date() throws Exception {
		CreateTimeSheetPage.CreateTimeSheetIconClick();
		CreateTimeSheetPage.selectcalendar();
		CommonUtils.CalenderSelectWithDate(driver, 19);
	}

	@Then("Select the edit icon")
	public void select_the_edit_icon() {
		CreateTimeSheetPage.editicon();
	}

	@And("Enter the edit Task Description and hours")
	public void enter_the_edit_task_description_and_hours() throws Exception {
		CommonUtils.edittaskDesccategoryandEnteringHours(driver, "EmployeeView_Edit_Hours");
		CreateTimeSheetPage.saveAll();
		CreateTimeSheetPage.submit();
		CreateTimeSheetPage.confirm();
	}

}
