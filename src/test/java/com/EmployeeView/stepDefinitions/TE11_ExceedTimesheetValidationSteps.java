package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.EmployeeViewTimeSheet.page.PE06_TimesheetExceedANDPerdayHoursValidation;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TE11_ExceedTimesheetValidationSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE06_TimesheetExceedANDPerdayHoursValidation CreateTimeSheetPage;
	
	@Given("Login As Employee role")
	public void user_login_timesheet_page() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE06_TimesheetExceedANDPerdayHoursValidation(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	@When("Click on create TimeSheetPage")
	public void createTimesheetPage() throws Exception {
		CreateTimeSheetPage.CreateTimesheetIcon();
		
	}
	@When("Select the Future Week Date from Calender Icon")
	public void selectTheFutureDate() throws Exception {
		CreateTimeSheetPage.selectfutureWeekDate();
	}
	//////perDayValidation/////
//	@When("Enter task desc and hours,Click On save button {string}")
//	public void CreateTimesheetAndSubmit(String Sheet) throws Exception {
//		CreateTimeSheetPage.enterTaskDiscriptionCategorySubcategory(Sheet);
//		CreateTimeSheetPage.saveAll();
//	}
	@When("Click On save button in employeeView")
	public void SaveSubmitButton() throws Exception {
		CreateTimeSheetPage.saveAll();
	}
	//////40hours/////////
	@When("Enter task desc and hours {string}")
	public void EnterTaskDisc(String Sheet) throws Exception {
		CreateTimeSheetPage.enterTaskDiscriptionCategorySubcategory(Sheet);
	
	}
	@When("Click On save submit button in employeeView")
	public void saveSubmit() throws Exception {
		CreateTimeSheetPage.saveSubmit();
	
	}
	
	@Then("Validate error is displaying for more then 24 hours per day {string}")
	public void MoreThen24Hoursvalidation(String HoursValidate) throws Exception {
		CreateTimeSheetPage.validateHoursvalidation(HoursValidate);
	}
	@Then("Validate error is displaying for less then 40 hours per week {string}")
	public void lessThen40validation(String HoursValidate) throws Exception {
		CreateTimeSheetPage.validationFor40hrs(HoursValidate);
	}


}
