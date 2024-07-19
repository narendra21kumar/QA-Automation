package com.ReportingManagerView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
 
public class TM02_CreateTimesheetSteps {
 
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM02_CreateTimeSheetPage createTimesheet;
 
	@And("Click On Create Timesheet Icon In Manager View")
	public void CreateTimesheetIcon() throws Exception {
		createTimesheet.CreateTimesheetIcon();
	}
 
	@And("Enter The Task Discription,Select The Category,Subcategory And Entering Hours To Create Current Week Timesheet {string}")
	public void EnterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
		createTimesheet.enterTaskDiscriptionCategorySubcategory(SheetName);
	}
 
	@And("Click On Save And Submit confirm The Timesheet")
	public void ClickOnSaveSubmitConfirm() {
		createTimesheet.saveSubmitConfirm();
	}
 
	@Then("Validate The TimeSheet Response")
	public void ValidateTimesheetResponse() throws Exception {
		createTimesheet.ValidateTimesheetResponse();
	}
	@Given("Select the Previous Date In Manager View From Calender Icon")
	public void SeletionOfPreviousDate() throws InterruptedException {
		createTimesheet.selectPastWeekDate();
	}
	@Given("Select the Future Date In Manager view From Calender Icon")
	public void SeletionOfFutureDate() throws InterruptedException {
		createTimesheet.selectfutureWeekDate();
	}
	@Given("User Can Able To Login Into The Manager View For Create Timesheet")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        createTimesheet    = new PM02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
	}
 
}