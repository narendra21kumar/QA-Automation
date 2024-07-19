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
		public WebDriver driver;
		private PE01_LoginPage loginPage;
		public PE02_CreateTimeSheetPage CreateTimeSheetPage;
		
		@Given("Login As Employee Role")
		public void Employeelogin() throws InterruptedException {
			driver = WebDriverManager.getDriver();
			loginPage = new PE01_LoginPage(driver);
			CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
			loginPage.doLogInAsEmp();
			loginPage.verifyAccessAccordingToLogin();
			loginPage.checkTitle("Automation");
		}
		@And("Click on Create TimeSheetPage")
		public void CreateTimesheetIcon() throws Exception {
			CreateTimeSheetPage.CreateTimesheetIcon();
		}
	
		@And("Enter the Task Description,Category & SubCategory and Hours Details {string}")
		public void EnterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
			CreateTimeSheetPage.enterTaskDiscriptionCategorySubcategory(SheetName);
		}

		@And("Click On Save, Submit & confirm button to Create the Timesheet")
		public void ClickOnSaveSubmitConfirm() {
			CreateTimeSheetPage.saveSubmitConfirm();
		}

		//============================================//
		@And("Select the current week date as an Employee")
		public void selectWeek() throws Exception {
			CreateTimeSheetPage.selectCurrentWeek();
		}
		@And("Select the Previous week Date from Calender Icon")
		public void SeletionOfPreviousDate() throws InterruptedException {
			CreateTimeSheetPage.selectPastWeekDate();
		}
		
		@And("Select the Future week Date from Calender Icon")
		public void SeletionOfFutureDate() throws InterruptedException {
			CreateTimeSheetPage.selectfutureWeekDate();
		}
		//============================================//
		@Then("Validate The TimeSheet Response As {string}")
		public void ValidateTimesheetResponse(String string) throws Exception {
			CreateTimeSheetPage.ValidateTimesheetResponse(string);
		}
}
