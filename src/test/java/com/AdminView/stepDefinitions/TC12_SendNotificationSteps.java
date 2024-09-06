package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA13_SendNotificationPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC12_SendNotificationSteps {
	public WebDriver driver;
	public PA01_LoginPage loginPage;
	public PA13_SendNotificationPage SendNotificationSteps;

	@Given("Login as Admin for send Notification page")
	public void Login_as_Admin_for_send_Notification_page() {
		Logs.initLogs(TC12_SendNotificationSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		SendNotificationSteps = new PA13_SendNotificationPage(driver);
		loginPage.doLogIn();
	}

	@When("Click on Send notification page for Admin view")
	public void click_on_send_notification_page() {
		SendNotificationSteps.sendnotificationpage();
	}

	@And("Click on yes button for timesheet created for Admin view")
	public void click_on_yes_radio_button_for_timesheet_created() {
		SendNotificationSteps.timesheetcreatedradiobutton();
	}

	@And("Click on send email button for Admin view")
	public void click_on_send_email_button() {
		SendNotificationSteps.sendemailbutton();
	}
}
