package com.ReportingManagerViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM05_VerifyManagerApprovedTimesheetPage {
	WebDriver driver;

	public PM05_VerifyManagerApprovedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

	@FindBy(xpath = "//*[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement ShowselfTimesheetIcon;

	@FindBy(xpath = "(//*[@title='Approved'])[2]")
	WebElement approvedText;

	public void approvedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on approved page icon");
	}

	public void showSelfTimesheetToggle() {
		CommonUtils.JavaScriptExecutorClick(driver, ShowselfTimesheetIcon);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on showself timesheet icon");
	}

	public void expandApprovedArrow() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(approvedText, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on expand arrow for approved timesheet");
	}

	public void verifyStatus() {
		String ApprovedText = driver.findElement(By.xpath("(//*[@title='Approved'])[2]")).getText();
		Assert.assertEquals(ApprovedText, "Approved");
		Logs.info("Validated the approved timesheet status");
	}

}