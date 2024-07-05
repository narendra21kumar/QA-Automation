package com.AdminViewTimeSheet.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
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


}
