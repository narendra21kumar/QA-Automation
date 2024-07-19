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

public class PM02_CreateTimeSheetPage {

	WebDriver driver;

	public PM02_CreateTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStartIcon;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Create Timesheet']")
	WebElement createTimesheetIcon;

	@FindBy(xpath = "//div[@class='MuiBox-root jss5']//*[name()='svg']")
	WebElement clickAddRowIcon;

	@FindBy(xpath = "(//div[@class='MuiBox-root jss5']//*[name()='svg'])[2]")
	WebElement clickSaveIcon;

	@FindBy(xpath = "(//div[@class='MuiBox-root jss5']//*[name()='svg'])[3]")
	WebElement clickCancelIcon;

	@FindBy(css = "//tbody/tr[1]/td[12]//*[name()='svg']//*[name()='path' and contains(@d,'M6 19c0 1.')]")
	WebElement clickDeleteIcon;

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

	public void CreateTimesheetIcon() throws Exception {
		createTimesheetIcon.click();
	}

	public void enterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
	}

	public void saveSubmitConfirm() {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();
		CommonUtils.waitFor(2);
		confirm.click();
	}

	public void selectfutureWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 7);
		Date future = cal.getTime();
		int date = future.getDate();
		System.out.println(future);
		if (FutureMonthArrowIcon.isEnabled()) {
			CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
			Thread.sleep(3000);
		} else {
			System.out.println("Future Month Button is not Enabled");
		}
		CommonUtils.CalenderSelectWithDate(driver, date);
		System.out.println(future);
	}

	public void selectPastWeekDate() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, -7);
		Date pastDate = cal.getTime();
		int date = pastDate.getDate();
		if (PreviousMonthArrowIcon.isEnabled()) {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			Thread.sleep(3000);
		} else {
			System.out.println("Previous Month Button is not Enabled");
		}
		CommonUtils.CalenderSelectWithDate(driver, date);
		System.out.println(pastDate);
	}

	public void ValidateTimesheetResponse() throws Exception {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, "Timesheet already submitted!");
	}
}