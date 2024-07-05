package com.AdminViewTimeSheet.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TimeSheet.utils.CommonUtils;

public class PA09_AdminReportsPage {
  static WebDriver driver;
	
	public PA09_AdminReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Reports']")
	WebElement reportsIcon;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[1]")
	WebElement timeSheetSubmittReportDropDown;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[2]")
	WebElement clientDropdown;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[3]")
	WebElement teamDropdown;
	
	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[4]")
	WebElement statusDropdown;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchText;
	
	@FindBy(xpath = "//div[contains(@class, '_1W58ZgnmoLYaB8WLiZ4iEN')][1]")
	WebElement startDateSelectDrop;
 
	@FindBy(xpath = "//div[contains(@class, '_1W58ZgnmoLYaB8WLiZ4iEN')][2]")
	WebElement endDateSelectDrop;
	
	@FindBy(xpath = "//div[@class='rdp-caption_label']")
	WebElement monthYear;
 
	@FindBy(xpath = "//button[@name='previous-month']")
	WebElement previousmonthArrow;
 
	@FindBy(xpath = "//button[@name='next-month']")
	WebElement nextmonthArrow;
	
	@FindBy(xpath = "//ul[@class = 'MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']//li")
	List<WebElement> dropValues; 
	
	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[1]")
	List <WebElement> listOfEmployeeNames;
	
//	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]")
//	List <WebElement>  statusOfEmployeeFromeReports;
	
//	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + nameOfemployee + "']")
//	WebElement  statusOfEmployeeFromeReports;
	 @FindBy (xpath = "//td[@class='MuiTableCell-root' and @value='\" + value + \"']")
	 WebElement nameOfEmp;
	 
	 @FindBy (xpath = "//td[@class='MuiTableCell-root' and @value='\" + value + \"']")
	 WebElement nameOfEmpStatus; 
	
	
	//One Common Method for Selecting Drop down
	public void selectValuesFromDrop(String value) {
		 for(WebElement options : dropValues) {
	  		 if(options.getText().equalsIgnoreCase(value)) {
	  			 options.click();
	  			 break;
	  		 }
	  	 }  	
	}
      /////////////////////////////////////////////////////////////////////////////////////////////////	
	public void clickonReportsIcon() {
		CommonUtils.explicitlyWaitForElementandClick(reportsIcon, 5);
	}
	
	public void selecttimeSheetSubmittReportDropDown(String selectValueFromDrop) {
        CommonUtils.explicitlyWaitForElementandClick(timeSheetSubmittReportDropDown, 10);	
          selectValuesFromDrop(selectValueFromDrop);	
          CommonUtils.waitFor(3); 
	}
	
	public void selectClient(String nameOfClient) {
        CommonUtils.explicitlyWaitForElementandClick(clientDropdown, 10);	
        selectValuesFromDrop(nameOfClient);
        CommonUtils.waitFor(3); 
	}
	
	public void selectTeam(String nameOfTeam) {
        CommonUtils.explicitlyWaitForElementandClick(teamDropdown, 10);	
        selectValuesFromDrop(nameOfTeam);
        CommonUtils.waitFor(3); 
	}
	
	public void selectStatus(String nameOfStatus) {
        CommonUtils.explicitlyWaitForElementandClick(statusDropdown, 10);	
        selectValuesFromDrop(nameOfStatus);
        CommonUtils.waitFor(3); 
	}
	
	public void selectStartDateandMonthforSubmitted(String Startmonth, String Startdate) {
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);
		CommonUtils.waitFor(3); 
		String monthNm = Startmonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
		reqDate.click();
		CommonUtils.waitFor(3); 
	}
	public void selectEndDateandMonthforSubmitted(String EndMonth, String EndDate) {
		CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);
		CommonUtils.waitFor(3); 
		String monthNm = EndMonth.split(" ")[0].trim();
		System.out.println("Req value :" + monthNm);
		CommonUtils.waitFor(2);
		CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
		CommonUtils.waitFor(2);
		WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
		reqDate.click();
		CommonUtils.waitFor(3); 
	}

	public void searchByOption(String text) {
		CommonUtils.sendKeysToElement(searchText, text);
		List <WebElement> getAllStatus = driver.findElements(By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]"));
		for(WebElement getStatus : getAllStatus) {
			System.out.println(getStatus.getText());
			
		}
	}
	
	public void verifyAccordingToSelectedDrop() {
		
	}

	public void verifyFromReports(String EmpName, String Status, String SubDate) {	
	 WebElement nameOfEmp = driver.findElement(By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + EmpName + "']"));
	 WebElement statusOfEmp = driver.findElement(By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + Status + "']"));
	 WebElement dateOfSub = driver.findElement(By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + SubDate + "']"));
      if(nameOfEmp.isDisplayed()) {
    	  System.out.println(nameOfEmp.getText());
    	  if(statusOfEmp.getText().equalsIgnoreCase(Status)) {
    		   System.out.println(statusOfEmp.getText());
    		  if(dateOfSub.getText().equalsIgnoreCase(SubDate)) {
    			  System.out.println(dateOfSub.getText());
    		  }
    	  }
      }
		
	}
	

}
	
