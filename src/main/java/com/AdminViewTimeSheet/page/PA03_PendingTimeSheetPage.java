package com.AdminViewTimeSheet.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

public class PA03_PendingTimeSheetPage {
	WebDriver driver;
	public PA03_PendingTimeSheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Pending Approval']")
	WebElement pendingApprovalIcon;
	@FindBy(xpath = "//button[contains(@class, 'MuiIconButton-sizeMedium') and @aria-label='Detail panel visibility toggle']")
	WebElement arrowIcontoExpandRecord;
 
	
	public void clickOnPendingTimesheetIcon() {
		CommonUtils.explicitlyWaitForElementandClick(pendingApprovalIcon, 10);
		CommonUtils.waitFor(3);
	}
//	public void ExpandArrowtoVerify(String WeekStartDate) {
//		WebElement weekstartdateArrowIcon=driver.findElement(By.xpath("(//*[text()='" + WeekStartDate+ "']//preceding-sibling::td)[1]"));
//		weekstartdateArrowIcon.click();
//		CommonUtils.waitFor(3);
//		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
//		String PendingText = driver.findElement(By.xpath("(//*[text()='" + WeekStartDate+ "']//preceding-sibling::td)[6]")).getText();
//		Assert.assertEquals(PendingText, "Pending");
//		CommonUtils.waitFor(3);
//	}
	
	public void ExpandArrowtoVerify() throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		String PendingText = driver.findElement(By.xpath("//*[@title='Pending']")).getText();
		Assert.assertEquals(PendingText, "Pending");
	}
}
