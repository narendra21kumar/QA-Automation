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

public class TE08_EditTimeSheetSteps {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE02_CreateTimeSheetPage CreateTimeSheetPage;

	@Given("Log In as Employee Role")
	public void user_login_timesheet_page() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		CreateTimeSheetPage = new PE02_CreateTimeSheetPage(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	@When("Click on Create TimeSheet Icon")
	public void createTimesheetIcon() throws Exception {
		CreateTimeSheetPage.CreateTimesheetIcon();
	
	}
	@When("Select the Week for draft Timesheet")
	public void weekSelection() throws Exception {
		CreateTimeSheetPage.selectPastWeekDate();
		
	}
	@Then("Click on edit icon")
	public void select_the_edit_icon() throws Exception {
		CreateTimeSheetPage.editIcon();
	}

	@And("Edit the TimeSheet Details and Submit {string}")
	public void enter_the_edit_task_description_and_hours(String sheet) throws Exception {
		CommonUtils.edittaskDesccategoryandEnteringHours(driver,sheet);
		CreateTimeSheetPage.saveAll();
		}
	

		@And("Validate The TimeSheet Response as {string}")
		public void Validating(String SuccessText) throws Exception {
			CreateTimeSheetPage.ValidateTimesheetResponse(SuccessText);
	}


}
