package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA03_PendingTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC03_PendingTimeSheetSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA03_PendingTimeSheetPage pendingTimesheet;
 
	
	@Given("Login to Timesheet as admin for pending records")
	public void user_login_for_pending_for_managerview() {
		driver = WebDriverManager.getDriver();
		//driver = BrowserManager.getDriver();
        loginPage = new PA01_LoginPage(driver);
        pendingTimesheet  = new PA03_PendingTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	@When("Click on Pending Icon for Admin View")
	public void click_pending_timesheet_page_and_click_on_weekstart_date_for_admin_view() {
		pendingTimesheet.clickOnPendingTimesheetIcon();
		
	}
	
	@Then("Validate Pending records for Admin View")
	public void verify_the_pending_status() throws InterruptedException {
		pendingTimesheet.ExpandArrowtoVerify();
	}
	


}
