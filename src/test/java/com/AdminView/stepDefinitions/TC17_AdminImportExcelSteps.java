package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA14_ImportExcelPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC17_AdminImportExcelSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA14_ImportExcelPage adminimportExcelPage;

	@Given("Login as Admin for Import Excel Page")
	public void user_login_to_adminview() {
		Logs.initLogs(TC16_AdminCategoryDashboardSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminimportExcelPage = new PA14_ImportExcelPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@Given("^click on Import Excel Icon in Admin view$")
	public void click_on_import_excel_icon_in_admin_view() {
		adminimportExcelPage.importExcelIocn();
	}

	@Then("^Validate title of the page for Import Excel Page")
	public void print_the_name_of_the_page_in_the_console_of_import_excel_page() {
		adminimportExcelPage.printImportExcelPage();
	}

}
