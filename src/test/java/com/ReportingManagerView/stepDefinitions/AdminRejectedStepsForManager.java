package com.ReportingManagerView.stepDefinitions;
 
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA06_RejectedTimeSheetPage;
import com.ReportingManagerViewTimeSheet.page.AdminRejectedTimeSheetPageForManager;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 
public class AdminRejectedStepsForManager {
 
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private AdminRejectedTimeSheetPageForManager rejectTimesheetPage;

	@Given("^Click on TimesheetManagementPage icon for Admin View for Rejected Page for manager view$")
	public void create_timesheet_for_manager_and_give_required_feild_to_create_timesheet() throws IOException {
		rejectTimesheetPage.TimeSheetSubmitted();
	}

	@When("^user Enter Start Month \"(.*)\" and Enter Start date \"(.*)\" for Rejection for manager view$")
	public void user_Enter_Start_Month_and_Enter_Start_date_is(String Startmonth, String Startdate) {
		rejectTimesheetPage.startCalendar();
		rejectTimesheetPage.selectStartDateandMonthforSubmitted(Startmonth, Startdate);
	}

	@When("^user Enter End Month \"(.*)\" and Enter End date \"(.*)\" for Rejection for manager view$")
	public void user_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		rejectTimesheetPage.endCalendar();
		rejectTimesheetPage.selectEndDateandMonthforSubmitted(EndMonth, EndDate);

	}

	@And("^Enter Emp Id \"(.*)\" for Reject and enter remarks as \"(.*)\" Rejected Timesheet Page for manager view$")
	public void enter_EmpId_for_Approve(String empid, String remarks) {
		rejectTimesheetPage.rejectTimesheet(empid, remarks);
	}

	@When("click on Rejected TimesheetIcon In AdminView for manager view")
	public void click_on_approved_timesheet_icon_in_admin_view() {
		rejectTimesheetPage.clickonrejectedIcon();
	}

	@Then("In Admin Reject Page Enter Start Month {string} and Enter Start date {string} is for manager view")
	public void in_admin_approve_page_enter_start_month_and_enter_start_date_is(String Startmonth, String Startdate) {
		rejectTimesheetPage.startCalendar();
		rejectTimesheetPage.selectStartDateandMonth(Startmonth, Startdate);
	}

	@Then("In Admin Reject Page Enter End Month {string} and Enter End date {string} is for manager view")
	public void in_admin_approve_page_enter_end_month_and_enter_end_date_is(String EndMonth, String EndDate) {
		rejectTimesheetPage.endCalendar();
		rejectTimesheetPage.selectEndDateandMonth(EndMonth, EndDate);
	}

	@Then("Verify the Rejected Status based on Employee code for manager view")
	public void verify_the_approved_status_based_on_employee_code() {
		rejectTimesheetPage.verifyRejectedEmployees();
	}

	@Given("User should login to Admin View of Timesheet and Navigate to Rejecetd Timesheet Page for manager view")
	public void user_login_to_managerview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		rejectTimesheetPage = new AdminRejectedTimeSheetPageForManager(driver);
		loginPage.doLogIn();
	}
}