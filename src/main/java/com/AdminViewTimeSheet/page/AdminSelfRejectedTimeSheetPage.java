package com.AdminViewTimeSheet.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
 
import com.TimeSheet.utils.CommonUtils;
public class AdminSelfRejectedTimeSheetPage {
	static WebDriver driver;
	String empid;
 
	public AdminSelfRejectedTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//*[@title=\"Submitted\"]")
	WebElement submitted;
	
	@FindBy(xpath="//*[@class='MuiSwitch-root MuiSwitch-sizeMedium css-ecvcn9']")
	WebElement showselftoggle;
	
	@FindBy(xpath="//button[text()='Reject']")
	WebElement rejected;
	
	@FindBy(xpath="//*[contains(@class,'_17CUqmCextOqfytuhqZlM') and @rows='4']")
	WebElement remarks;
	
	@FindBy(xpath= "//*[text()='Confirm']")
	WebElement confirm;
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Rejected']")
	WebElement RejectedIcon;
	
	@FindBy(xpath = "(//*[@title='188']/ancestor::td//preceding-sibling::td)[1]")
	WebElement ExpandArrowIcon;
	
	@FindBy(xpath ="(//input[@type='checkbox'])[2]")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[text()='Approve']")
	WebElement approvebtn;
	
	@FindBy(xpath = "(//*[text()='Reject'])[1]")
	WebElement RejectButton;
	
	@FindBy(xpath = "//*[@class='_17CUqmCextOqfytuhqZlM']")
	WebElement RemarksTextArea;
	
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmButton;
	
	public void timesheetmanagement() {
		submitted.click();
	}
	public void selftogggle() {
		showselftoggle.click();
	}
	public void checkbox(String WeekStartDate) {
		driver.findElement(By.xpath("//*[text()='"+WeekStartDate+"']//ancestor::td//preceding-sibling::td[6]/span/input[@id='checkbox_411']")).click();
	}
	public void rejected(String Remarks) {
		rejected.click();
		CommonUtils.sendKeysToElement(remarks, Remarks);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 3);
	}

	public void rejectTimesheet(String empid) {
		WebElement element = driver.findElement(By.xpath(
				"//*[@title='" + empid + "']/following::td[8]/div[1]/button[2][@aria-label='Reject Timesheet']"));
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		CommonUtils.waitFor(2);
		CommonUtils.sendKeysToElement(remarks, "Test");
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(confirm, 10);
		CommonUtils.waitFor(2);
	}
	

	public void EmpRejectedTimesheetandVerify() {
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(RejectedIcon, 10);
		CommonUtils.waitFor(3);
		CommonUtils.explicitlyWaitForElementandClick(showselftoggle, 10);
		CommonUtils.waitFor(2);//
		CommonUtils.explicitlyWaitForElementandClick(ExpandArrowIcon, 10);
		CommonUtils.waitFor(2);
//		String ApprovedText = driver.findElement(By.xpath("//*[@title='" + empid + "']/following::td[4]/div[@title='Rejected']"))
//				.getText();
//		Assert.assertEquals(ApprovedText, "Rejected");
	}
	
	
	public void bulkReject()
	{
		CommonUtils.explicitlyWaitForElementandClick(checkbox, 10);
		CommonUtils.waitFor(2);
	}
	
	public void RejectTimesheetByGivingRemarks(String Remarks) {
		CommonUtils.explicitlyWaitForElementandClick(RejectButton, 2);
		CommonUtils.sendKeysToElement(RemarksTextArea, Remarks);
		CommonUtils.explicitlyWaitForElementandClick(confirmButton, 2);
}
	
}
