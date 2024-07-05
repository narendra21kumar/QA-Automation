package com.AdminViewTimeSheet.page;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
 
public class Admin_BulkRejection_Page {
	WebDriver driver;
	public Admin_BulkRejection_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath = "//div[contains(@class, '_1PlWXS4_EMHgqB5ngxCevb')][1]")
	WebElement startDateSelectDrop;
 
	@FindBy(xpath = "//div[contains(@class, '_1PlWXS4_EMHgqB5ngxCevb')][2]")
	WebElement endDateSelectDrop;
	
	@FindBy(xpath = "//*[@placeholder='Search by name...']")
	WebElement searchByname;
	
	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-root MuiCheckbox-colorPrimary css-zun73v'])[1]/input")
	WebElement SelectAll;
	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-root MuiCheckbox-colorPrimary css-zun73v'])[2]/input")
	WebElement uncheck1stIndex;
	
	@FindBy(xpath = "(//*[text()='Reject'])[1]")
	WebElement RejectButton;
	
	@FindBy(xpath = "//*[@class='_17CUqmCextOqfytuhqZlM']")
	WebElement RemarksTextArea;
	
	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmButton;
	
	public void selectDate(int start,int end) {
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 2);
		CommonUtils.CalenderSelectWithDate(driver,start);
		CommonUtils.waitFor(2);
		CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 2);
		CommonUtils.CalenderSelectWithDate(driver,18);
	}
	public void SearchByname(String name) {
		CommonUtils.sendKeysToElement(searchByname, name);
		CommonUtils.waitFor(2);
		CommonUtils.JavaScriptExecutorClick(driver, SelectAll);
	}
	public void RejectTimesheetByGivingRemarks(String Remarks) {
		CommonUtils.explicitlyWaitForElementandClick(RejectButton, 2);
		CommonUtils.sendKeysToElement(RemarksTextArea, Remarks);
		CommonUtils.explicitlyWaitForElementandClick(confirmButton, 2);
}
	public void RejectTimesheetWithOutGivingRemarksAndalidation(String validation) {
		CommonUtils.explicitlyWaitForElementandClick(RejectButton, 2);
		CommonUtils.explicitlyWaitForElementandClick(confirmButton, 2);
		String ValidationError =driver.findElement(By.xpath("//*[text()='"+validation+"']")).getText();
		System.out.println(ValidationError);
		Assert.assertEquals(ValidationError,validation );
}
}
