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

public class TC07_AdminDraftTimesheet {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	public PA04_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("Login as Admin for Draft Functionality")
	public void user_login_timesheet_page() {
		Logs.initLogs(TC07_AdminDraftTimesheet.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		CreateTimeSheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}
	
	@When("Click on Create timesheet icon for draft functionality")
	public void click_on_create_timesheet_icon_for_draft_functionality() throws Exception {
		CreateTimeSheetPage.createTimesheetIcon();
	}
	@And("Select the Past week date for Admin draft functionality")
	public void select_the_past_week_date_of_Admin_view_to_verify_draft_functionality() throws InterruptedException {
		CreateTimeSheetPage.selectcalendar();
		CommonUtils.waitFor(3);
		CreateTimeSheetPage.selectPastWeekDate();
//		CommonUtils.selectAnyWeek(driver, -1);
		//CreateTimeSheetPage.selectPastWeekDate();
	}

	@Then("Validate is record is being saved and submitted")
	public void click_on_peding_icon_for_verify_the_draft_functionlity() throws Exception {
		CreateTimeSheetPage.draftSubmitBtnEnabled();

	}
}
