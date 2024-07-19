package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA13_AdminManageEmployeePage;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC17_AdminManageEmployee {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA13_AdminManageEmployeePage adminManageEmpPage;

	@Given("Login as Admin for Manage Emp Page")
	public void user_login_to_adminview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminManageEmpPage = new PA13_AdminManageEmployeePage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		loginPage.checkTitle("Automation");
	}

	@When("Click on Manage Employee Page icon in Admin View")
	public void click_on_manage_employee_page_icon_in_admin_view() {
		adminManageEmpPage.clickManageEmpIcon();
	}

	@Then("Validate title of the page for Manage Employee")
	public void verify_title_of_the_page_for_manage_employee() {
		adminManageEmpPage.printManageEmpTitle();
	}

}
