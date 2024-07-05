package com.ReportingManagerView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;


import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM08_BulkRejection;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
 
public class TM05_BulkRejectionSteps {
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM08_BulkRejection BulkRejection;
 
	@Given("Select the {int} and {int} for manager view")
public void select_the_date(int start,int end) {
	BulkRejection.selectDate(start,end);
}
 
	@Given("search by {string} and click on checkBox for manager view")
public void search_by_name_and_click_on_check_box(String name) {
	BulkRejection.SearchByname(name);
}
 
	@Given("Reject the timesheet by filling the Remarks as {string} for manager view")
public void reject_the_timesheet_by_filling_the_remarks(String Remarks) {
	BulkRejection.RejectTimesheetByGivingRemarks(Remarks);
}
 
 
@Given("User login timesheet page for BulkRejection for manager view")
public void user_login_timesheet_page_for_bulk_rejection() {
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        BulkRejection    = new PM08_BulkRejection(driver);
		loginPage.doLogIn();
	}
}