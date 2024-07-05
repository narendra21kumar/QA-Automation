package com.AdminView.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.AdminViewTimeSheet.page.PA01_LoginPage;
import com.AdminViewTimeSheet.page.PA04_CreateTimeSheetPage;
import com.AdminViewTimeSheet.page.PA09_AdminReportsPage;
import com.AdminViewTimeSheet.page.PA09_AssignManagerApprover;
import com.TimeSheet.utils.WebDriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TC08_AdminAssignManagerSteps {
	public PA01_LoginPage loginPage;
	public WebDriver driver;
	public PA04_CreateTimeSheetPage createTimesheetPage;
	public PA09_AssignManagerApprover assignMangerPage;
	
	@Given("User Should Log in to Timesheet Admin View for Assign Manager Page")
	public void user_login_to_adminview() {
		driver = WebDriverManager.getDriver();
		loginPage = new PA01_LoginPage(driver);
		assignMangerPage = new PA09_AssignManagerApprover(driver);
		loginPage.doLogIn();
	}
	
	@Then("click on Assign Manager Icon")
	public void click_on_assignManager_Icon() {
		assignMangerPage.clickAssignManagerIcon();	
	}
	
	@And("^Select Client from Client dropdown for Assign Manager Page for Admin View \"(.*)\"$")
	public void select_client_from_client_dropdown_for_assign_manager_page_for_admin_view(String nameOfClient) {
		assignMangerPage.selectClient(nameOfClient);
	}


	@And("^Select Team from Team dropdown for Assign Manager Page for Admin View \"(.*)\"$")
	public void select_team_from_team_dropdown_for_assign_manager_page_for_admin_view(String nameOfTeam) throws InterruptedException {
		assignMangerPage.selectTeam(nameOfTeam);
     }

	
	@And("Fill the Assign Details for AssignManager of Admin View")
	public void Fill_the_Assign_Details_for_AssignManager_of_Admin_View() throws InterruptedException {
		assignMangerPage.selectValuesFromManager();
	}
	
	@And("^Click on save button to save assignManager of Admin View$")
	public void click_on_save_button_to_save_assignmanager_of_admin_view() {
		assignMangerPage.saveRecord();
	}

}
