package com.EmployeeViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PE03_PendingTimesheetPage {
	WebDriver driver;

	public PE03_PendingTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;

	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle']")
	WebElement arrowIcontoExpandRecord;

	@FindBy(xpath = "(//*[@class=\"_2g8-gVz7LjvnNP21Y4gBFy\"])[1]")
	WebElement managerName;

	@FindBy(xpath = "(//*[@class=\"_2g8-gVz7LjvnNP21Y4gBFy\"])[2]")
	WebElement approverName;

	public void pendingApprovalIconClick() throws InterruptedException {
		pendingApprovalIcon.click();
		Logs.info("clicked on pending icon");
	}

	public void expandArrowtoVerify(String pending) throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		Thread.sleep(2000);
		String PendingText = driver.findElement(By.xpath("//*[@title='Pending']")).getText();
		Assert.assertEquals(PendingText, pending);
		Logs.info("SuccessFully done validation of pending Timesheet");
		Thread.sleep(2000);
	}

	public void managerName(String managername) {

		String managernametext = managerName.getText();
		System.out.println("manager name is : " + managernametext);
		Assert.assertEquals(managernametext, managername);
	}

	public void approverName(String approvername) {

		String approvernametext = approverName.getText();
		System.out.println("approver name is : " + approvernametext);
		Assert.assertEquals(approvernametext, approvername);
	}

}
