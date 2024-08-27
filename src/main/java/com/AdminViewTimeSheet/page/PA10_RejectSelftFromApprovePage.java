package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA10_RejectSelftFromApprovePage {
	WebDriver driver;

	public PA10_RejectSelftFromApprovePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

	@FindBy(xpath = "//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3']")
	WebElement enableToggle;

	@FindBy(xpath = "(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
	WebElement checkbox;

	@FindBy(xpath = "(//*[text()='Reject'])[1]")
	WebElement RejectButton;

	@FindBy(xpath = "//*[@class='_17CUqmCextOqfytuhqZlM']")
	WebElement RemarksTextArea;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmButton;

	public void clickonApprovedIcon() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("clicked on Approved icon");
	}

	public void enableToggle() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(enableToggle,10);
		Logs.info("clicked on enable Toggle icon");

	}

	public void bulkReject() {
		CommonUtils.waitFor(3);
		CommonUtils.JavaScriptExecutorClick(driver, checkbox);
		CommonUtils.waitFor(5);
		Logs.info("clicked on checkBox for bulk Reject");
	}

	public void rejectTimesheetByGivingRemarks(String Remarks) {
		CommonUtils.explicitlyWaitForElementandClick(RejectButton, 2);
		CommonUtils.sendKeysToElement(RemarksTextArea, Remarks);
		CommonUtils.explicitlyWaitForElementandClick(confirmButton, 2);
		Logs.info("SuccessFully Rejected the Timesheet");
	}

}
