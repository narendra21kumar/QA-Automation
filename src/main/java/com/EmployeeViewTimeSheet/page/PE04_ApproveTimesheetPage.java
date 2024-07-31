package com.EmployeeViewTimeSheet.page;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PE04_ApproveTimesheetPage {
	WebDriver driver;

	public PE04_ApproveTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

	@FindBy(xpath = "(//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle'])[1]")
	WebElement ExpandArrowIcon;
	
	
	public void clickOnApprovedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		CommonUtils.waitFor(2);
		Logs.info("clicked on Approved page");
	}
	
	public void expandArrowForVerify(String approvedText) {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(ExpandArrowIcon, 10);
		String ApprovedText = driver.findElement(By.xpath("(//*[@title='"+approvedText+"'])[2]")).getText();
		Assert.assertEquals(ApprovedText, "Approved");
		String ApprovedOn = driver.findElement(By.xpath("(//*[text()='Approved On'])[1]")).getText();
		Assert.assertEquals(ApprovedOn, "Approved On");
		Logs.info("sucessFully done the validation of approved Timesheet");
		
	}


}
