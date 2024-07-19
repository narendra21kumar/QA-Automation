package com.EmployeeViewTimeSheet.page;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

public class PE06_TimesheetExceedANDPerdayHoursValidation {

	static WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act;

	public PE06_TimesheetExceedANDPerdayHoursValidation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root jss5']//*[name()='svg'])[2]")
	WebElement clickSaveIcon;
	
	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;
	
	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;
	
	@FindBy(xpath = "//*[@name='next-month']")
	WebElement FutureMonthArrowIcon;

	@FindBy(xpath = "//*[text()='View Timesheet']")
	WebElement viewTimesheetHeader;
	
	@FindBy(xpath = "//div[text()='Summation of hours in mon tue wed thu fri exceeded 24!!!']")
	WebElement hoursTimevalidation;
	
	@FindBy(xpath = "//*[text()='Minimum 40 hours required to submit the timesheet']")
	WebElement LesshoursTimevalidation;
	
	public void CreateTimesheetIcon() throws Exception 
	{
		createTimesheetIcon.click();
	}

	
	public void enterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception 
	{
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
	}
	public void saveSubmitConfirm()
    {
		try {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();
		CommonUtils.waitFor(2);
		confirm.click();}
		 catch (Exception e) {
		      System.out.println("Cant able to save Because Duplicate Task Discription");
		    }
	}
	public void saveAll()
    {
		CommonUtils.waitFor(2);
		saveall.click();
		//submit.click();	
	}
	public void saveSubmit()
    {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();	
	}
	public void selectfutureWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 7);
		Date future = cal.getTime();
		int date = future.getDate();
		System.out.println(future);
		
		 boolean availableDate = true;
			if(availableDate) {
				CommonUtils.CalenderSelectWithDate(driver, date);	
				Thread.sleep(3000);
			}
			else {
				CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
				Thread.sleep(3000);
				System.out.println(future);
			}
		}
	public void validateHoursvalidation(String HoursValidation) throws Exception{
	
		String TimeValidation = hoursTimevalidation.getText();
		Assert.assertEquals(TimeValidation,HoursValidation);
	}
	
	public void validationFor40hrs(String HoursValidation) throws Exception{

		String TimeValidation = LesshoursTimevalidation.getText();
		Assert.assertEquals(TimeValidation,HoursValidation);
	}


}
