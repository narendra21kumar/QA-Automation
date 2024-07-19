package com.AdminViewTimeSheet.page;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	List<WebElement> listOfEmployeeNames;

//	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]")
//	List <WebElement>  statusOfEmployeeFromeReports;

//	@FindBy(xpath = "//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + nameOfemployee + "']")
//	WebElement  statusOfEmployeeFromeReports;
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
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public void clickonReportsIcon() {
		CommonUtils.explicitlyWaitForElementandClick(reportsIcon, 5);

	}

	public void selecttimeSheetSubmittReportDropDown(String selectValueFromDrop) {
		CommonUtils.explicitlyWaitForElementandClick(timeSheetSubmittReportDropDown, 10);
		selectValuesFromDrop(selectValueFromDrop);

	}

	public void selectClient(String nameOfClient) {
		CommonUtils.explicitlyWaitForElementandClick(clientDropdown, 10);
		selectValuesFromDrop(nameOfClient);
	
	}

	public void selectTeam(String nameOfTeam) {
		CommonUtils.explicitlyWaitForElementandClick(teamDropdown, 10);
		selectValuesFromDrop(nameOfTeam);
	
	}

	public void selectStatus(String nameOfStatus) {
		CommonUtils.explicitlyWaitForElementandClick(statusDropdown, 10);
		selectValuesFromDrop(nameOfStatus);

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
	///////////////////////////////////////////////////////////////////////////////

	public void clickOnCalendorStartIcon() {
		CommonUtils.explicitlyWaitForElementandClick(startDateSelectDrop, 10);

	}
	
	public void clickOnCalendorEndIcon() {
		CommonUtils.explicitlyWaitForElementandClick(endDateSelectDrop, 10);

	}

	public void DatebackWard(WebDriver driver, int i) {
		WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
		if (element.isEnabled()) {
			System.out.println("Element is Displayed easy to select the Data in a given month");
		} else {
			CommonUtils.explicitlyWaitForElementandClick(previousmonthArrow, 10);
		}
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		System.out.println("Selected Successfully!!!!!!!!!!!!");
	}

	public void DateForward(WebDriver driver, int i) {
		WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
		if (element.isEnabled()) {
			System.out.println("Element is Displayed easy to select the Data in a given month");
		} else {
			CommonUtils.explicitlyWaitForElementandClick(nextmonthArrow, 10);
		}
		CommonUtils.explicitlyWaitForElementandClick(element, 10);
		System.out.println("Selected Successfully!!!!!!!!!!!!");
	}

	public void selectStartDateInCal() throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		cal.add(Calendar.WEEK_OF_MONTH, -2);
		Date pastDate = cal.getTime();
		int date = pastDate.getDate();
		DatebackWard(driver, date);
		System.out.println(pastDate);
	}

	public void selectEndDateInCal() throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		Date future = cal.getTime();
		int date = future.getDate();
		DateForward(driver, date);
		System.out.println(future);
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void searchByOption(String text) {
		CommonUtils.sendKeysToElement(searchText, text);
		List<WebElement> getAllStatus = driver
				.findElements(By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[5]"));
		for (WebElement getStatus : getAllStatus) {
			System.out.println(getStatus.getText());

		}
	}

	public void verifyAccordingToSelectedDrop() {

	}

	public void verifyFromReports(String EmpName, String Status, String SubDate) {
		WebElement nameOfEmp = driver.findElement(By
				.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + EmpName + "']"));
		WebElement statusOfEmp = driver.findElement(
				By.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + Status + "']"));
		WebElement dateOfSub = driver.findElement(By
				.xpath("//*[contains(@class,'MuiTableBody-root css-1xnox0e')]//tr[*]//td[@value= '" + SubDate + "']"));
		if (nameOfEmp.isDisplayed()) {
			System.out.println(nameOfEmp.getText());
			if (statusOfEmp.getText().equalsIgnoreCase(Status)) {
				System.out.println(statusOfEmp.getText());
				if (dateOfSub.getText().equalsIgnoreCase(SubDate)) {
					System.out.println(dateOfSub.getText());
				}
			}
		}

	}

	public void VerifyEmpRecordExist(String VerifyempName) throws InterruptedException {
		List<WebElement> nameOfEmp = driver
				.findElements(By.xpath("//*[@class='MuiTableBody-root css-1xnox0e']//tr//td[1]"));
		for (WebElement names : nameOfEmp) {
			String empName = names.getText();
			if (empName.equalsIgnoreCase(VerifyempName)) {
				System.out.println("Employee Exist in Selected Status");
			} else {
				System.out.println("Employee not Exist in Selected Status");
			}
			break;
		}

	}
	public void selectAnyWeek(int weekOffSet,int dayOfWeek) throws InterruptedException {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, weekOffSet);
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        int targetDay = cal.get(Calendar.DAY_OF_MONTH);
        int targetMonth = cal.get(Calendar.MONTH);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

        // Click on the date picker to open it
        WebElement datePicker = driver.findElement(By.className("rdp-cell"));
        datePicker.click();

        // If the target month is before the current month, click the previous month arrow
        if (targetMonth < currentMonth) {
            WebElement prevMonthArrow = driver.findElement(By.xpath("//*[@name='previous-month']"));
            prevMonthArrow.click();
        }

        else if (targetMonth > currentMonth) {
            WebElement nextMonthArrow = driver.findElement(By.xpath("//*[@name='next-month']"));
            nextMonthArrow.click();
        }
        // Select the target day
        WebElement dayToSelect = driver.findElement(By.xpath("//*[text()='" + targetDay + "']"));
        dayToSelect.click();

    }
	
	 public void printAdminReportNames() {
			String ActualText = AdminReportName.getText();
			String ExpectedText = "Reports";
	       Assert.assertTrue(ActualText.contains(ExpectedText));
			System.out.println("Name of the Page is "+ ActualText );
			
		}
	
}
