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

public class PM14_VerifyManagerRejectedTimesheetForEmployeePage {

	public WebDriver driver;
	public PM14_VerifyManagerRejectedTimesheetForEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Rejected']")
	WebElement rejectedIcon;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStart;

	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;
	
	@FindBy(xpath="//*[text()='No records to display']")
	WebElement norecords;
	
	public void rejectedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(rejectedIcon, 10);
		Logs.info("Clicked on Rejected page icon");
	}
 
	public void selectPastWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 5);
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
	
	public void validateStatusText(String empid,String RejectedText) throws InterruptedException {
		try {
			if(norecords.isDisplayed()) {
				System.out.println("there is no timesheet record for verifying the employee timesheet status");
				Logs.info("There is no timesheet record for verifying the employee timesheet status");
			}
			else if(empid.isEmpty()) {
				System.out.println("there is no employee id for current week to check the status");
				Logs.info("There is no employee id for current week to check the status");
			}
			else {
			WebElement	expandIcon=driver.findElement(By.xpath("(//*[@title='"+empid+"']/ancestor::td//preceding-sibling::td)[1]"));
			CommonUtils.explicitlyWaitForElementandClick(expandIcon, 10);
			Logs.info("Clicked on expand arrow");
			CommonUtils.waitFor(2);				
			String ApprovedText = driver.findElement(By.xpath("//*[@title='"+empid+"']/following::td[4]/div[@title='Approved']")).getText();
			Assert.assertEquals(ApprovedText,RejectedText);
			CommonUtils.waitFor(2);
			Logs.info("Validated the rejected timesheet record status");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
