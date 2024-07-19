package com.EmployeeViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

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

	public void pendingApprovalIconClick() throws InterruptedException {
		pendingApprovalIcon.click();
	}
	public void ExpandArrowtoVerify(String pending) throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		Thread.sleep(2000);
		String PendingText = driver.findElement(By.xpath("//*[@title='Pending']")).getText();
		Assert.assertEquals(PendingText,pending);
		Thread.sleep(2000);
	}

}
