package com.EmployeeViewTimeSheet.page;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PE06_TimesheetExceedANDPerdayHoursValidation {

	WebDriver driver;
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

	public void createTimesheetIcon() throws Exception {
		createTimesheetIcon.click();
		Logs.info("clicked on createTimesheet page");
	}

	public void enterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
		Logs.info("Entered task Description and hours");
	}

	public void saveSubmitConfirm() {
		try {
			CommonUtils.waitFor(2);
			saveall.click();
			CommonUtils.waitFor(2);
			submit.click();
			CommonUtils.waitFor(2);
			confirm.click();
			Logs.info("clicked on save,submit and confirm buttons");
		} catch (Exception e) {
			System.out.println("Cant able to save Because Duplicate Task Discription");
			Logs.warn("Duplicate task description");
		}
	}

	public void saveAll() {
		CommonUtils.waitFor(2);
		saveall.click();
		Logs.info("click on saveAll button");

	}

	public void saveSubmit() {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();
		Logs.info("clicked on saveAll and submit buttons");
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
			Logs.info("selected the future week date");
			Thread.sleep(3000);
		} else {
			CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
			CommonUtils.CalenderSelectWithDate(driver, date);
			Thread.sleep(3000);
			Logs.info("clicked on arrow For future week selection");
			System.out.println(future);
		}
	}

	public void validateHoursvalidation(String HoursValidation) throws Exception {
		String TimeValidation = hoursTimevalidation.getText();
		Assert.assertEquals(TimeValidation, HoursValidation);
		Logs.info("Successfully done the validation of PerDay exceeding Hours");
	}

	

}
