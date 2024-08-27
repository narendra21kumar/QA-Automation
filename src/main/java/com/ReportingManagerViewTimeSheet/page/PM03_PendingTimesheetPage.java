package com.ReportingManagerViewTimeSheet.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM03_PendingTimesheetPage {

	public WebDriver driver;

	public PM03_PendingTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;
	
	//@FindBy(xpath="(//*[@class='_2OgfRLrLpBAlesjxdgSZ3_']//following::div[@class='_2g8-gVz7LjvnNP21Y4gBFy'])[1]")
	@FindBy(xpath="(//*[@class=\"_2g8-gVz7LjvnNP21Y4gBFy\"])[1]")
	WebElement managerName;

	@FindBy(xpath="(//*[@class=\"_2g8-gVz7LjvnNP21Y4gBFy\"])[2]")
	WebElement approverName;
	
	
	
	public void pendingIconClick() {
		Logs.initLogs(PM01_LoginPage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		CommonUtils.explicitlyWaitForElementandClick(pendingApprovalIcon, 10);
		Logs.info("Clicked on pending approval page icon");
	}

	public void managerName(String managername) {
		
		String managernametext=managerName.getText();
		System.out.println("manager name is : "+managernametext);
		Assert.assertEquals(managernametext, managername);
	}
	public void approverName(String approvername) {
		
		
		String approvernametext=approverName.getText();
		System.out.println("approver name is : "+approvernametext);
		Assert.assertEquals(approvernametext, approvername);
	}
	
	public void validateStatus(String status) {
		CommonUtils.waitFor(1);
		String PendingText = driver.findElement(By.xpath("//*[@title='Pending']")).getText();
		Assert.assertEquals(PendingText, status);
		Logs.info("Validated the submitted timesheet status as pending");
	}

}