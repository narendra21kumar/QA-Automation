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

public class PE02_CreateTimeSheetPage {

	static WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions act;

	public PE02_CreateTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@title,'Create Timesheet')]")
	WebElement CreateTimeSheetIcon;

	@FindBy(xpath = "//*[@class='MuiSvgIcon-root']")
	WebElement calendarStart;

	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;

	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;

	// button[@name='previous-month']
	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;

	@FindBy(xpath = "(//tbody[@class='MuiTableBody-root css-1xnox0e'])[1]//child::tr//child::td")
	List<WebElement> EntireTimesheet;

	@FindBy(xpath = "((//tbody[@class='MuiTableBody-root css-1xnox0e'])[1]//child::tr)[]//child::td")
	List<WebElement> singleRow;

	@FindBy(xpath = "//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")
	WebElement DropDownblock;
	@FindBy(xpath = "//li[@class='MuiButtonBase-root MuiListItem-root MuiMenuItem-root Mui-selected MuiMenuItem-gutters MuiListItem-gutters MuiListItem-button Mui-selected'")
	WebElement projectdrodown;
	@FindBy(xpath = "//*[@class='MuiInputBase-input MuiInput-input']")
	List<WebElement> dayslist;
	@FindBy(xpath = "(//*/table/tbody/tr)//child::*[@class='MuiSvgIcon-root MuiSelect-icon']")
	List<WebElement> dropdownarrows;

	@FindBy(xpath = "//*[@rows='1'][@class='_3C127Bu90msN4CSusQTzd1']")
	List<WebElement> TaskDescription;

	@FindBy(xpath = "//*[text()='Client CP']")
	WebElement project;

	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSelect-icon'])[1]")
	WebElement projectdropdownicon;

	@FindBy(xpath = "(//*[@class='_3C127Bu90msN4CSusQTzd1'])[1]")
	WebElement taskdescription;

	@FindBy(xpath = "//*[text()='Common']")
	WebElement category;

	@FindBy(xpath = "//*[text()='Dev Coding']")
	WebElement subcategory;

	@FindBy(xpath = "//*[@aria-label='Save all']")
	WebElement saveall;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submit;

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirm;

	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root\"])[2]")
	WebElement editicon;

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;

	@FindBy(xpath = "//*[text()='View Timesheet']")
	WebElement viewTimesheetHeader;

	@FindBy(xpath = "//*[text()='Duplicate task']")
	WebElement DuplicateTask;

	@FindBy(xpath = "//div[text()='Summation of hours in mon tue wed thu fri exceeded 24!!!']")
	WebElement Timevalidation;

	public void CreateTimeSheetIconClick() {
		CommonUtils.explicitlyWaitForElementandClick(CreateTimeSheetIcon, 10);
	}

	public void selectcalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 15);
		CommonUtils.waitFor(3);

	}

	public void futureWeekSelectBasedonReq(int DateValue) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, DateValue);
		Date future = cal.getTime();
		int date = future.getDate();
		CommonUtils.CalenderSelectWithDate(driver, date);
		System.out.println(future);
	}

	public void selectCurrentWeek() {

		CommonUtils.CalenderSelectWithDate(driver, 1);
	}

	public void projectselection() throws InterruptedException {
		projectdropdownicon.click();
		Thread.sleep(2000);
		project.click();
	}

	public void saveAll() {
		CommonUtils.waitFor(2);
		saveall.click();
	}

	public void submit() {
		CommonUtils.waitFor(2);
		submit.click();
	}

	public void confirm() {
		CommonUtils.waitFor(2);
		confirm.click();
	}

	/////////////////////// Already submitted timesheet////////////////////////
	public void selectCalenderToVerifyalreadysubmittedFunctionality() {
		CommonUtils.explicitlyWaitForElementandClick(CreateTimeSheetIcon, 10);
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(calendarStart, 10);
		CommonUtils.waitFor(3);
		CommonUtils.CalenderSelectWithDate(driver, 5);
	}

	public void alreadysubmittedtimesheet() {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, "Timesheet already submitted!");
	}

	/////////////////////////// Edit timesheet functinality////////////////////

	public void editicon() {
		editicon.click();
	}

	/////////////// Draft Func/////////////
	public void CreateTimesheetFordraftFunctionality() throws Exception {
		CreateTimeSheetIconClick();
		selectcalendar();
		CommonUtils.CalenderSelectWithDate(driver, 26);
		CommonUtils.taskDesccategoryandEnteringHours(driver, "14th Week");
		CommonUtils.waitFor(2);
		saveAll();
		CommonUtils.waitFor(2);
		pendingApprovalIconClick();
		CommonUtils.waitFor(2);
		CreateTimeSheetIconClick();
		selectcalendar();
		CommonUtils.CalenderSelectWithDate(driver, 5);
		CommonUtils.waitFor(2);
	}

	public void pendingApprovalIconClick() throws InterruptedException {
		pendingApprovalIcon.click();
	}

	public void editIconEnable() throws InterruptedException {
		String viewTimesheetText = viewTimesheetHeader.getText();
		Assert.assertEquals(viewTimesheetText, "View Timesheet");
		editicon.isDisplayed();
	}

	public void VerifydraftFunctionality() throws Exception {
		editIconEnable();

	}

	////////////////////////// Duplicate Task Description////////////
	public void taskdesc() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "TaskDesc");

	}

	public void validateTaskdesc() throws Exception {
		saveAll();
		String duplicateTask = DuplicateTask.getText();
		Assert.assertEquals(duplicateTask, "Duplicate task");
	}

	/////////////////// timehours validation////////////

	public void taskdispAndHours() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "TimeHoursMorethen24");

	}

	public void validateHoursvalidation() throws Exception {
		saveAll();
		String TimeValidation = Timevalidation.getText();
		Assert.assertEquals(TimeValidation, "Summation of hours in mon tue wed thu fri exceeded 24!!!");
	}

	public void validationFor40hrs() throws Exception {
		saveAll();
		String TimeValidation = Timevalidation.getText();
		Assert.assertEquals(TimeValidation, "Summation of hours in mon tue wed thu fri exceeded 24!!!");
	}

	public static void datePickerAutomaticFuture() {
		LocalDate todaysDate = LocalDate.now();
		LocalDate futureDate = todaysDate.plusDays(8);
		int DayOneWeekLater = futureDate.getDayOfMonth();
		String dayXpath = "//div[contains(@class,'rdp')]//tr//td//button[text()='" + DayOneWeekLater + "']";
		By futureDateInspect = By.xpath(dayXpath);
		WebElement oneWeekAfter = driver.findElement(futureDateInspect);
		WebElement nextArrowBtn = driver
				.findElement(By.xpath("//div[contains(@class,'rdp')]//div//button[@name='next-month']"));
		if (nextArrowBtn.isEnabled()) {
			nextArrowBtn.click();
		} else {
			oneWeekAfter.click();
			System.out.println(oneWeekAfter.getText());
		}

	}

//public void datePickerAutomaticPrevious() throws Exception {
//	WebElement DateSelectedText = driver.findElement(By.xpath("//div[contains(@class,'MuiBox-root css-70qvj9')]"));
//	LocalDate todaysDate = LocalDate.now();
//	LocalDate pastDate = todaysDate.minusDays(10);
//	int DayOneWeekBefore = pastDate.getDayOfMonth();
//	String dayXpath = "//div[contains(@class,'rdp')]//td//button[text()='" + DayOneWeekBefore + "']";
//	By beforeDateInspect = By.xpath(dayXpath);
//	WebElement oneWeekBefore = driver.findElement(beforeDateInspect);
//	WebElement previousArrowBtn = driver.findElement(By.xpath("//div[contains(@class,'rdp')]//div//button[@name='previous-month']"));
//	WebElement nextArrowBtn = driver.findElement(By.xpath("//div[contains(@class,'rdp')]//div//button[@name='next-month']"));
//	if (previousArrowBtn.isEnabled()) {
//		CommonUtils.explicitlyWaitForElementandClick(previousArrowBtn, 10);
//		Thread.sleep(3000);
//		if(nextArrowBtn.isEnabled()) {
//        	CommonUtils.explicitlyWaitForElementandClick(oneWeekBefore,10);
//			Thread.sleep(3000);
//        }
//		
//	}
//	else {
//		System.out.println("Previous Month Button is not Enabled");	
//		oneWeekBefore.click();
//	}
//	System.out.println(DateSelectedText.getText());
//}

}
