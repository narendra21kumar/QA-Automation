package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA03_PendingTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TA02_PendingTimeSheetSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA03_PendingTimeSheetPage pendingTimesheet;
 

	@Then("click pending Timesheet page and click on WeekstartDate {string} for adminView")
	public void click_pending_timesheet_page_and_click_on_weekstart_date_for_admin_view(String weekStartDate) {
		pendingTimesheet.clickOnPendingTimesheetIcon();
		pendingTimesheet.ExpandArrowtoVerify(weekStartDate);
	}
	@Given("Admin login for pending for Managerview for adminView")
	public void user_login_for_pending_for_managerview() {
		driver = WebDriverManager.getDriver();
		//driver = BrowserManager.getDriver();
        loginPage = new PA01_LoginPage(driver);
        pendingTimesheet  = new PA03_PendingTimeSheetPage(driver);
		loginPage.doLogIn();
	}

}
