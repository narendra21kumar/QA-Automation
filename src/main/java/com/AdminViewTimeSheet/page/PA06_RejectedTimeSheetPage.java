package com.AdminViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA06_RejectedTimeSheetPage {
	WebDriver driver;
	String empid;

	public PA06_RejectedTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@title=\"Submitted\"]")
	WebElement submitted;

	@FindBy(xpath = "//*[@class='MuiSwitch-root MuiSwitch-sizeMedium css-ecvcn9']")
	WebElement showselftoggle;

	@FindBy(xpath = "//button[text()='Reject']")
	WebElement rejected;

	@FindBy(xpath = "//*[contains(@class,'_17CUqmCextOqfytuhqZlM') and @rows='4']")
	WebElement remarks;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Rejected']")
	WebElement RejectedIcon;

	@FindBy(xpath = "(//*[@title='188']/ancestor::td//preceding-sibling::td)[1]")
	WebElement ExpandArrowIcon;

	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()='Approve']")
	WebElement approvebtn;

	@FindBy(xpath = "(//*[text()='Reject'])[1]")
	WebElement RejectButton;

	@FindBy(xpath = "//*[@class='_17CUqmCextOqfytuhqZlM']")
	WebElement RemarksTextArea;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmButton;

	public void timesheetmanagement() {
		submitted.click();
		Logs.info("Clicked on Timesheet Management page");
	}

	public void selfTogggle() {
		showselftoggle.click();
		Logs.info("Clicked on self toggle icon");
	}

	public void checkbox(String WeekStartDate) {
		driver.findElement(By.xpath("//*[text()='" + WeekStartDate
				+ "']//ancestor::td//preceding-sibling::td[6]/span/input[@id='checkbox_411']")).click();
		Logs.info("selected the Record to self Reject the Timesheet");
	}

	public void rejected(String Remarks) {
		rejected.click();
		Logs.info("clicked on Reject Icon");
		CommonUtils.sendKeysToElement(remarks, Remarks);
		Logs.info("Entered Remarks");
		CommonUtils.explicitlyWaitForElementandClick(confirm, 3);
		Logs.info("Rejected Successfully");
	}

	public void rejectTimesheet(String empid) {
		WebElement element = driver.findElement(By.xpath(
				"//*[@title='" + empid + "']/following::td[8]/div[1]/button[2][@aria-label='Reject Timesheet']"));
		Logs.info("selected the Record to Reject the Timesheet");
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		CommonUtils.waitFor(2);
		CommonUtils.sendKeysToElement(remarks, "Test");
		Logs.info("Entered Remarks");
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		CommonUtils.waitFor(2);
		Logs.info("Rejected Successfully");
	}

	public void empRejectedTimesheetandVerify() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(RejectedIcon, 10);
		Logs.info("Clicked on Rejected Page");
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(showselftoggle, 10);
		Logs.info("Clicked on show Self Toggle");
		CommonUtils.waitFor(2);//
		CommonUtils.explicitlyWaitForElementandClick(ExpandArrowIcon, 10);
		CommonUtils.waitFor(2);
		Logs.info("verified and Expanded the arrow");
	}

	public void bulkReject() {
		CommonUtils.explicitlyWaitForElementandClick(checkbox, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on CheckBox in Header for Bulk Reject");
	}

	public void rejectTimesheetByGivingRemarks(String Remarks) {
		CommonUtils.explicitlyWaitForElementandClick(RejectButton, 2);
		Logs.info("clicked on RejectedIcon To Reject the Timesheet");
		CommonUtils.sendKeysToElement(RemarksTextArea, Remarks);
		Logs.info("Entered Remarks");
		CommonUtils.explicitlyWaitForElementandClick(confirmButton, 2);
		Logs.info("Rejected Successfully");
	}

}
