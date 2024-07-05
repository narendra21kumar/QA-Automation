package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA02_TimeSheetManagementPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*public class TA03_CreateTimesheetSteps {
	public WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA04_CreateTimeSheetPage createTimesheetPage;

	@Given("^click on Create Timesheet  icon for Admin View of Timesheet$")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws IOException {
		createTimesheetPage.CreateTimeSheetIconClick();
	}
	
	@When("^Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" for Create Timesheet is$")
	public void enter_StartMonth_and_enter_Startdate_is(String Startmonth, String Startdate) {
		createTimesheetPage.selectcalendar();
		createTimesheetPage.selectStartDateandMonth(Startmonth,Startdate);
	}
	
	@Then("^Fill all mandatory fields$")
	public void fill_all_mandatory_fields() throws Exception {
		createTimesheetPage.enterTimeSheetDetails();
	}
	
	@And("^Click on save and Confirm$")
	public void click_on_save_and_Confirm() {
		createTimesheetPage.saveAll();
		createTimesheetPage.submit();
		createTimesheetPage.confirm();	
	}
	
	
	@Given("User login to Admin View")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		createTimesheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
	}
}

*/