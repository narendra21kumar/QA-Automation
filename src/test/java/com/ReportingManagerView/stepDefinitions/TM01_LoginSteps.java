package com.ReportingManagerView.stepDefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TM01_LoginSteps {

	public WebDriver driver;
	public PM01_LoginPage PM1_LoginPage = new PM01_LoginPage(driver);
	public static Logger log;
	
	@Given("User on the login page and click on continue with microsoft")
	public void user_on_the_login_page_and_click_on_continue_with_microsoft() {
		driver = WebDriverManager.getDriver();
		PM1_LoginPage = new PM01_LoginPage(driver);
	}
	@When("User click on advanced button")
	public void user_click_on_advanced_button() {
		//PM01_LoginPage.clickAdvance();
	}
	@And("User click on proceed link")
	public void user_click_on_proceed_link() {
		//PM01_LoginPage.clickUnsafeURL();
	}
	@And("User enter the username in the username Field and click on next button")
	public void user_enter_the_username_in_the_username_field_and_click_on_next_button() {
		//PM1_LoginPage.getUsername();
	}
	@And("User enter the password in the password Field and click on sign in button")
	public void user_enter_the_password_in_the_password_field_and_click_on_sign_in_button() {
		//PM1_LoginPage.getPassword();
	}
	@And("User click on yes button")
	public void user_click_on_yes_button() {
		//PM1_LoginPage.staySigned();
	}
	@Then("Validate the title {string} of the timesheet management page")
	public void validate_the_title_of_the_timesheet_management_page(String title) {
		PM1_LoginPage.doLogIn();
		PM1_LoginPage.validateTitle(title);
	}
}
