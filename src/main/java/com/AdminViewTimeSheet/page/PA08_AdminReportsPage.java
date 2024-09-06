package com.AdminViewTimeSheet.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.TimeSheet.utils.CommonUtils;
import com.TimeSheet.utils.Logs;

public class PA08_AdminReportsPage {
	WebDriver driver;

	public PA08_AdminReportsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class, '_2esG8N9N5-Q9Ui8vVn5gZt') and @title='Reports']")
	WebElement reportsIcon;

	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[6]")
	WebElement timeSheetSubmittReportDropDown;

	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[1]")
	WebElement clientDropdown;

	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[2]")
	WebElement teamDropdown;

	@FindBy(xpath = "(//div[contains(@class,'MuiInputBase-root')])[3]")
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
	List<WebElement> listOfEmployeeNames;

	@FindBy(xpath = "//td[@class='MuiTableCell-root' and @value='\" + value + \"']")
	WebElement nameOfEmp;

	@FindBy(xpath = "//td[@class='MuiTableCell-root' and @value='\" + value + \"']")
	WebElement nameOfEmpStatus;

	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-h5 css-1hh6ei4']")
	WebElement AdminReportName;

	// One Common Method for Selecting Drop down
	public void selectValuesFromDrop(String value) {
		for (WebElement options : dropValues) {
			if (options.getText().equalsIgnoreCase(value)) {
				options.click();

				break;
			}
		}
		Logs.info("selected the value form dropdown");
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public void clickonReportsIcon() {
		CommonUtils.explicitlyWaitForElementandClick(reportsIcon, 5);
		Logs.info("clicked on Reports icon");

	}

	public void selectTimeSheetSubmittReportDropDown(String selectValueFromDrop) {
		CommonUtils.explicitlyWaitForElementandClick(timeSheetSubmittReportDropDown, 10);
		selectValuesFromDrop(selectValueFromDrop);
		Logs.info("selected the timeSheetSubmittReport form Dropdown");

	}

	public void selectClient(String nameOfClient) {
		CommonUtils.explicitlyWaitForElementandClick(clientDropdown, 10);
		selectValuesFromDrop(nameOfClient);
		Logs.info("selected the client form Dropdown");

	}

	public void selectTeam(String nameOfTeam) {
		CommonUtils.explicitlyWaitForElementandClick(teamDropdown, 10);
		selectValuesFromDrop(nameOfTeam);
		Logs.info("selected the Team form Dropdown");

	}

	public void selectStatus(String nameOfStatus) {
		CommonUtils.explicitlyWaitForElementandClick(statusDropdown, 10);
		selectValuesFromDrop(nameOfStatus);
		Logs.info("selected the status form Dropdown");

	}

	public void printAdminReportNames() {
		String ActualText = AdminReportName.getText();
		String ExpectedText = "Reports";
		Assert.assertTrue(ActualText.contains(ExpectedText));
		Logs.info("verified the Admin Report Name");
		System.out.println("Name of the Page is " + ActualText);

	}

}

/*
 * 
 * public void clickOnCalendorStartIcon() {
 * CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);
 * Logs.info("clicked on Calender Start Icon"); }
 * 
 * public void clickOnCalendorEndIcon() {
 * CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);
 * Logs.info("clicked on Calender End Icon"); }
 * 
 * public void selectAnyWeek(int weekOffSet, int dayOfWeek) throws
 * InterruptedException { 
 * Calendar cal = Calendar.getInstance();
 * cal.add(Calendar.WEEK_OF_YEAR, weekOffSet); 
 * cal.set(Calendar.DAY_OF_WEEK,dayOfWeek); 
 * int targetDay = cal.get(Calendar.DAY_OF_MONTH); int targetMonth =
 * cal.get(Calendar.MONTH); int currentMonth =
 * Calendar.getInstance().get(Calendar.MONTH);
 * 
 * // Click on the date picker to open it WebElement datePicker =
 * driver.findElement(By.className("rdp-cell")); datePicker.click();
 * CommonUtils.waitFor(3); // If the target month is before the current month,
 * click the previous month // arrow if (targetMonth < currentMonth) {
 * WebElement prevMonthArrow =
 * driver.findElement(By.xpath("//*[@name='previous-month']"));
 * prevMonthArrow.click(); Logs.info("clicked on Previous month arrow"); }
 * 
 * else if (targetMonth > currentMonth) { WebElement nextMonthArrow =
 * driver.findElement(By.xpath("//*[@name='next-month']"));
 * nextMonthArrow.click(); Logs.info("clicked on next month arrow"); } // Select
 * the target day WebElement dayToSelect =
 * driver.findElement(By.xpath("//*[text()='" + targetDay + "']"));
 * dayToSelect.click(); Logs.info("selected the week from calender");
 * 
 * }
 * 
 * 
 * /////////////////////////////////////////////////////////////////////////////
 * //
 * 
 * public void searchByOption(String text) {
 * CommonUtils.sendKeysToElement(searchText, text); List<WebElement>
 * getAllStatus = driver .findElements(By.
 * xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]"))
 * ; for (WebElement getStatus : getAllStatus) {
 * System.out.println(getStatus.getText());
 * 
 * } Logs.info("Fetched all status"); }
 * 
 * public void verifyFromReports(String EmpName, String Status, String SubDate)
 * { WebElement nameOfEmp = driver.findElement(By
 * .xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '"
 * + EmpName + "']")); WebElement statusOfEmp = driver.findElement( By.
 * xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '"
 * + Status + "']")); WebElement dateOfSub = driver.findElement(By
 * .xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '"
 * + SubDate + "']")); if (nameOfEmp.isDisplayed()) {
 * System.out.println(nameOfEmp.getText()); if
 * (statusOfEmp.getText().equalsIgnoreCase(Status)) {
 * System.out.println(statusOfEmp.getText());
 * Logs.info("Verified status successfully"); if
 * (dateOfSub.getText().equalsIgnoreCase(SubDate)) {
 * System.out.println(dateOfSub.getText());
 * Logs.info("Verified dateof Submission successfully"); } } } }
 * 
 * public void VerifyEmpRecordExist(String VerifyempName) throws
 * InterruptedException { List<WebElement> nameOfEmp = driver .findElements(By.
 * xpath("//*[@class='MuiTableBody-root css-1xnox0e']//tr//td[1]")); for
 * (WebElement names : nameOfEmp) { String empName = names.getText(); if
 * (empName.equalsIgnoreCase(VerifyempName)) {
 * System.out.println("Employee Exist in Selected Status");
 * Logs.info("Employee Exist in Selected Status"); } else {
 * System.out.println("Employee not Exist in Selected Status");
 * Logs.info("Employee not Exist in Selected Status"); } break; }
 * 
 * }
 */

//public void selectStartDateandMonthforSubmitted(String Startmonth, String Startdate) {
//CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);
//CommonUtils.waitFor(3);
//String monthNm = Startmonth.split(" ")[0].trim();
//System.out.println("Req value :" + monthNm);
//CommonUtils.waitFor(2);
//CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
//CommonUtils.waitFor(2);
//WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + Startdate + "']"));
//reqDate.click();
//CommonUtils.waitFor(3);
//Logs.info("Selected the start Week and month In reports page");
//}
//
//public void selectEndDateandMonthforSubmitted(String EndMonth, String EndDate) {
//CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);
//CommonUtils.waitFor(3);
//String monthNm = EndMonth.split(" ")[0].trim();
//System.out.println("Req value :" + monthNm);
//CommonUtils.waitFor(2);
//CommonUtils.clickMonthTab(monthNm, nextmonthArrow, previousmonthArrow, monthYear);
//CommonUtils.waitFor(2);
//WebElement reqDate = driver.findElement(By.xpath("//*[text()='" + EndDate + "']"));
//reqDate.click();
//CommonUtils.waitFor(3);
//Logs.info("Selected the End Week and month In reports page");
//}

//public void dateBackward(WebDriver driver, int i) {
//WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
//if (element.isEnabled()) {
//	System.out.println("Element is Displayed easy to select the Data in a given month");
//} else {
//	CommonUtils.explicitlyWaitForElementandClick(previousmonthArrow, 10);
//}
//CommonUtils.explicitlyWaitForElementandClick(element, 10);
//System.out.println("Selected Successfully!!!!!!!!!!!!");
//Logs.info("selected the Week successfully");
//}
//
//public void dateForward(WebDriver driver, int i) {
//WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
//if (element.isEnabled()) {
//	System.out.println("Element is Displayed easy to select the Data in a given month");
//} else {
//	CommonUtils.explicitlyWaitForElementandClick(nextmonthArrow, 10);
//}
//CommonUtils.explicitlyWaitForElementandClick(element, 10);
//System.out.println("Selected Successfully!!!!!!!!!!!!");
//Logs.info("selected the Week successfully");
//}
