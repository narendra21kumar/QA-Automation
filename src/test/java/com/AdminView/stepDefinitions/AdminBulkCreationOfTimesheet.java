package com.AdminView.stepDefinitions;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
 
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class AdminBulkCreationOfTimesheet {
	public static WebDriver driver;
	public PA01_LoginPage loginPage;
	public PA04_CreateTimeSheetPage createTimesheetPage;
 
	@Given("^click on Create Timesheet  icon for Admin View of Timesheet for AdminBulkCreationOfTimesheet$")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws IOException {
		createTimesheetPage.CreateTimeSheetIconClick();
	}
 
	@When("^Enter Date Value for \"(.*)\" for Create Timesheet is for AdminBulkCreationOfTimesheet$")
	public void enter_StartMonth_and_enter_Startdate_is(int DateValue) {
		createTimesheetPage.selectcalendar();
		createTimesheetPage.futureWeekSelectBasedonReq(DateValue);
		//createTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
	}
	
//	@When("^Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" for Create Timesheet is for AdminBulkCreationOfTimesheet$")
//	public void enter_StartMonth_and_enter_Startdate_is(String Startmonth, String Startdate) {
//		createTimesheetPage.selectcalendar();
//        //CommonUtils.futureWeekSelectBasedonReq();
//		createTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
//	}
// 
	@Then("Fill all mandatory fields {string} for AdminBulkCreationOfTimesheet")
	public void fill_all_mandatory_fields(String sheetname) throws Exception {

		createTimesheetPage.enterTimeSheetDetails();
	}
 
	@And("^Click on save and Confirm for AdminBulkCreationOfTimesheet$")
	public void click_on_save_and_Confirm() {
		CommonUtils.scrollTillTop(driver);
		createTimesheetPage.saveAll();
		createTimesheetPage.submit();
		createTimesheetPage.confirm();
	}
 
	@Given("User login to Admin View for AdminBulkCreationOfTimesheet")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		createTimesheetPage = new PA04_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
	}
}
