package com.ReportingManagerView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM12_BulkRejectedTimesheetPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class TM12_BulkRejectedTimesheetSteps {
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM12_BulkRejectedTimesheetPage bulkReject;
 
	@Given("User login into the manager view for bulk rejected timesheets in timesheet management page")
	public void user_login_into_the_manager_view_for_bulk_rejected_timesheets_in_timesheet_management_page() {
		Logs.initLogs(TM12_BulkRejectedTimesheetSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        bulkReject    = new PM12_BulkRejectedTimesheetPage(driver);
		loginPage.doLogIn();
	}
	
	@When("Click on submitted icon")
	public void click_on_submitted_icon() {
		bulkReject.timesheetSubmittedIcon();
	}

	@And("Check header part checkbox")
	public void check_header_part_checkbox() {
		bulkReject.checkBox();
	}

	@And("Click on reject button and enter the {string} in remarks text field click on confirm button")
	public void click_on_reject_button_and_enter_the_in_remarks_text_field_click_on_confirm_button(String remarks) {
		bulkReject.rejectectButton(remarks);
	}
	
	@Then("Validate the bulk rejected timesheet response as {string} and {string}")
	public void validate_the_bulk_rejected_timesheet_response_as_and(String toastmessagge, String norecordmessage) {
		bulkReject.validateRejectedToastMessage(toastmessagge, norecordmessage);
	}
	
	
	

}