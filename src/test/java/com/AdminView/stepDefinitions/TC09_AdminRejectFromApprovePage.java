package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA10_RejectSelftFromApprovePage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC09_AdminRejectFromApprovePage {
	
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	PA10_RejectSelftFromApprovePage rejectfromApprovePage;
	
	
	@Given("Login as Admin for Self Reject in Approved Page")
	public void login_to_admin_for_self_reject_timesheet() {
		Logs.initLogs(TC09_AdminRejectFromApprovePage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		rejectfromApprovePage = new PA10_RejectSelftFromApprovePage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
		
	}
	
	@When("Click on Approve Icon for Admin Self Reject in Approved Page")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		rejectfromApprovePage.clickonApprovedIcon();
	}
	
    @And("^Enable the Show Self Timesheet button for Admin Self Reject in Approved Page$")
    public void enable_ToggleIcon() {
    	rejectfromApprovePage.enableToggle();
    } 
    
	@And("^Click on checkbox for Admin Self Reject in Approved Page$")
	public void and_click_on_checkbox_for_bulk_approval_for_admin_view_bulk_approval() {
		rejectfromApprovePage.bulkReject();
	}
	
	@And("Reject the timesheet by providing Remarks as {string} In adminView in Approve page")
	public void reject_the_timesheet_by_filling_the_remarks_as_in_admin_view(String Remarks) {
		rejectfromApprovePage.rejectTimesheetByGivingRemarks(Remarks);
	}
	
	
}
