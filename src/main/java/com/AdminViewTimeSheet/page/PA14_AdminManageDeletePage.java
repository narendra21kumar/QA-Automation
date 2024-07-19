package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

public class PA14_AdminManageDeletePage {
	WebDriver driver;

	public PA14_AdminManageDeletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@title,'Manage Delete Employee')]")
	WebElement ManageDeleteIcon;
	
	@FindBy(xpath = "//div[contains(@class,'_3hQdm0lP3uw__0tMSc1ENV')]")
	WebElement ManageDeletePageName;
	
	public void clickManageDeleteIcon() {
		CommonUtils.explicitlyWaitForElementandClick(ManageDeleteIcon, 5);
	}
	
	public void printManageDeleteTitle() {
		String ActualText = ManageDeletePageName.getText();
		String ExpectedText = "Manage Delete Employees";
        Assert.assertTrue(ActualText.contains(ExpectedText));
		System.out.println("Name of the Page is "+ ActualText );
		
	}
}
