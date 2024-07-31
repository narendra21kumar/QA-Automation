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

public class PE08_ManagerLoginForApprovalPage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act;
	String WeekStartDate;

	public PE08_ManagerLoginForApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@title,'Submitted')]")
	WebElement SubmittedIcon;
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root'])[1]")
	WebElement calendarStart;

	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;

	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;

	@FindBy(xpath = "//button[contains(@aria-label,'Approve Timesheet')]")
	WebElement ApprovedOKTimeSheet;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Approved']")
	WebElement approvedIcon;

	@FindBy(xpath = "(//*[@class='_2pnfWKxpUmAwFEMKV33FOI'])[1]")
	WebElement getEmpId;

	@FindBy(xpath = "//*[@name='previous-month']")
	WebElement PreviousMonthArrowIcon;

	@FindBy(xpath = "//*[@name='next-month']")
	WebElement FutureMonthArrowIcon;

	@FindBy(xpath = "//*[@rows='4']")
	WebElement RemarksText;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement ConformButton;

	public void clickonTimeSheetMangementIcon() {
		CommonUtils.explicitlyWaitForElementandClick(SubmittedIcon, 10);
		Logs.info("Clicked on Timesheet management page");
	}

	public void startWeek() throws InterruptedException {
		CommonUtils.waitFor(3);
		selectCurrentWeek();
		Logs.info("Selected the CurrentWeek");
	}

	// ---------------------------//

	public void selectCurrentWeek() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		System.out.println(currentDate);
		CommonUtils.CalenderSelectWithDate(driver, date);
		Logs.info("Selected the current week");
		Thread.sleep(3000);
	}

	// ------------------------------------//
	public void getAttribute() {
		String empid = getEmpId.getText();
		approveTimesheet(empid);
	}

	public void approveTimesheet(String empid) {
		WebElement element = driver.findElement(By
				.xpath("//*[@title='" + empid + "']/following::td[8]/div[1]/button[@aria-label='Approve Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		Logs.info("Approved the Timesheet");
	}

	public void empApprovedTimesheetandVerify(String empid, String Approvedtext) throws InterruptedException {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("Clicked on approved Page");
		CommonUtils.waitFor(2);
		selectCurrentWeek();
		WebElement ExpandIcon = driver
				.findElement(By.xpath("(//*[@title='" + empid + "']/ancestor::td//preceding-sibling::td)[1]"));
		ExpandIcon.click();
		Logs.info("Clicked on ExpandArrow in approved Page");
		CommonUtils.waitFor(5);
		String ApprovedText = driver
				.findElement(By.xpath("//*[@title='" + empid + "']/following::td[4]/div[@title='Approved']")).getText();
		Assert.assertEquals(ApprovedText, Approvedtext);
		CommonUtils.waitFor(2);
		Logs.info("successfully done the validation of Approval Timesheet");
	}

	public void rejectTimesheet(String empid, String RejectText) throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(approvedIcon, 10);
		Logs.info("Clicked on approved Page");
		CommonUtils.waitFor(2);
		selectCurrentWeek();
		CommonUtils.waitFor(2);
		WebElement element = driver.findElement(
				By.xpath("//*[@title='" + empid + "']/following::td[8]/div/button[@aria-label='Reject Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		Logs.info("Reject the Timesheet");
		CommonUtils.waitFor(2);
		CommonUtils.sendKeysToElement(RemarksText, RejectText);
		CommonUtils.waitFor(2);
		Logs.info("Entered Text for Rejection ");
		CommonUtils.explicitlyWaitForElementandClick(ConformButton, 10);
		Logs.info("Clicked on Confirm Button");
		CommonUtils.waitFor(2);
		Logs.info("Successfully Reject the Timesheet");
	}
}