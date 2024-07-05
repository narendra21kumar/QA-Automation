package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE01_LoginSteps {

	private WebDriver driver;
	private PE01_LoginPage loginPage;

	@Given("I am on the login page of the website for employee view")
	public void i_am_on_the_login_page_of_the_website() {
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);

	}

	@Given("Click on {string} option for employee view")
	public void click_on_option(String string) {

	}

	@Given("Select the option to proceed to the unsafe URL for employee view")
	public void select_the_option_to_proceed_to_the_unsafe_url() {

	}

	@Then("^Redirected to the login page and verify employee for employee view$")
	public void redirected_to_the_login_page_and_verify_title() {
		loginPage.doLogIn();

//		String pageTitle = driver.getTitle();
//		//Assert.assertEquals(pageTitle, "Automation");
//		System.out.println("Name of the title is " +pageTitle);
	}

	@Then("Verify User Name and Access of Timesheet")
	public void verify_User_Name_and_Access_of_Timesheet() throws InterruptedException {
		loginPage.verifyAccessAccordingToLogin();
	}

	@And("the page title should start with {string}")
	public void checkTitle(String titleOfPage) {
		loginPage.checkTitle(titleOfPage);
	}

}
