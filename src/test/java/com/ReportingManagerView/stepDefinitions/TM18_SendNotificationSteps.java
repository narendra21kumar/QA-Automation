package com.ReportingManagerView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.ReportingManagerViewTimeSheet.page.PM18_SendNotificationPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TM18_SendNotificationSteps {
	
	public WebDriver driver;
	public PM01_LoginPage loginPage;
	public PM18_SendNotificationPage PM18_SendNotificationPage;
	
	@Given("Manager login into the timesheet view for employee not submitted timesheet")
	public void manager_login_into_the_timesheet_view_for_employee_not_submitted_timesheet() {
		Logs.initLogs(TM18_SendNotificationSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PM01_LoginPage(driver);
		PM18_SendNotificationPage = new PM18_SendNotificationPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on send notification page")
	public void click_on_send_notification_page() {
		PM18_SendNotificationPage.sendnotificationpage();
	}



	@And("Click on yes radio button for timesheet created")
	public void click_on_yes_radio_button_for_timesheet_created() {
		PM18_SendNotificationPage.timesheetcreatedradiobutton();
	}
	
	@When("Check the header part checkbox for send email notification")
	public void check_the_header_part_checkbox_for_send_email_notification() {
		PM18_SendNotificationPage.emailcheckBox();
	}

	@And("Click on send email button")
	public void click_on_send_email_button() {
		//PM18_SendNotificationPage.sendemailbutton();
	}

}
