package com.HRView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.HRViewTimeSheet.page.H01_LoginPage;
import com.HRViewTimeSheet.page.H02_AssignManagerApprover;
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC02_HrAssignManagerSteps {
	public H01_LoginPage loginPage;
	public WebDriver driver;
	public H02_AssignManagerApprover assignMangerPage;

	@Given("Login to Timesheet for Assign Manager for Hrview")
	public void user_login_to_Hrview() {
		Logs.initLogs(TC02_HrAssignManagerSteps.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		driver = WebDriverManager.getDriver();
		loginPage = new H01_LoginPage(driver);
		assignMangerPage = new H02_AssignManagerApprover(driver);
		loginPage.doLogIn();
		loginPage.verifyAccessAccordingToLogin();
		CommonUtils.printNameOfPages(driver);
	}

	@When("Click on Assign Manager Icon in Hr View")
	public void click_on_assignManager_Icon() {
		assignMangerPage.clickAssignManagerIcon();
	}

	@And("^Select Client from Client dropdown for Assign Manager Page in Hr View \"(.*)\"$")
	public void select_client_from_client_dropdown_for_assign_manager_page_for_admin_view(String nameOfClient) {
		assignMangerPage.selectClient(nameOfClient);
	}

	@And("^Select Team from Team dropdown for Assign Manager Page in Hr View \"(.*)\"$")
	public void select_team_from_team_dropdown_for_assign_manager_page_for_admin_view(String nameOfTeam)
			throws InterruptedException {
		assignMangerPage.selectTeam(nameOfTeam);
	}

	@Then("Validate title of the page for AssignManager in Hr view")
	public void verify_title_of_the_page_for_assign_manager() {
		assignMangerPage.printAssignManagerTitle();
	}

//	@And("Fill the Assign Details for AssignManager of Admin View")
//	public void Fill_the_Assign_Details_for_AssignManager_of_Admin_View() throws InterruptedException {
//		assignMangerPage.selectValuesFromManager();
//	}
//	
//	@And("^Click on save button to save assignManager of Admin View$")
//	public void click_on_save_button_to_save_assignmanager_of_admin_view() {
//		assignMangerPage.saveRecord();
//	}

}
