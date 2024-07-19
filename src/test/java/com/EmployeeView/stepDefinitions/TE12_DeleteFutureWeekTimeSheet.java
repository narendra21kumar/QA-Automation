package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE09_DeleteFutureWeekTimesheetPage;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.*;

public class TE12_DeleteFutureWeekTimeSheet {
	private WebDriver driver;
	private PE01_LoginPage loginPage;
	public PE09_DeleteFutureWeekTimesheetPage DeleteTimeSheetPage;

	@Given("Log in As a Employee Role")
	public void user_login_timesheet_page() throws InterruptedException {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		DeleteTimeSheetPage = new PE09_DeleteFutureWeekTimesheetPage(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
	@And("Click On Create Timesheet Page")
	public void createTimesheetPage() throws Exception {
		DeleteTimeSheetPage.CreateTimesheetIcon();
	}
	@And("Select the Future Week from Calender")
	public void selectCalender() throws Exception {
		DeleteTimeSheetPage.selectfutureWeekDate();
	}
	@And("Select the Current Week from Calender")
	public void selectCalenderForCurrent() throws Exception {
		DeleteTimeSheetPage.selectCurrentWeek();
	}
	@And("Select the Past Week from Calender")
	public void selectCalenderForPast() throws Exception {
		DeleteTimeSheetPage.selectPastWeekDate();
	}
	@And("Click On Edit Icon And Add A Row Icon")
	public void clickOnEditIcon() throws Exception {
		DeleteTimeSheetPage.EditIcon();
		//DeleteTimeSheetPage.addARow();
	}
	
	@And("Click On Delete Icons for Delete TimeSheet For Future Week")
	public void ClickDeleteIcon() throws Exception {
		DeleteTimeSheetPage.deleteTimesheet();
	}

	@Then("Validation of Deletion of TimeSheet Response As {string}")
	public void Validating(String draftText) throws Exception {
		DeleteTimeSheetPage.ValidateTimesheetResponse(draftText);
	}
	

	
}
