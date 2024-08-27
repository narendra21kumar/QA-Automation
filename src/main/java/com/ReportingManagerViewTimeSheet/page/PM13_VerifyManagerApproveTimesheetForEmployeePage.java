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

public class PM13_VerifyManagerApproveTimesheetForEmployeePage {
	
	public WebDriver driver;
	public PM13_VerifyManagerApproveTimesheetForEmployeePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;
	
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStart;
	
	@FindBy(xpath="//*[text()='No records to display']")
	WebElement norecords;
	
	public void approvedPage() {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("Clicked on approved page icon");
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

	
	public void validatesStatusText(String empid,String Approvedtext) throws InterruptedException {
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
			Assert.assertEquals(ApprovedText,Approvedtext);
			CommonUtils.waitFor(2);
			Logs.info("Validated the approved timesheet record status");
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	
}
