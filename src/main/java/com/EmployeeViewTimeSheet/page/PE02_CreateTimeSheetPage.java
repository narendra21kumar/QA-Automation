package com.EmployeeViewTimeSheet.page;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PE02_CreateTimeSheetPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act;

	public PE02_CreateTimeSheetPage(WebDriver driver) {
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

	@FindBy(xpath = "//*[text()='View Timesheet']")
	WebElement viewTimesheetHeader;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[2]")
	WebElement editicon;

	public void CreateTimesheetIcon() throws Exception {
		createTimesheetIcon.click();
		Logs.info("Clicked on TimesheetIcon");
	}

	public void editIcon() throws Exception {
		editicon.click();
		Logs.info("Clicked On EditIcon ");
	}

	public void enterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
		Logs.info("Entered Task Description and Hours");
	}

	public void saveSubmitConfirm() {
		try {
			CommonUtils.waitFor(2);
			saveall.click();
			CommonUtils.waitFor(2);
			submit.click();
			CommonUtils.waitFor(2);
			confirm.click();
			Logs.info("Clicked on save,submit and confirm button");
		} catch (Exception e) {
			Logs.warn("Duplicate Task Description");
			System.out.println("Cant able to save Because Duplicate Task Discription");

		}
	}

	public void saveAll() {
		CommonUtils.waitFor(2);
		saveall.click();
		Logs.info("Clicked on save button");
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
			Logs.info("Future date has been selected");
			Thread.sleep(3000);
		} else {
			CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
			CommonUtils.CalenderSelectWithDate(driver, date);
			Logs.info("clicked on arrow icon to select the Future date");
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
		if (availableDate) {
			CommonUtils.CalenderSelectWithDate(driver, date);
			Logs.info("past week date has been selected");
			Thread.sleep(3000);
		} else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			CommonUtils.CalenderSelectWithDate(driver, date);
			Logs.info("clicked on arrow icon to select the Past week date");
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
		Logs.info("Current week has been selected");

	}

	public void validateTimesheetResponse(String SuccessText) throws Exception {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, SuccessText);
		Logs.info("validation for Successfully submission of Timesheet");
	}

	public void editIconEnable() throws InterruptedException {

	}

	public void verifyDraftFunctionality(String draftText) throws Exception {
		String viewTimesheetText = viewTimesheetHeader.getText();
		Assert.assertEquals(viewTimesheetText, draftText);
		editicon.isDisplayed();
		Logs.info("Successfully validation of DraftFunctionality");
	}
}
