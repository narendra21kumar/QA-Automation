package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM08_VerifyManagerRejectedTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

public class TM08_VerifyManagerRejectedTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM08_VerifyManagerRejectedTimesheetPage rejectedTimesheet;

	@Given("User login into the manager view for verifying the rejected timesheet")
	public void user_login_into_the_manager_view_for_verifying_the_rejected_timesheet() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		rejectedTimesheet = new PM08_VerifyManagerRejectedTimesheetPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on rejected icon rejected timesheet page")
	public void click_on_rejected_icon_rejected_timesheet_page() {
		rejectedTimesheet.rejectIcon();
	}

	@And("Click on manager show self timesheet toggle on rejected timesheet page")
	public void click_on_manager_show_self_timesheet_toggle_on_rejected_timesheet_page() {
		rejectedTimesheet.showSelfTimesheetToggle();
	}

	@And("Click on expand arrow")
	public void click_on_expand_arrow() {
		rejectedTimesheet.expandArrow();
	}

	@Then("Validate the rejected timesheet status")
	public void validate_the_rejected_timesheet_status() {
		rejectedTimesheet.verifyStatus();
	}

}