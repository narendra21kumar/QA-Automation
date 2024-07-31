package com.ReportingManagerViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PM17_ManagerExceededTimesheetHoursPage {

	public WebDriver driver;

	public PM17_ManagerExceededTimesheetHoursPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;

	@FindBy(xpath = "//*[@name='next-month']")
	WebElement FutureMonthArrowIcon;

	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//div[text()='Summation of hours in mon tue wed thu fri exceeded 24!!!']")
	WebElement hoursTimevalidation;

	public void CreateTimesheetIcon() throws Exception {
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
		if (availableDate) {
			CommonUtils.CalenderSelectWithDate(driver, date);
			Logs.info("Selected the future week date from calendar");
			Thread.sleep(3000);
		} else {
			CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
			Logs.info("Clicked on future month arrow icon and selected the future week date from calendar");
			Thread.sleep(3000);
			System.out.println(future);
		}
	}

	public void enterTaskDescriptionCategorySubcategory(String sheetName) throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, sheetName);
		Logs.info("Entered the task description,category and hours");
	}

	public void saveAll() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		Logs.info("Clicked on saveall icon");

	}

	public void validateHoursValidation(String HoursValidation) throws Exception {
		String TimeValidation = hoursTimevalidation.getText();
		Assert.assertEquals(TimeValidation, HoursValidation);
		Logs.info("Validated the time hours per day");
	}
}
