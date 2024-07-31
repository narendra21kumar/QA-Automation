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

public class PM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewPage {
	public WebDriver driver;

	public PM04_VerifyManagerSubmittedTimesheetandApproveinAdminViewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarselectweek;

	@FindBy(xpath = "//*[text()='188']/ancestor::td//preceding-sibling::td/button")
	WebElement arrowicontoexpand;

	@FindBy(xpath = "//button[text()='Approve']")
	WebElement approvebtn;

	public void timesheetSubmittedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(timesheetmanagementicon, 10);
		Logs.info("Clicked on timesheet management page icon");
	}

	public void selectCurrentWeek() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		System.out.println(currentDate);
		Logs.info("Selected the current week date from calendar");
	}

	public void submittedStatus(String empid, String status) {
		WebElement statuselement = driver.findElement(By.xpath("//*[text()='" + empid + "']//following::td[4]"));
		String statussubmitted = statuselement.getText();
		Assert.assertEquals(statussubmitted, status);
		Logs.info("Validated the submitted timesheet status");
	}

	public void approveIcon(String empid) {
		WebElement approve = driver.findElement(By.xpath("//*[text()='" + empid + "']/following::td[8]/div/button[1]"));
		CommonUtils.explicitlyWaitForElementandClick(approve, 10);
		Logs.info("Clicked on approve icon");
	}

	public void validateToastMessage(String toastmessagge) {
		try {
			WebElement toastmsg = driver.findElement(By.xpath("//*[text()='Timesheet approved successfully!']"));
			String toasttext = toastmsg.getText();
			Assert.assertEquals(toasttext, toastmessagge);
			CommonUtils.waitFor(4);
			Logs.info("Validated the response as timesheet approved successfully");
		} catch (Exception e) {
			Logs.warn(e.getMessage());
			e.printStackTrace();
		}
	}
}