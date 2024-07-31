package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM21_DeleteTimesheetPage {

	public WebDriver driver;
	public PM21_DeleteTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;
	
	@FindBy(xpath ="//*[@class='MuiBox-root css-1ay9vb9']")
	WebElement EditIcon;
	
	@FindBy(xpath = "//*[@aria-label='Add row']")
	WebElement clickAddRowIcon;
	
	@FindBy(xpath = "//*[@aria-label='Delete']")
	List<WebElement> clickDeleteIcon;
	
	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;
	
	@FindBy(xpath = "//*[@name='next-month']")
	WebElement FutureMonthArrowIcon;
	
	public void createTimesheetIcon() throws Exception 
	{
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 10);
		Logs.info("Clicked on create timesheet page icon");
	}
	public void selectFutureWeekDate() throws InterruptedException {
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
				Logs.info("Selected the future week date from calendar");
				Thread.sleep(3000);
			}
			else {
				CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
				Logs.info("Clicked on future month arrow and selected the future week date from calendar");
				Thread.sleep(3000);
				System.out.println(future);
			}
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
			CommonUtils.waitFor(2);
		}
		else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			Logs.info("Clicked on previous month arrow and selected the future week date from calendar");
			Thread.sleep(3000);
			System.out.println(pastDate);
		}
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
	public void editIcon() throws Exception 
	{
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(EditIcon, 10);
		Logs.info("Clicked on edit icon");
		CommonUtils.waitFor(5);
	}
	public void addRow() throws Exception 
	{
		CommonUtils.explicitlyWaitForElementandClick(clickAddRowIcon, 10);
		Logs.info("Clicked on add row icon");
	
	}
	public void deleteTimesheet() throws Exception 
	{
		List<WebElement> removeButtons = driver.findElements(By.xpath("//*[@aria-label='Delete']"));
	    System.out.println(removeButtons.size());
	    for (int i = removeButtons.size()-1; i >= 0; i--) {
	    	try {
	        removeButtons.get(i).click();
	        Thread.sleep(2000);
	    	}
	    	catch(Exception e) {
	    		CommonUtils.waitFor(2);
	    		CommonUtils.explicitlyWaitForElementandClick(clickAddRowIcon, 10);
	    		CommonUtils.waitFor(2);
	    		WebElement DeleteIcon = driver.findElement(By.xpath("//*[@aria-label='Delete']"));
	    		DeleteIcon.click();
	    		Thread.sleep(2000);
	    		e.getMessage();
	    	}
	    }
	    Logs.info("Deleted the timesheet");
	}

	public void validateTimesheetResponse(String DeletionText) throws Exception 
	{
		CommonUtils.waitFor(2);
			String TaskDeletionText = driver.findElement(By.xpath("//*[text()='Task deleted successfully!']")).getText();
			Assert.assertEquals(TaskDeletionText, DeletionText);	
			Logs.info("Validated the toast message as task deleted successfully");
	}
}
