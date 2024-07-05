package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.Admin_BulkRejection_Page;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA05_ApprovedTimeSheetPage;

import io.cucumber.java.en.Given;

public class AdminBulkRejection_steps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private Admin_BulkRejection_Page adminBulkRejection;
	@Given("Select the {int} and {int} for rejection")
	public void select_the_and_for_rejection(Integer start, Integer end) {
		adminBulkRejection.selectDate(start,end);
	}

	@Given("search by {string} and click on checkBox for rejection")
	public void search_by_and_click_on_check_box_for_rejection(String name) {
		adminBulkRejection.SearchByname(name);
	}

	@Given("Reject the timesheet by filling the Remarks as {string} In adminView")
	public void reject_the_timesheet_by_filling_the_remarks_as_in_admin_view(String Remarks) {
		adminBulkRejection.RejectTimesheetByGivingRemarks(Remarks);
	}
	
	@Given("Verify the validation {string} by Rejecting the timesheet by without filling the Remarks as  In adminView")
	public void verify_the_validation_by_rejecting_the_timesheet_by_without_filling_the_remarks_as_in_admin_view(String string) {
		adminBulkRejection.RejectTimesheetWithOutGivingRemarksAndalidation(string);
	}

	@Given("User Admin timesheet page for BulkRejection")
	public void user_admin_timesheet_page_for_bulk_rejection() {
		loginPage = new PA01_LoginPage(driver);
		adminBulkRejection = new Admin_BulkRejection_Page(driver);
		loginPage.doLogIn();
	}

}
