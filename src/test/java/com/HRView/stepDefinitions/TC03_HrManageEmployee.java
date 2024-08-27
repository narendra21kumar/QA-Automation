package com.HRView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.HRViewTimeSheet.page.H01_LoginPage;
import com.HRViewTimeSheet.page.H03_HrManageEmployeePage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC03_HrManageEmployee {
	private WebDriver driver;
	public H01_LoginPage loginPage;
	public H03_HrManageEmployeePage HrManageEmpPage;

	@Given("Login as Hr for Manage Emp Page")
	public void user_login_to_Hrview() {
		Logs.initLogs(TC03_HrManageEmployee.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new H01_LoginPage(driver);
		HrManageEmpPage = new H03_HrManageEmployeePage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on Manage Employee Page icon in Hr View")
	public void click_on_manage_employee_page_icon_in_admin_view() {
		HrManageEmpPage.clickManageEmpIcon();
	}

	@Then("Validate title of the page for Manage Employee in Hr view")
	public void verify_title_of_the_page_for_manage_employee() {
		HrManageEmpPage.printManageEmpTitle();
	}

}
