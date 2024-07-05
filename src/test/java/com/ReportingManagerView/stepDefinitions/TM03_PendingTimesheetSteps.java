package com.ReportingManagerView.stepDefinitions;
 
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM03_PendingTimesheetPage;
import com.TimeSheet.utils.BrowserManager;
import com.TimeSheet.utils.WebDriverManager;
 
public class TM03_PendingTimesheetSteps {
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM03_PendingTimesheetPage pendingTimesheet;

 
	@Given("click pending Timesheet page and Verify for manager view")
	public void verify_pending_timesheet_page() {
		pendingTimesheet.PendingIconClick();
	//	pendingTimesheet.ExpandArrowtoVerify();
	}
	@Given("user login for pending for Managerview for manager view")
	public void user_login_for_pending_for_managerview() {
		driver = WebDriverManager.getDriver();
		//driver = BrowserManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        pendingTimesheet  = new PM03_PendingTimesheetPage(driver);
		loginPage.doLogIn();
	}
}