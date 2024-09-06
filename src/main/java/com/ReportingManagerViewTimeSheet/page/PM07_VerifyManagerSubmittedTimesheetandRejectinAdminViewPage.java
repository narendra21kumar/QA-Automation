package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM07_VerifyManagerSubmittedTimesheetandRejectinAdminViewPage {
	public WebDriver driver;

	public PM07_VerifyManagerSubmittedTimesheetandRejectinAdminViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;

	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;

	@FindBy(xpath = "//*[@rows='4']")
	WebElement remarkstext;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	public void timesheetSubmittedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(timesheetmanagementicon, 10);
		Logs.info("Clicked on timesheet management page icon");
	}

	public void selectPastWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, -7);
		Date pastDate = cal.getTime();
		int date = pastDate.getDate();
		WebElement availableDate=CommonUtils.convertIntTOWebElement(driver, date);
		//System.out.println(date);
       // boolean availableDate = true;
		if(availableDate.isSelected()) {
			CommonUtils.CalenderSelectWithDate(driver, date);	
			Thread.sleep(3000);
			Logs.info("Selected the past week date from calendar");
			System.out.println("if ");
		}
		else if(PreviousMonthArrowIcon.isEnabled()){
			CommonUtils.Click(PreviousMonthArrowIcon);
			Thread.sleep(3000);
			Logs.info("Clicked on previous month arrow and selected the past week date from calendar");
			CommonUtils.CalenderSelectWithDate(driver, date);
			System.out.println("past week"+pastDate);
			Thread.sleep(3000);
		}
	}

	public void submittedStatus(String empid, String status) {
		WebElement statuselement = driver.findElement(By.xpath("//*[text()='" + empid + "']//following::td[4]"));
		String statussubmitted = statuselement.getText();
		Assert.assertEquals(statussubmitted, status);
		Logs.info("Validated the submitted timesheet status");
	}

	public void rejectIcon(String empid, String remarks) {
		WebElement reject = driver.findElement(By.xpath(
				"//*[@title='" + empid + "']/following::td[8]/div[1]/button[2][@aria-label='Reject Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(reject, 10);
		Logs.info("Clicked on reject icon");
		CommonUtils.sendKeysToElement(remarkstext, remarks);
		Logs.info("Entered the remarks in text field");
		CommonUtils.waitFor(2);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		CommonUtils.waitFor(2);
		Logs.info("Clicked on confirm  button");
	}

	public void validateToastMessage(String toastmessagge) {
		WebElement toastmsg = driver.findElement(By.xpath("//*[text()='Timesheet rejected successfully!']"));
		String toasttext = toastmsg.getText();
		Assert.assertEquals(toasttext, toastmessagge);
		CommonUtils.waitFor(4);
		Logs.info("Validated the response as timesheet rejected successfully");
	}
}
