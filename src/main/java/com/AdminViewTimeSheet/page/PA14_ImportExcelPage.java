package com.AdminViewTimeSheet.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PA14_ImportExcelPage {
	public WebDriver driver;

	public PA14_ImportExcelPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@title='Import Excel']")
	WebElement ImportExcelIcon;
	
	@FindBy(xpath = "//div[text()='Import Excel']")
	WebElement ImportExcelTitle;
	
	
	public void importExcelIocn() {
		CommonUtils.explicitlyWaitForElementandClick(ImportExcelIcon, 10);
	}

	public void printImportExcelPage() {
		System.out.println(ImportExcelTitle.getText());
	}
	
	
}
