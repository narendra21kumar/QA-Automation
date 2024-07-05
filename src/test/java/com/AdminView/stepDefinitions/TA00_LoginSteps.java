package com.AdminView.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
public class TA00_LoginSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;

	@Given("User on the login page for Admin View")
	public void i_am_on_the_login_page_of_the_website() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);

	}

	@Given("user should Click on {string} options for Admin View")
	public void click_on_option(String string) {

	}

	@Given("User should Select the option to proceed to the unsafe URLs for Admin View")
	public void select_the_option_to_proceed_to_the_unsafe_url() {

	}

	@Then("user Redirected to the login page and verify titles {string} for Admin View")
	public void redirected_to_the_login_page_and_verify_title(String searchTerm) {
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
//		String pageTitle = driver.getTitle();
//		System.out.println(pageTitle);
	//	Assert.assertTrue("Succeesfully login to Skill Matrix Dashboard", pageTitle.equalsIgnoreCase(searchTerm));
	}
	
	@Then("Verify User Name and Access of Timesheet for AdminView")
	public void verify_User_Name_and_Access_of_Timesheet() throws InterruptedException {
		loginPage.verifyAccessAccordingToLogin();
	}

	@And("the page title should start with {string} for AdminView")
	public void checkTitle(String titleOfPage) {
		loginPage.checkTitle(titleOfPage);
		
	}
}
