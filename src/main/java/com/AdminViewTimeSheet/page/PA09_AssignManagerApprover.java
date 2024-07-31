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

public class PA09_AssignManagerApprover {
	WebDriver driver;
	String sheet = "14th Week";

	public PA09_AssignManagerApprover(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Assign Manager/Approver']")
	WebElement assignMangerIcon;

	@FindBy(id = "clientSelect")
	WebElement selectClient;

	@FindBy(xpath = "//div[@data-value='%s']")
	WebElement selectDropDownValue;

	@FindBy(xpath = "//div[@id ='teamSelect']")
	WebElement selectTeam;

	@FindBy(xpath = "//ul[@class = 'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li")
	List<WebElement> dropValues;
	
	@FindBy(xpath = "//button[@title='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@title='Assign Manager/Approver']")
    WebElement AssignManagerPage;
	
	public void clickAssignManagerIcon() {
		CommonUtils.explicitlyWaitForElementandClick(assignMangerIcon, 5);
		System.out.println("The Name of the Page is :" +AssignManagerPage);
		Logs.info("Clicked on Assign Manager icon");
	}

	// One Common Method for Selecting Drop down
	public void selectValuesFromDrop(String value) {
		for (WebElement options : dropValues) {
			if (options.getText().equalsIgnoreCase(value)) {
				options.click();
				break;
			}
		}
		Logs.info("selected the values form dropdown");
	}

	public void selectClient(String nameOfClient) {
		CommonUtils.explicitlyWaitForElementandClick(selectClient, 10);
		selectValuesFromDrop(nameOfClient);
		Logs.info("Selected the client name");
	}

	public void selectTeam(String nameOfTeam) throws InterruptedException {
		CommonUtils.explicitlyWaitForElementandClick(selectTeam, 5);
		Thread.sleep(3000);
		selectValuesFromDrop(nameOfTeam);
		Logs.info("Selected the Team name");
	}

	public void selectValuesFromManager() throws InterruptedException {
		for (int a = 1; a <= 5; a++) {
			for (int b = 3; b <= 5; b++) {
				WebElement taskdesc = driver.findElement(
						By.xpath("//*[@class='MuiTableBody-root css-1xnox0e']//tr[" + a + "]/td[" + b + "]"));
				taskdesc.click();
				for (int index = 1; index < dropValues.size(); index++) {
					System.out.println("Selecting value at index " + index);
					dropValues.get(index).click();
					// Optionally, wait for dropdown animation
				}

			}
		}
		Logs.info("Selected the Manager name");
	}



   public void  saveRecord() {
	   CommonUtils.waitFor(3);
	   CommonUtils.explicitlyWaitForElementandClick(saveButton, 5);
	   Logs.info("clicked on save icon");
   }

   public void printAssignManagerTitle() {
		String ActualText = AssignManagerPage.getText();
		String ExpectedText = "Assign Manager/Approver";
		Logs.info("Verified Assign Manager Successfully");
       Assert.assertTrue(ActualText.contains(ExpectedText));
		System.out.println("Name of the Page is "+ ActualText );
		
	}
   
}
