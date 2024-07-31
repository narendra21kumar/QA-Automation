package com.AdminViewTimeSheet.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA04_CreateTimeSheetPage {
	WebDriver driver;

	public PA04_CreateTimeSheetPage(WebDriver driver) {
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

	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[1]")
	List<WebElement> listOfEmployeeNames;

	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]")
	List<WebElement> statusOfEmployeeFromeReports;

	@FindBy(xpath = "(//*[@class=\"MuiSvgIcon-root\"])[2]")
	WebElement editicon;

	@FindBy(xpath = "//*[text()='Duplicate task']")
	WebElement DuplicateTask;

	@FindBy(xpath = "//div[text()='Summation of hours in mon exceeded 24!!!']")
	WebElement Timevalidation;

	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	WebElement lessThanHrsValidation;

	public void createTimesheetIcon() throws Exception {
		createTimesheetIcon.click();
		Logs.info("clicked on TimesheetManagement Page");
	}

	public void selectcalendar() {
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 10);
		CommonUtils.waitFor(3);
		Logs.info("Clicked on calender start icon");
	}

//	public void selectAnyWeek(int weekOffSet) throws InterruptedException {
//		CommonUtils.selectAnyWeek(driver, weekOffSet);
//	}

	public void draftSubmitBtnEnabled() {
		if (submit.isEnabled()) {
			System.out.println("Record is exist in Draft");
			Logs.info("successfully verified Draft Functionality");
		} else {
			System.err.println("Record is not exist hence it failed");
			Logs.info("Record is not present in draft");
		}
	}

	public void editicon() {
		editicon.click();
		Logs.info("clicked on edit Icon");
	}

	public void enterTaskDiscriptionCategorySubcategory(String SheetName) throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, SheetName);
		Logs.info("Entered Task description and hours");
	}

	public void saveSubmitConfirm() {
		CommonUtils.waitFor(2);
		saveall.click();
		CommonUtils.waitFor(2);
		submit.click();
		CommonUtils.waitFor(2);
		confirm.click();
		Logs.info("clicked on save,submit and confirm button");
	}

	public void validateTaskdesc() throws Exception {
		saveall.click();
		CommonUtils.waitFor(2);
		String duplicateTask = DuplicateTask.getText();
		Assert.assertEquals(duplicateTask, "Duplicate task");
		Logs.info("successfully verified duplicate task");
	}
//////////////////////////////////////////////////////////////////

	public void validateTimesheetResponse() throws Exception {
		String alreadysubmittedtext = driver.findElement(By.xpath("//*[text()='Timesheet already submitted!']"))
				.getText();
		Assert.assertEquals(alreadysubmittedtext, "Timesheet already submitted!");
		Logs.info("successfully verified Timesheet already submitted");
	}

	public void verifyFromReports(String EmpName, String result) {
		for (WebElement NamesOfEmployee : listOfEmployeeNames) {
			String nameOfEmployees = NamesOfEmployee.getText();
			System.out.println(nameOfEmployees);
			if (nameOfEmployees.equalsIgnoreCase(EmpName)) {
				for (WebElement getStatusOfEmp : statusOfEmployeeFromeReports) {
					String getEmpStatus = getStatusOfEmp.getText();
					if (getEmpStatus.equalsIgnoreCase(result)) {
						System.out.println(getEmpStatus);
					}
				}
			}
		}
	}

	//////////////////////////// 24Hrs Validation//////////////////////////////////

	public void exceedHoursPerDay() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "24hrs Validation@Admin");
		Logs.info("Entered task description and hours for exceeding hours per day");
	}

	public void moreThan40Hrs() throws Exception {
		CommonUtils.taskDesccategoryandEnteringHours(driver, "lessThan40Hours@Admin");
		Logs.info("Entered task description and hours for minimum 40 hours");
	}

	public void validateHoursvalidation() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		String TimeValidation = Timevalidation.getText();
		Assert.assertEquals(TimeValidation, "Summation of hours in mon exceeded 24!!!");
		Logs.info("successfully verified for exceeding hours per day");
	}

	public void validationFor40hrs() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(saveall, 10);
		Thread.sleep(3000);
		CommonUtils.explicitlyWaitForElementandClick(submit, 10);
		String LessThan40Hrs = lessThanHrsValidation.getText();
		Assert.assertEquals(LessThan40Hrs, "Minimum 40 hours required to submit the timesheet");
		Logs.info("successfully verified for minimum 40 hours per week");
	}
//////////////////////////////////////////////////////////////////////////////////////	

}

/*
 * public void selectCurrentWeek() {
 * 
 * // CommonUtils.CalenderSelectWithDate(driver, 1); Calendar cal =
 * Calendar.getInstance(); cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
 * cal.add(Calendar.DATE, 0); Date currentDate = cal.getTime(); int date =
 * currentDate.getDate(); CommonUtils.CalenderSelectWithDate(driver, date);
 * System.out.println(currentDate); }
 * 
 * 
 * public void selectfutureWeekDate() throws InterruptedException {
 * CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5); Calendar
 * cal = Calendar.getInstance(); cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
 * cal.add(Calendar.DATE, 7); Date future = cal.getTime(); int date =
 * future.getDate(); System.out.println(future); if
 * (FutureMonthArrowIcon.isEnabled()) {
 * CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
 * Thread.sleep(3000); } else {
 * System.out.println("Future Month Button is not Enabled"); }
 * CommonUtils.CalenderSelectWithDate(driver, date); System.out.println(future);
 * }
 * 
 * public void selectPastWeekDate() throws InterruptedException { //
 * CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5); Calendar
 * cal = Calendar.getInstance(); cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
 * cal.add(Calendar.WEEK_OF_MONTH, -2); Date pastDate = cal.getTime(); int date
 * = pastDate.getDate(); if (PreviousMonthArrowIcon.isEnabled()) {
 * CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
 * Thread.sleep(3000); } else {
 * System.out.println("Previous Month Button is not Enabled"); }
 * CommonUtils.CalenderSelectWithDate(driver, date);
 * System.out.println(pastDate); }
 */
