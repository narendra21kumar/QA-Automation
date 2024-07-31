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

public class PM19_RejectManagerCurrentWeekTimesheetFromAdminPage {
	public WebDriver driver;

	public PM19_RejectManagerCurrentWeekTimesheetFromAdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStart;
	
	@FindBy(xpath="//*[@rows='4']")
	WebElement remarkstextfield;
	
	@FindBy(xpath ="//*[text()='Confirm']")
	WebElement ConformButton;
	
	public void approveIconPage() {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("Clicked on approved page icon");
	}
	public void selectCurrentWeek() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		Thread.sleep(1000);
		System.out.println(currentDate);
		CommonUtils.CalenderSelectWithDate(driver, date);
		Logs.info("Selected the current week date");
		Thread.sleep(1000);
	}
	public void rejectTimesheet(String empid,String remarks) {
		WebElement reject=driver.findElement(By.xpath("//*[@title='"+empid+"']/following::td[8]/div/button[@aria-label='Reject Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(reject,10);
		Logs.info("Clicked on reject icon");
		CommonUtils.waitFor(2);
		CommonUtils.sendKeysToElement(remarkstextfield,remarks);
		Logs.info("Entered the remarks in text filed");
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(ConformButton, 10);
		Logs.info("Clicked on confirm button");
		CommonUtils.waitFor(2);
		
	}

}
