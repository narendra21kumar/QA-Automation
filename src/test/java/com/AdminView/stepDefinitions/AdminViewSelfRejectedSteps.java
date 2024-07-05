package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.AdminSelfRejectedTimeSheetPage;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA06_RejectedTimeSheetPage;
import com.AdminViewTimeSheet.page.PA08_ApproveSelfTimesheetPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminViewSelfRejectedSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	AdminSelfRejectedTimeSheetPage adminselfrejectedtimesheetpage;
	
 
	@Given("User click on TimesheetManagementPage icon")
	public void user_click_on_timesheet_management_page_icon() {
		adminselfrejectedtimesheetpage.timesheetmanagement();
	}
 
	@When("Enabel the showself toggle timesheet")
	public void enabel_the_showself_toggle_timesheet() {
		adminselfrejectedtimesheetpage.selftogggle();
	}
 
	@When("Click on check box based on the weekStart Month {string}")
	public void click_on_check_box_based_on_the_week_start_month(String WeekStartDate) {
		adminselfrejectedtimesheetpage.checkbox(WeekStartDate);
	}
 
	@When("User click on Reject button and add the {string}")
	public void user_click_on_reject_button_and_add_the(String Remarks) {
		adminselfrejectedtimesheetpage.rejected(Remarks);
	}
 
	@Given("User should be able to login Admin View of Timesheet and reject the self created timesheet")
	public void user_should_be_able_to_login_admin_view_of_timesheet_and_reject_the_self_created_timesheet() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminselfrejectedtimesheetpage = new AdminSelfRejectedTimeSheetPage(driver);
		loginPage.doLogIn();
	}
}
