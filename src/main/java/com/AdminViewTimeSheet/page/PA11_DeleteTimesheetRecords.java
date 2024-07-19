package com.AdminViewTimeSheet.page;

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

public class PA11_DeleteTimesheetRecords {
	WebDriver driver;
	 
	public PA11_DeleteTimesheetRecords(WebDriver driver) {
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
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon,5);
	}
	
	public void EditIcon() throws Exception 
	{
		CommonUtils.explicitlyWaitForElementandClick(EditIcon, 5);
	}
	
	public void addARow() throws Exception 
	{
		CommonUtils.explicitlyWaitForElementandClick(clickAddRowIcon, 5);
	}
	
	public void clickCalendor() {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
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
	    		clickAddRowIcon.click();
	    		Thread.sleep(2000);
	    		WebElement DeleteIcon = driver.findElement(By.xpath("//*[@aria-label='Delete']"));
	    		DeleteIcon.click();
	    		Thread.sleep(2000);
	    	}
	    }
	}
	
	
	public void selectAnyWeek(int weekOffSet) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, weekOffSet);
        int targetDay = cal.get(Calendar.DAY_OF_MONTH);
        int targetMonth = cal.get(Calendar.MONTH);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

        // Click on the date picker to open it
        WebElement datePicker = driver.findElement(By.className("rdp-cell"));
        datePicker.click();

        // If the target month is before the current month, click the previous month arrow
        if (targetMonth < currentMonth) {
            WebElement prevMonthArrow = driver.findElement(By.xpath("//*[@name='previous-month']"));
            prevMonthArrow.click();
        }

        else if (targetMonth > currentMonth) {
            WebElement nextMonthArrow = driver.findElement(By.xpath("//*[@name='next-month']"));
            nextMonthArrow.click();
        }
        // Select the target day
        WebElement dayToSelect = driver.findElement(By.xpath("//*[text()='" + targetDay + "']"));
        dayToSelect.click();
        WebElement start=driver.findElement(By.xpath("//*[@aria-label='Select Week']/following::label[2]"));
		WebElement end=driver.findElement(By.xpath("//*[@aria-label='Select Week']/following::label[4]"));
		String startdate=start.getText();
		String enddate=end.getText();
		System.out.println("printing the selected start week date "+" : "+startdate+" and end date is "+" : "+enddate);
    }
	
	
	public void ValidateTimesheetResponse(String DeletionText) throws Exception 
	{
			String TaskDeletionText = driver.findElement(By.xpath("//*[text()='Task deleted successfully!']")).getText();
			Assert.assertEquals(TaskDeletionText, DeletionText);	
	}
 
}

