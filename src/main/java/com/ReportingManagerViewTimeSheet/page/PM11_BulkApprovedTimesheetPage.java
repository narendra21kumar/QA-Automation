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

public class PM11_BulkApprovedTimesheetPage {

	public WebDriver driver;
	public PM11_BulkApprovedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStartIcon;
	
	@FindBy(xpath ="(//*[@class='rdp-nav_icon'])[1]")
	WebElement PreviousMonthArrowIcon;
	
	@FindBy(xpath ="(//*[@class='rdp-nav_icon'])[2]")
	WebElement FutureMonthArrowIcon;
	
	@FindBy(xpath ="(//input[@type='checkbox'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[text()='Approve']")
	WebElement approvebtn;
	
	@FindBy(xpath="//*[text()='No records to display']")
	WebElement norecords;
	
	public void timesheetSubmittedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(timesheetmanagementicon,10);
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
	public void checkBox() {
		try {
			if(norecords.isDisplayed()) {
				System.out.println("no records for check the check box");
				Logs.info("There is no timesheet records for checking the checkbox");
			}
		} catch (Exception e) {
			e.getMessage();
			CommonUtils.JavaScriptExecutorClick(driver,checkbox);
			Logs.info("Clicked on checkbox");
		}
		
	}
	public void bulkApproveButton()
	{
		try {
			if(norecords.isDisplayed()) {
				System.out.println("no records for approve the timesheet");
				Logs.info("Approve button is not displayed");
			}
		} catch (Exception e) {
			e.getMessage();
			CommonUtils.waitFor(2);
			CommonUtils.explicitlyWaitForElementandClick(approvebtn, 2);
			Logs.info("Clicked on approve button");
		}
		}
	public void validateToastmessage(String toastmessagge,String norecordmessage) {
		if(norecords.isDisplayed()) {
			System.out.println("no records for validate the toast message");
			Logs.info("Timesheet records is not displayed for validating toast message");
		}
		else {
		WebElement toastmsg=driver.findElement(By.xpath("//*[text()='Timesheet approved successfully!']"));
		String toasttext=toastmsg.getText();
		Assert.assertEquals(toasttext,toastmessagge);
		Logs.info("Validated the toast message as timesheet approved successfully");
		CommonUtils.waitFor(10);
		WebElement records=driver.findElement(By.xpath("//*[text()='No records to display']"));
		String recordtext=records.getText();
		Assert.assertEquals(recordtext,norecordmessage);
		
	}
	}
}
