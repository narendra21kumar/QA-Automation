package com.EmployeeViewTimeSheet.page;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PE05_RejectedTimesheetPage {
	WebDriver driver;

	public PE05_RejectedTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class='svg-inline--fa fa-circle-xmark ']")
	WebElement rejectedIcon;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/button[1]//*[name()='svg']")
	WebElement arrowIcontoExpandRecord;
	
	public void ClickOnRejectIcon() {
		CommonUtils.explicitlyWaitForElementandClick(rejectedIcon, 10);
		CommonUtils.waitFor(2);
	}
	
	public void ExpandArrowForVerify() {
		CommonUtils.explicitlyWaitForElementandClick(arrowIcontoExpandRecord, 10);
		String RejectedStatus = driver.findElement(By.xpath("(//*[@title='Rejected'])[2]")).getText();
		Assert.assertEquals(RejectedStatus, "Rejected");
		String Remarksnotes = driver.findElement(By.xpath("(//*[@class='_1XkrSaLk3Ef0R7EUNozhzR'])[2]")).getText();
		Assert.assertEquals(Remarksnotes, "Test");

	}

	}
	
	