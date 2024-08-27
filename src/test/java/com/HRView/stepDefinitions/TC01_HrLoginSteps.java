package com.HRView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.HRViewTimeSheet.page.H01_LoginPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_HrLoginSteps {
	private WebDriver driver;
	private H01_LoginPage loginPage;

	@Given("Login to Timesheet with Hr Credentials")
	public void i_am_on_the_login_page_of_the_website() {
		driver = WebDriverManager.getDriver();
		// driver = BrowserManager.getDriver();
		loginPage = new H01_LoginPage(driver);

	}

	@When("Click on {string} options for Hr View")
	public void click_on_option(String string) {

	}

	@And("Select the option to proceed to the unsafe URLs for Hr View")
	public void select_the_option_to_proceed_to_the_unsafe_url() {

	}

	@And("Verify User Name and Access of Timesheet for HrView")
	public void verify_User_Name_and_Access_of_Timesheet() throws InterruptedException {
		loginPage.verifyAccessAccordingToLogin();
	}

	@And("the page title should start with {string} for HrView")
	public void checkTitle(String titleOfPage) {
		loginPage.checkTitle(titleOfPage);

	}

	@Then("Hr Logged in Successfully")
	public void redirected_to_the_login_page_and_verify_title() {
		Logs.initLogs(TC01_HrLoginSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}
}
