package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA14_AdminManageDeletePage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC18_AdminManageDeleteEmp {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA14_AdminManageDeletePage adminDeleteEmpPage;

	@Given("Login as Admin for Manage Delete Employee")
	public void user_login_to_adminview() {
		Logs.initLogs(TC18_AdminManageDeleteEmp.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminDeleteEmpPage = new PA14_AdminManageDeletePage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on  Manage Delete Employee icon in Admin View")
	public void click_on_manage_delete_page_icon_in_admin_view() {
		adminDeleteEmpPage.clickManageDeleteIcon();
	}

	@And("Validate title of the page for  Manage Delete Employee")
	public void verify_title_of_the_page_for_manage_delete_employee() {
		adminDeleteEmpPage.printManageDeleteTitle();
	}

}
