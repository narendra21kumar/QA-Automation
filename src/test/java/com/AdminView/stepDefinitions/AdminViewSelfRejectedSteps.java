package com.AdminView.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.AdminSelfRejectedTimeSheetPage;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA06_RejectedTimeSheetPage;
import com.AdminViewTimeSheet.page.PA08_ApproveSelfTimesheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminViewSelfRejectedSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	AdminSelfRejectedTimeSheetPage adminselfrejectedtimesheetpage;
	
	@Given("Login as Admin for Self Reject Timesheet")
	public void login_to_admin_for_self_reject_timesheet() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminselfrejectedtimesheetpage = new AdminSelfRejectedTimeSheetPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}
	
 
	@When("Click on Timesheet Management Page icon for self Reject Timesheet")
	public void user_click_on_timesheet_management_page_icon() {
		adminselfrejectedtimesheetpage.timesheetmanagement();
	}
 
	@And("Enable the Show Self Timesheet toggle button")
	public void enabel_the_showself_toggle_timesheet() {
		CommonUtils.waitFor(3);
		adminselfrejectedtimesheetpage.selftogggle();
		CommonUtils.waitFor(3);
	}
	
	@And("Reject Self Timesheet record for given employee id: {string}")
	 public void click_on_reject_for_selected_employee_by_providing_remarks(String empid) {
		adminselfrejectedtimesheetpage.rejectTimesheet(empid);
		}
	
 
	@And("Validate the rejected record")
	public void navigate_to_reject_timesheet_page_and_verify_remarks() {
		adminselfrejectedtimesheetpage.EmpRejectedTimesheetandVerify();
	}
	
//	
//	@Then("Click on check box based on the weekStart Month {string}")
//	public void click_on_check_box_based_on_the_week_start_month(String WeekStartDate) {
//		adminselfrejectedtimesheetpage.checkbox(WeekStartDate);
//	}
// 
//	
//	@Then("User click on Reject button and add the {string}")
//	public void user_click_on_reject_button_and_add_the(String Remarks) {
//		adminselfrejectedtimesheetpage.rejected(Remarks);
//	}
// 

}
