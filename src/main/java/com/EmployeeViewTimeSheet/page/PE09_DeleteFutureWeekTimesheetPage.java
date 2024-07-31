package com.EmployeeViewTimeSheet.page;

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
import com.TimeSheet.utils.Logs;

public class PE09_DeleteFutureWeekTimesheetPage {

	WebDriver driver;

	public PE09_DeleteFutureWeekTimesheetPage(WebDriver driver) {
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

	public void CreateTimesheetIcon() throws Exception {
		createTimesheetIcon.click();
		Logs.info("Clicked on Create Timesheet Page");
	}

	public void selectfutureWeekDate() throws InterruptedException {
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
			Thread.sleep(3000);
			Logs.info("Selected the Future Week ");
		} else {
			CommonUtils.explicitlyWaitForElementandClick(FutureMonthArrowIcon, 10);
			CommonUtils.CalenderSelectWithDate(driver, date);
			Thread.sleep(3000);
			Logs.info("Clicked on Arrow Icon and Selected the Future Week");
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
			Thread.sleep(3000);
			Logs.info("Selected the Past Week ");
		} else {
			CommonUtils.explicitlyWaitForElementandClick(PreviousMonthArrowIcon, 10);
			CommonUtils.CalenderSelectWithDate(driver, date);
			Thread.sleep(3000);
			Logs.info("Clicked on Arrow Icon and Selected the Past Week");
			System.out.println(pastDate);
		}
	}

	public void selectCurrentWeek() {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.DATE, 1);
		Date currentDate = cal.getTime();
		int date = currentDate.getDate();
		System.out.println(currentDate);
		CommonUtils.CalenderSelectWithDate(driver, date);
		Logs.info("Selected the Current Week ");
	}

	public void editIcon() throws Exception {
		EditIcon.click();
		Logs.info("Clicked on EditIcon");
	}

	public void addARow() throws Exception {
		clickAddRowIcon.click();
		Logs.info("Clicked on AddARowIcon");
	}

	public void deleteTimesheet() throws Exception {
		List<WebElement> removeButtons = driver.findElements(By.xpath("//*[@aria-label='Delete']"));
		System.out.println(removeButtons.size());
		for (int i = removeButtons.size() - 1; i >= 0; i--) {
			try {
				removeButtons.get(i).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				clickAddRowIcon.click();
				Thread.sleep(2000);
				WebElement DeleteIcon = driver.findElement(By.xpath("//*[@aria-label='Delete']"));
				DeleteIcon.click();
				Thread.sleep(2000);
			}
		}
		Logs.info("Timesheet has been deleted");
	}

	public void validateTimesheetResponse(String DeletionText) throws Exception {
		String TaskDeletionText = driver.findElement(By.xpath("//*[text()='Task deleted successfully!']")).getText();
		Assert.assertEquals(TaskDeletionText, DeletionText);
		Logs.info("Successfully done the validation of Delete Timesheet");
	}
}
