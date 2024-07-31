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

public class PM18_VerifyManagerTimesheetLessThan40HoursPage {

	public WebDriver driver;

	public PM18_VerifyManagerTimesheetLessThan40HoursPage(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;
	
	@FindBy(xpath = "//*[text()='Minimum 40 hours required to submit the timesheet']")
	WebElement LesshoursTimevalidation;
	
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

	public void saveSubmitAndConfirm() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		Logs.info("Clicked on saveall icon");
		CommonUtils.waitFor(4);
		CommonUtils.explicitlyWaitForElementandClick(submit, 10);
		Logs.info("Clicked on submit button");
		CommonUtils.waitFor(2);
	}

	public void validationFor40hrs(String HoursValidation) throws Exception {
		try {
			CommonUtils.waitFor(2);
			String TimeValidation = LesshoursTimevalidation.getText();
			Assert.assertEquals(TimeValidation, HoursValidation);
			Logs.info("Validated the minimum time hours for week");
		} catch (Exception e) {

			Logs.info(e.getMessage());
		}
	}

}
