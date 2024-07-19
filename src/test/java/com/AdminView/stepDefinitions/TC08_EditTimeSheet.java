package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC08_EditTimeSheet {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	public PA04_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("login as Admin Timesheet for edit functioanlity")
	public void user_login_to_admin_timesheet_for_edit_functioanlity() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		CreateTimeSheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	@When("Click on Create TimeSheet icon and select the previous week in calendor for admin edit")
	public void click_on_create_time_sheet_icon_and_select_the_draft_timesheet_date() throws Exception {
		CreateTimeSheetPage.CreateTimesheetIcon();
		CreateTimeSheetPage.selectcalendar();
		CreateTimeSheetPage.selectAnyWeek(-1);
		//CreateTimeSheetPage.selectPastWeekDate();
	}

	@And("Click on Edit Icon in Edit Page")
	public void select_the_edit_icon_for_admin_edit() {
		CreateTimeSheetPage.editicon();
	}

	@And("Update Timesheet and Submit")
	public void update_the_timesheet_and_click_on_save_for_admin_edit() throws Exception {
		CommonUtils.edittaskDesccategoryandEnteringHours(driver, "editTimesheet@Admin");
		CreateTimeSheetPage.saveSubmitConfirm();

	}
	
}
