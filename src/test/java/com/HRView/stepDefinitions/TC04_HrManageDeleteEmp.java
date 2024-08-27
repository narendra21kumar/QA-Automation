package com.HRView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.HRViewTimeSheet.page.H01_LoginPage;
import com.HRViewTimeSheet.page.H04_HrManageDeletePage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC04_HrManageDeleteEmp {
	public WebDriver driver;
	public H01_LoginPage loginPage;
	public H04_HrManageDeletePage HrDeleteEmpPage;

	@Given("Login as Hr for Manage Delete Employee")
	public void user_login_to_adminview() {
		Logs.initLogs(TC04_HrManageDeleteEmp.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new H01_LoginPage(driver);
		HrDeleteEmpPage = new H04_HrManageDeletePage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on  Manage Delete Employee icon in Hr View")
	public void click_on_manage_delete_page_icon_in_admin_view() {
		HrDeleteEmpPage.clickManageDeleteIcon();
	}

	@And("Validate title of the page for  Manage Delete Employee in Hr view")
	public void verify_title_of_the_page_for_manage_delete_employee() {
		HrDeleteEmpPage.printManageDeleteTitle();
	}

}
