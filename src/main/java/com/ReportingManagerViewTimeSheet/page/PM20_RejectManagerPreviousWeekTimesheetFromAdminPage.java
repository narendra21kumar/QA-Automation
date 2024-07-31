package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM20_RejectManagerPreviousWeekTimesheetFromAdminPage {

	
	public WebDriver driver;

	public PM20_RejectManagerPreviousWeekTimesheetFromAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;
	
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;
	
	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;
	
	@FindBy(xpath ="//*[@rows='4']")
	WebElement remarkstext;
	
	@FindBy(xpath ="//*[text()='Confirm']")
	WebElement confirm;

	
	public void submittedPage() {
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
        boolean availableDate = true;
		if(availableDate) {
			CommonUtils.CalenderSelectWithDate(driver, date);	
			Logs.info("Selected the past week date from calendar");
			Thread.sleep(3000);
		}
		else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			Logs.info("Clicked on previous month arrow icon and selected the past week date from calendar");
			Thread.sleep(3000);
			System.out.println(pastDate);
		}
	}
	
	public void rejectTimesheet(String empid,String remarks) {
		WebElement reject=driver.findElement(By.xpath("//*[@title='" + empid + "']/following::td[8]/div[1]/button[2][@aria-label='Reject Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(reject, 10);
		Logs.info("Clicked on reject icon");
		CommonUtils.waitFor(2);
		CommonUtils.sendKeysToElement(remarkstext,remarks);
		Logs.info("Entered the remarks in text filed");
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		Logs.info("Clicked on confirm button");
		CommonUtils.waitFor(2);
	}
	
}
