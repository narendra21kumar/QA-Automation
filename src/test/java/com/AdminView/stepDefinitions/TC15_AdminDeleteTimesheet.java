package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA11_DeleteTimesheetRecords;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC15_AdminDeleteTimesheet {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA11_DeleteTimesheetRecords DeleteTimesheet;
	
	@Given("Login as Admin for Delete Admin Timesheet Record")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		DeleteTimesheet = new PA11_DeleteTimesheetRecords(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	@When("Click On Create Timesheet Page for Admin delete functionality")
	public void CreateTimesheetIcon() throws Exception {
		DeleteTimesheet.CreateTimesheetIcon();
	}

	@And("Select the Previous Date In Admin View for delete functionality")
	public void select_the_previous_date_in_admin_view_for_delete_action() throws InterruptedException {
		DeleteTimesheet.clickCalendor();
		DeleteTimesheet.selectAnyWeek(-1);
	}
	
	@And("Select the Current Date In Admin View for delete functionality")
	public void select_the_Current_date_in_admin_view_for_delete_action() throws InterruptedException {
		DeleteTimesheet.clickCalendor();
		DeleteTimesheet.selectAnyWeek(0);
	}
	
	@And("Select the Future Date In Admin View for delete functionality")
	public void select_the_Future_date_in_admin_view_for_delete_action() throws InterruptedException {
		DeleteTimesheet.clickCalendor();
		DeleteTimesheet.selectAnyWeek(1);
	}
	
	@And("Click On Edit Icon and Add A Row Icon for delete functionality")
	public void EnterTaskDiscriptionCategorySubcategory() throws Exception {
		DeleteTimesheet.EditIcon();
		CommonUtils.waitFor(4);
		DeleteTimesheet.addARow();
		CommonUtils.waitFor(4);
	}

	@And("Click On Delete Icons for Delete Admin created TimeSheet")
	public void ClickOnSaveSubmitConfirm() throws Exception {
		DeleteTimesheet.deleteTimesheet();
	}

	@Then("Validate Deleted record and verify {string} In Admin View")
	public void ValidateTimesheetResponse(String DeletionText) throws Exception {
		DeleteTimesheet.ValidateTimesheetResponse(DeletionText);
	}


	

	

}
