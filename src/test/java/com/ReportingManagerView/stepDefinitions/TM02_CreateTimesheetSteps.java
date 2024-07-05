package com.ReportingManagerView.stepDefinitions;
 
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
 
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.EmployeeViewTimeSheet.page.PE02_CreateTimeSheetPage;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM02_CreateTimeSheetPage;
import com.TimeSheet.utils.WebDriverManager;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
 
public class TM02_CreateTimesheetSteps {
 
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM02_CreateTimeSheetPage createTimesheet;
 
	@Given("Create timesheet for Manager and give Required feild to create timesheet for manager view")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws Exception {
		createTimesheet.CreateTimesheet();
		createTimesheet.saveSubmitConform();
	}
	@Given("Create timesheet for Manager and give Required feild to create timesheet for rejection for manager view")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet_for_rejection() throws Exception {
		createTimesheet.CreateTimesheetForApproval();
		createTimesheet.saveSubmitConform();
	}
 
	@Given("Validate Response for manager view")
	public void validate_response() {
 
	}
	@Given("user login to Managerview for manager view")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
        createTimesheet    = new PM02_CreateTimeSheetPage(driver);
		loginPage.doLogIn();
	}
 
}