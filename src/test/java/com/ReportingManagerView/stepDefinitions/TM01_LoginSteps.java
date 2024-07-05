package com.ReportingManagerView.stepDefinitions;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.ReportingManagerViewTimeSheet.page.PM01_LoginPage;
import com.TimeSheet.utils.BrowserManager;
import com.TimeSheet.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TM01_LoginSteps {

	public WebDriver driver;
	PM01_LoginPage loginPage = new PM01_LoginPage(driver);
	public static Logger log;
	
	@Given("I am on the login page of the websites for manager view")
	public void i_am_on_the_login_page_of_the_website() {
		driver = WebDriverManager.getDriver();
		//driver = BrowserManager.getDriver();
        loginPage = new PM01_LoginPage(driver);
	}

	@And("Click on {string} options for manager view")
	public void click_on_option(String string) {
		
	}
		

	@And("Select the option to proceed to the unsafe URLs for manager view")
	public void select_the_option_to_proceed_to_the_unsafe_url() {
		
	}
	@Then("^Redirected to the login page and verify the title for manager view$")
	public void redirected_to_the_login_page_and_verify_title() {
		loginPage.doLogIn();
		 
	}
}
