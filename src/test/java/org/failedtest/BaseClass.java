package org.failedtest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	public static void launchBrowser(String browsername) {
		switch (browsername) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\krishnan\\eclipse-workspace\\Maven\\src\\test\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\krishnan\\eclipse-workspace\\Maven\\src\\test\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\krishnan\\eclipse-workspace\\Maven\\src\\test\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		default:
			System.err.println("Invalid Browser");
			break;
		}
	}
	public static void launchURL(String launchurl) {
		driver.get(launchurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public static void FillTextBox(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static void btnclick(WebElement e) {
		e.click();
	}
	public static void ScreenShot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File fl = new File(
				"C:\\Users\\krishnan\\eclipse-workspace\\Maven\\src\\test\\resources\\ScreenShot" + imagename + ".png");
		FileUtils.copyFile(src, fl);
	}
	public static void WindowsHandle(int index) {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new LinkedList<>();
		list.addAll(windowHandles);
		driver.switchTo().window(list.get(index));
	}
	public static void Javascrip(String input, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value'," + input + ")", e);
	}
	public static void QuitBrowser() {
		driver.quit();
	}
	public static String exceldata(String sheetname, int rowno, int cellno) throws IOException {
		File fl = new File(
				"C:\\Users\\m vijay\\eclipse-workspace\\mavenProject1\\src\\test\\resources\\Excel\\FrdsDetails.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		// type 1----> String
		// type 0----> number,date
		String value = null;
		if (type == 1) {
			value = cell.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-mmm-yyyy");
				value = sf.format(date);

			} else {
				double db =cell.getNumericCellValue();
				//type casting
				long ln=(long) db;
				value=String.valueOf(ln);

			}
		}
		return value;

	}
	public static void SelectbyIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);		
	}
	public static void Selectbyvalue(WebElement e,String index) {
		Select s=new Select(e);
		s.selectByValue(index);		
	}
	public static void SelectbyVisibleText(WebElement e,String index) {
		Select s=new Select(e);
		s.selectByVisibleText(index);		
	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static String gettext(WebElement e) {
		return e.getText();
	}
	public static String getAttribute(WebElement e,String value) {
		return e.getAttribute(value);
	}

}


