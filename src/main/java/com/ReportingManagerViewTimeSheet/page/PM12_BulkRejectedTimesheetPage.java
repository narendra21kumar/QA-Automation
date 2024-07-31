package com.ReportingManagerViewTimeSheet.page;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
 
public class PM12_BulkRejectedTimesheetPage {
	public WebDriver driver;
	public PM12_BulkRejectedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//a[@title=\"Submitted\"]")
	WebElement timesheetmanagementicon;
	
	@FindBy(xpath ="(//input[@type='checkbox'])[1]")
	WebElement checkbox;
	
	@FindBy(xpath = "(//*[text()='Reject'])[1]")
	WebElement RejectButton;
	
	@FindBy(xpath = "//*[@class='_17CUqmCextOqfytuhqZlM']")
	WebElement RemarksTextArea;
	
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmButton;
	
	@FindBy(xpath="//*[text()='No records to display']")
	WebElement norecords;
	
	
	public void timesheetSubmittedIcon() {
		CommonUtils.explicitlyWaitForElementandClick(timesheetmanagementicon,10);
		Logs.info("Clicked on timesheet management page icon");
	}
	public void checkBox() {
			try {
				if(norecords.isDisplayed()) {
					System.out.println("no records for check the checkbox");
					Logs.info("Tere is no timesheet records for checking the checkbox");
				}
			} catch (Exception e) {
				e.getMessage();
				CommonUtils.JavaScriptExecutorClick(driver,checkbox);
				Logs.info("Clicked on checkbox");
			}
		
	}
	public void rejectectButton(String remarks) {
		try {
			if(norecords.isDisplayed()) {
				System.out.println("no records for reject the timesheet");
				Logs.info("Reject button is not displayed");
			}
		} catch (Exception e) {
			e.getMessage();
			CommonUtils.explicitlyWaitForElementandClick(RejectButton, 10);
			Logs.info("Clicked on reject button");
			CommonUtils.sendKeysToElement(RemarksTextArea, remarks);
			Logs.info("Eneterd the remarks in text field");
			CommonUtils.explicitlyWaitForElementandClick(confirmButton,10);
			Logs.info("Clicked on confirm button");
		}
		}
	public void validateRejectedToastMessage(String toastmessagge,String norecordmessage) {
		if(norecords.isDisplayed()) {
			System.out.println("no records for validate the toast message");
			Logs.info("Timesheet records is not displayed for validating toast message");
		}
		else {
		WebElement toastmsg=driver.findElement(By.xpath("//*[text()='Timesheet rejected successfully!']"));
		String toasttext=toastmsg.getText();
		Assert.assertEquals(toasttext,toastmessagge);
		Logs.info("Validated the toast message as timesheet rejected successfully");
		CommonUtils.waitFor(10);
		WebElement records=driver.findElement(By.xpath("//*[text()='No records to display']"));
		String recordtext=records.getText();
		Assert.assertEquals(recordtext,norecordmessage);
		
	}}
}
