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

public class PM06_CreatePreviousWeekTimesheetPage {
	public WebDriver driver;

	public PM06_CreatePreviousWeekTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;

	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;

	@FindBy(xpath = ("//*[@aria-label='Select Week']/following::label[2]"))
	WebElement startdate;

	@FindBy(xpath = ("//*[@aria-label='Select Week']/following::label[4]"))
	WebElement enddate;

	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	public void createTimesheetIcon() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 10);
		Logs.info("Clicked on create timesheet page icon");
	}

	public void selectPastWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, -7);
		Date pastDate = cal.getTime();
		int date = pastDate.getDate();
		boolean availableDate = true;
		if (availableDate) {
			CommonUtils.CalenderSelectWithDate(driver, date);
			Thread.sleep(3000);
			Logs.info("Selected the past week date from calendar");
		} else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			Thread.sleep(3000);
			System.out.println(pastDate);
			Logs.info("Clicked on previous arrow icon and selected the past week date from calendar");
		}
	}

	public void enterTaskDescriptionCategorySubcategory(String SheetName) throws Exception {
		String startdatetext = startdate.getText();
		String enddatetext = enddate.getText();
		System.out.println("printing the selected start week date " + " : " + startdatetext + " and end date is "
				+ " : " + enddatetext);
		CommonUtils.waitFor(2);
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
		Logs.info("Entered the task description,category and hours");
	}

	public void saveIcon() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		Logs.info("Clicked on saveall icon");
	}

	public void submitButton() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(submit, 10);
		Logs.info("Clicked on submit button");
	}

	public void confirmButton() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		Logs.info("Clicked on confirm button");
	}

	public void validateTimesheetResponse() throws Exception {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, "Timesheet already submitted!");
		Logs.info("Validated the response as timesheet already submitted");
	}

}
