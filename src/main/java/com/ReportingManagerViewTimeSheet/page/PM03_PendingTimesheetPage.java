package com.ReportingManagerViewTimeSheet.page;
 
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
 
import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;
 
 
public class PM03_PendingTimesheetPage {
 
	private WebDriver driver;
	private PM01_LoginPage loginPage;
	private PM02_CreateTimeSheetPage createTimesheet;
 
	public PM03_PendingTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;
	//@FindBy(xpath = "//*[text()='188']/ancestor::td//preceding-sibling::td")
	@FindBy(xpath = "//*[text()='188']/ancestor::td//preceding-sibling::td/button")
	
	WebElement arrowIcontoExpandRecord;
 
	public void PendingIconClick() {
		Logs.initLogs(PM01_LoginPage.class.getName());
		Logs.startTestCase(this.getClass().getSimpleName());
		CommonUtils.explicitlyWaitForElementandClick(pendingApprovalIcon, 10);
		Logs.info("Pending approval is clicked");
	}
	public void ExpandArrowtoVerify() {
	CommonUtils.waitFor(3);
	
	try {
		CommonUtils.clickElement(arrowIcontoExpandRecord);
	} catch (Exception e) {
	Logs.error("data is not present",e.getMessage());
	//e.printStackTrace();
	}
	
	//CommonUtils.waitFor(3);
		//CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		String PendingText = driver.findElement(By.xpath("//*[@title='Pending']")).getText();
		Assert.assertEquals(PendingText, "Pending");
	}

}