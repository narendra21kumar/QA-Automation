package com.TimeSheet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {
	private static WebDriver driver;
	int timeoutInSeconds = 30;
	static Actions act;

	public static void sendKeysToElement(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void scrollIntoelementAndclick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitFor(30);
		explicitlyWaitForElementandClick(element,10);
	}

	public static void scrollUsingTextAndClick(WebDriver driver, String value) {
		WebElement element = driver.findElement(By.xpath("//*[text()='" + value + "']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitFor(3);
		explicitlyWaitForElementandClick(element,10);
	}

	public static void waitFor(int seconds) {// last
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void explicitlyWaitForElementandClick(WebElement element, long waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ConvertStringToWebElementAndClick(WebDriver driver, String value) {
		waitFor(3);
		WebElement element = driver.findElement(By.xpath("//li[text()='" + value + "']"));
		explicitlyWaitForElementandClick(element,10);
		waitFor(3);
	}

	public static void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public static void ScrollTillbottom(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	public static void scrollTillTop(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)", "");
	}

	public static void JavaScriptExecutorClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public static void CalenderSelectWithDate(WebDriver driver, int i) {
		waitFor(3);
		WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
		explicitlyWaitForElementandClick(element, 2);
		waitFor(3);
	}
	public static WebElement convertIntTOWebElement(WebDriver driver, int i) {
		waitFor(3);
		WebElement element = driver.findElement(By.xpath("//*[text()='" + i + "']"));
	     return element;
	}
	public static void Click(WebElement element) {
		element.click();
	}

	public static void taskDesccategoryandEnteringHours(WebDriver driver, String Sheet) throws Exception {
		FileInputStream file = new FileInputStream("TestData/TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(Sheet);
		int size = sheet.getLastRowNum();
		for (int a = 1; a <= size; a++) {
			Row row = sheet.getRow(a);
			for (int x = 1; x <= 1; x++) {
				String Tasktitle = row.getCell(x).getStringCellValue();
				int b = x + 1;
				WebElement taskdesc = driver.findElement(
						By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + b + "]/textarea[1]"));
				sendKeysToElement(taskdesc, Tasktitle);
				CommonUtils.waitFor(1);
			}
			for (int y = 2; y <= 3; y++) {
				String CateSub = row.getCell(y).getStringCellValue();
				int d = y + 1;
				WebElement catsubgry = driver.findElement(
						By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + d + "]//div//div"));
				catsubgry.click();
				ConvertStringToWebElementAndClick(driver, CateSub);

			}
			for (int c = 4; c <= 10; c++) {
				double res1 = row.getCell(c).getNumericCellValue();
				int res = (int) (res1);
				String hours = String.valueOf(res);
				int x = c + 1;
				if (res != 0) {
					WebElement timehours = driver.findElement(
							By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + x + "]/div/div/input"));
					timehours.sendKeys(hours);
				}
			}
		}
		workbook.close();
	}

	public static void edittaskDesccategoryandEnteringHours(WebDriver driver, String Sheet) throws Exception {
		FileInputStream file = new FileInputStream("TestData/TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet(Sheet);
		for (int a = 1; a <= 3; a++) {
			Row row = sheet.getRow(a);
			for (int x = 1; x <= 1; x++) {
				String Tasktitle = row.getCell(x).getStringCellValue();
				int b = x + 1;
				WebElement taskdesc = driver.findElement(
						By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + b + "]/textarea[1]"));
				sendKeysToElement(taskdesc, Tasktitle);
				CommonUtils.waitFor(1);
			}
			for (int y = 2; y <= 3; y++) {
				String CateSub = row.getCell(y).getStringCellValue();
				int d = y + 1;
				WebElement catsubgry = driver.findElement(
						By.xpath("//*[@class='MuiTableBody-root']//tr[" + a + "]/td[" + d + "]//div//div"));
				CommonUtils.waitFor(1);
				catsubgry.click();
				CommonUtils.waitFor(2);
				ConvertStringToWebElementAndClick(driver, CateSub);
				CommonUtils.waitFor(1);
			}
		}
		workbook.close();
	}

	public static String takeScreenshotAtEndOfTest() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/screenshots/" + dateName + ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(source, finalDestination);
		return destination;
	}

	public static void selectAnyWeek(WebDriver driver, int weekOffSet) throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.WEEK_OF_YEAR, weekOffSet);
		int targetDay = cal.get(Calendar.DAY_OF_MONTH);
		int targetMonth = cal.get(Calendar.MONTH);
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);

		// Click on the date picker to open it
		WebElement datePicker = driver.findElement(By.className("rdp-cell"));
		datePicker.click();

		// If the target month is before the current month, click the previous month
		// arrow
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
		WebElement start = driver.findElement(By.xpath("//*[@aria-label='Select Week']/following::label[2]"));
		WebElement end = driver.findElement(By.xpath("//*[@aria-label='Select Week']/following::label[4]"));
		String startdate = start.getText();
		String enddate = end.getText();
		System.out.println(
				"printing the selected start week date " + " : " + startdate + " and end date is " + " : " + enddate);
	}

	public static void printNameOfPages(WebDriver driver) {
		// Array of URLs to visit
		String[] pages = { "https://192.168.1.5/timesheet/list", "https://192.168.1.5/timesheet/pending",
				"https://192.168.1.5/timesheet/detail", "https://192.168.1.5/timesheet/approved",
				"https://192.168.1.5/timesheet/rejected", "https://192.168.1.5/timesheet/reports",
				"https://192.168.1.5/timesheet/mapping", "https://192.168.1.5/timesheet/category",
				"https://192.168.1.5/timesheet/employee", "https://192.168.1.5/timesheet/delete-employee" };
		// Loop through each URL
		for (String page : pages) {
			// Navigate to the page
			driver.get(page);
			// Print the title of the current page
			System.out.println("Page Title: " + driver.getTitle());
			break;
		}
	}

	public static void clickMonthTab(String monthName, WebElement nextArrow, WebElement previousArrow,
	WebElement monthYearElement) {
    while (nextArrow.isEnabled() || previousArrow.isEnabled()) {
	String actualResult = monthYearElement.getText().split(" ")[0].trim();
	System.out.println("Actual result is: " + actualResult);
	int a = Month.valueOf(monthName.toUpperCase()).getValue(); // Returns the position of the month (e.g., May =														// 5)
	int b = Month.valueOf(actualResult.toUpperCase()).getValue();
	if (a < b) {
		previousArrow.click();
	} else if (a > b) {
		nextArrow.click();
	} else if (a == b) {
		System.out.println("No need to click");
		break;
	}
}
}

	
	
	
	
	
	
	
	
	
//	public static void clickElement(WebElement element) {
//	element.click();
//}
	
//	public static void actionsclasssendkeys(WebDriver driver, WebElement element, String text) {
//	act = new Actions(driver);
//	element.clear();
//	act.sendKeys(element, text).perform();
//}

//ASSERTIONS
//public static String getTextFormAlert(WebDriver driver) {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	String message = null;
//	try {
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		message = alert.getText();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return message;
//}

// Accept the Dynamic Alerts
//public static void acceptAlert(WebDriver driver) {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	try {
//		wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//}
	
	
	
	
	
}