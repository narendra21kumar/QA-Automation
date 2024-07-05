package com.ReportingManagerView.stepDefinitions;
 
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
 
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM03_PendingTimesheetPage;
import com.ReportingManagerViewTimeSheet.page.PM04_ApprovedTimesheetPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.WebDriverManager;
 
public class TM06_ApprovedTimesheetSteps {
	WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM04_ApprovedTimesheetPage ApprovedTimesheet;
 
	@Given("Click on approved icon and enable self icon for manager view")
	public void verify_approved_timesheet_page() {
		ApprovedTimesheet.ApprovedIcon();
	}
 
	@Then("verify Approved Timesheet page for manager view")
	public void approvedIconClick() {
		 ApprovedTimesheet.ApprovedTimesheetExpand("04 Jun 2024");
	}
 
	@Then("user login for Approved for Managerview for manager view")
	public void user_login_for_pending_for_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		ApprovedTimesheet = new PM04_ApprovedTimesheetPage(driver);
		loginPage.doLogIn();
	}
}