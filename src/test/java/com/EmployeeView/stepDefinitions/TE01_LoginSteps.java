package com.EmployeeView.stepDefinitions;

import org.openqa.selenium.WebDriver;
import com.EmployeeViewTimeSheet.page.PE01_LoginPage;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TE01_LoginSteps {

	private WebDriver driver;
	private PE01_LoginPage loginPage;

	@Given("Enter url and Click on Continue to Microsoft Account")
	public void i_am_on_the_login_page_of_the_website() throws InterruptedException {
		Logs.initLogs(TE01_LoginSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PE01_LoginPage(driver);
		loginPage.doLogInAsEmp();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");

	}

	@And("Enter the UserName,Password and click on SignIn button")
	public void redirected_to_the_login_page_and_verify_title() {

	}

	@And("Logged in Successfully as an Employee")
	public void verify_User_Name_and_Access_of_Timesheet() throws InterruptedException {
		loginPage.verifyAccessAccordingToLogin();
	}

	@Then("Validate the page title of Employee View as {string}")
	public void checkTitle(String titleOfPage) {
		loginPage.checkTitle(titleOfPage);
		Logs.endTestCase(this.getClass().getSimpleName());
	}

}
