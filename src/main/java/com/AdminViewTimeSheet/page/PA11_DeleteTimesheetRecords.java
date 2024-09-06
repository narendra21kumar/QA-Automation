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

public class PA11_DeleteTimesheetRecords {
	WebDriver driver;

	public PA11_DeleteTimesheetRecords(WebDriver driver) {
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

	public void createTimesheetIcon() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(createTimesheetIcon, 5);
		Logs.info("clicked on CreateTime sheet Icon");
	}

	public void editIcon() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(EditIcon, 5);
		Logs.info("clicked on edit Icon");
	}

	public void addARow() throws Exception {
		CommonUtils.explicitlyWaitForElementandClick(clickAddRowIcon, 5);
		Logs.info("clicked on Add A row  Icon");
	}

	public void clickCalendor() {
		CommonUtils.explicitlyWaitForElementandClick(calendarStartIcon, 5);
		Logs.info("clicked on calender Icon");
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
		Logs.info("Timesheet Deleted successfully");
	}

	public void validateTimesheetResponse(String DeletionText) throws Exception {
		String TaskDeletionText = driver.findElement(By.xpath("//*[text()='Task deleted successfully!']")).getText();
		Assert.assertEquals(TaskDeletionText, DeletionText);
		Logs.info("successFully Verified for deletion");
	}

}
