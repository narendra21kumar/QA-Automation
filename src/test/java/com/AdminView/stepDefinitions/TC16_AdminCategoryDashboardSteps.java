package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA12_AdminCategoryDashboardPage;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TC16_AdminCategoryDashboardSteps {
	private WebDriver driver;
	private PA01_LoginPage loginPage;
	private PA12_AdminCategoryDashboardPage adminCategoryPage;

	@Given("Login as Admin for Category Dashboard")
	public void user_login_to_adminview() {
		Logs.initLogs(TC16_AdminCategoryDashboardSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		adminCategoryPage = new PA12_AdminCategoryDashboardPage(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on Category Dashboard Page icon in Admin View")
	public void click_on_category_dashboard_page_icon_in_admin_view() {
		adminCategoryPage.clickCategoryIcon(); 
	}
	
	@And("Validate title of the page for Category Master")
	public void verify_title_of_the_page_for_category_master() {
		adminCategoryPage.printCategoryTitle();
	}
}
