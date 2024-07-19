package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;

public class PA12_AdminCategoryDashboardPage {
	WebDriver driver;

	public PA12_AdminCategoryDashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@title,'CategoryDashboard')]")
	WebElement CategoryMasterIcon;
	
	@FindBy(xpath = "//div[contains(@class,'_2HalwklF3cU-lm_PdTv8QB')]")
	WebElement CategoryMasterName;
	
	public void clickCategoryIcon() {
		CommonUtils.explicitlyWaitForElementandClick(CategoryMasterIcon, 5);
	}
	
	public void printCategoryTitle() {
		String ActualText = CategoryMasterName.getText();
		String ExpectedText = "CategoryDashboard";
        Assert.assertTrue(ActualText.contains(ExpectedText));
		System.out.println("Name of the Page is "+ ActualText );
		
	}

}
