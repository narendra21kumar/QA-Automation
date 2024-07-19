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

public class PE09_DeleteFutureWeekTimesheetPage {

	WebDriver driver;
	 
	public PE09_DeleteFutureWeekTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;
	@FindBy(xpath = "//*[@aria-label='Edit']")
	WebElement EditIcon;
	@FindBy(xpath = "//*[@aria-label='Add row']")
	WebElement clickAddRowIcon;
	@FindBy(xpath = "//*[@aria-label='Delete']")
	List<WebElement> clickDeleteIcon;
	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;
	@FindBy(xpath = "//*[@name='next-month']")
	WebElement FutureMonthArrowIcon;
 
	public void CreateTimesheetIcon() throws Exception 
	{
		createTimesheetIcon.click();
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
			Thread.sleep(3000);
		}
		else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			Thread.sleep(3000);
			System.out.println(pastDate);
		}
	}
	public void selectCurrentWeek() {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		System.out.println(currentDate);
		CommonUtils.CalenderSelectWithDate(driver, date);
	}
	public void EditIcon() throws Exception 
	{
		EditIcon.click();
	}
	public void addARow() throws Exception 
	{
		clickAddRowIcon.click();
		
	}
	public void deleteTimesheet() throws Exception 
{
//		List<WebElement> deleteIcons = driver.findElements(By.xpath("//*[@aria-label='Delete']"));
//		System.out.println(deleteIcons.size());
//		for(int i=1;i<=deleteIcons.size();) {
//			try {
//				deleteIcons.get(i).click();	
//				Thread.sleep(2000);
//			}
//		catch(Exception e) {
//			System.out.println(e);
//			System.out.println("Delect icon is not found");
//		}
//		}
		List<WebElement> removeButtons = driver.findElements(By.xpath("//*[@aria-label='Delete']"));
	    System.out.println(removeButtons.size());
	    for (int i = removeButtons.size()-1; i >= 0; i--) {
	    	try {
	        removeButtons.get(i).click();
	        Thread.sleep(2000);
	    	}
	    	catch(Exception e) {
	    		clickAddRowIcon.click();
	    		Thread.sleep(2000);
	    		WebElement DeleteIcon = driver.findElement(By.xpath("//*[@aria-label='Delete']"));
	    		DeleteIcon.click();
	    		Thread.sleep(2000);
	    	}
	    }
	}
	
 
	public void ValidateTimesheetResponse(String DeletionText) throws Exception 
	{
			String TaskDeletionText = driver.findElement(By.xpath("//*[text()='Task deleted successfully!']")).getText();
			Assert.assertEquals(TaskDeletionText, DeletionText);	
	}
}
