package org.sample;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebElement element;
	public static Actions obj;
	public static Robot r;
	public static Alert al;
	public static Navigation n;
	public static JavascriptExecutor js;
	public static TakesScreenshot ts;
	public static File f;
	public static Select s;
	public static WebDriverWait w;
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
//	public static void browseLaunch() {
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();

//	}
	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static void currentUrl() {
		String a = driver.getCurrentUrl();
		System.out.println(a);
	}
	
	public static String pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public static void maxBrowser() {
		driver.manage().window().maximize();
	}
	
	public static void pageClose() {
		driver.close();
	}
	
	public static void passText(WebElement element, String txt) {
		element.sendKeys(txt);
	}
	
	public static void buttonLogin(WebElement element) {
		element.click();
	}
	
	public static void pageTxt(WebElement element) {
		element.getText();
	}
	
	public static void attributeValue(WebElement element, String b) {
		String value = element.getAttribute(b);
		System.out.println(value);
	}
	
	public static void moveElement(WebElement element) {
		obj = new Actions(driver);
		obj.moveToElement(element).perform();
	}
	
	public static void dragDrop(WebElement s, WebElement d) {
		obj.dragAndDrop(s , d).perform();
	}
	
	public static void passKeys(WebElement element, String c) {
		obj.sendKeys(element, c).perform();
	}

	public static void pressKeys() {
		obj.keyUp(element, Keys.SHIFT).perform();
	}
	
	public static void releaseKeys() {
		obj.keyDown(element, Keys.SHIFT).perform();
	}
	
	public static void pressButton() {
		obj.doubleClick(element).perform();
	}
	
	public static void rightClick() {
		obj.contextClick(element).perform();
	}
	
	public static void simpleAlert() {
		al = driver.switchTo().alert();
		al.accept();
	}
	
	public static void promptAlert() {
		al.dismiss();
	}
	
	public static void sendAlertText(String textal) {
		al.sendKeys(textal);
	}
	
	public static void txtAlert() {
		al.getText();
	}
	
	public static void enabledOrNot() {
		if (element.isEnabled()) {
			element.click();
			System.out.println("The button is enabled");
		} else {
			System.out.println("The button is not enabled");
		}
	}
	
	public static void displayedOrNot() {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	
	public static void selectedOrNot() {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}
	
	public static void givenUrl(String nurl) {
		n = driver.navigate();
		driver.navigate().to(nurl);
	}
	
	public static void nextPage() {
		driver.navigate().forward();
	}
	
	public static void previousPage() {
		driver.navigate().back();
	}
	
	public static void refreshPage() {
		driver.navigate().refresh();
	}
	
	public static void passValues(String ja) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value',"+ja+")", element);
	}
	
	public static void returnValues(String jr) {
		js.executeScript("return arguments[0].getAttribute("+jr+")", element);
	}
	
	public static void clickScript() {
		js.executeScript("arguments[0].click()", element);
	}
	
	public static void scrollDown() {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollUp() {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	public static void screenShot(String path) throws IOException {
		ts =(TakesScreenshot) driver;
		File so = ts.getScreenshotAs(OutputType.FILE);
		f = new File(path);
		FileUtils.copyFile(so, f);	
	}
	
	public static void selectValue(String val) {
		s = new Select(element);
		s.selectByValue(val);
	}
	
	public static void selectText(String tt) {
		s.selectByVisibleText(tt);
	}
	
	public static void selectIndex(int b) {
		s.selectByIndex(b);
	}
	
	public static void multipleOption() {
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	
	public static void optionsSel() {
		List<WebElement> options = s.getOptions();
		Set<WebElement> s1 = new LinkedHashSet<WebElement>();
		s1.addAll(options);
		for (WebElement web : s1) {
			System.out.println(web.getText());		
		}
	}
	
	public static void allOptions() {
		List<WebElement> allOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allOptions) {
			System.out.println(webElement.getText());
		}
	}
	
	public static void firstOptions() {
		WebElement firstopt = s.getFirstSelectedOption();
		System.out.println(firstopt.getText());
	}
	
	public static void deselectIndex(int i) {
		s.deselectByIndex(i);
	}
	
	public static void deselectValue(String v) {
		s.deselectByValue(v);
	}
	
	public static void deselectText(String t1) {
		s.deselectByVisibleText(t1);
	}
	
	public static void allDeselect() {
		s.deselectAll();
	}	
	
	public static void readSingleData(String sheet, int row, int cell) throws Exception {
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\Entries.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet s = w.getSheet(sheet);
		
		Row r = s.getRow(row);
		
		Cell c = r.getCell(cell);
		
		System.out.println(c);
		
		
		
		
		
	}
	
	public static void readAllData(String shtName) throws Exception {
		
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\Entries.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet s = w.getSheet(shtName);
		
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {	
			
			Row r = s.getRow(i);		
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				
				Cell c = r.getCell(j);			
				
				int ct = c.getCellType();
				
				if (ct==1) {
					
					String v = c.getStringCellValue();
					System.out.println(v);
					
				}else if (DateUtil.isCellDateFormatted(c)) {
					
					Date d = c.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					String va = sdf.format(d);
					System.out.println(va);
					
				}else {
					double x = c.getNumericCellValue();
					long l = (long) x;
					String sl = String.valueOf(l);
					System.out.println(sl);				
				}
			}		
		  
		}

	}
	
	
	public static void createExcel(String fileName, int newRow, int newCell, String values) throws Exception {
		
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\newFolder.xlsx");
		
		Workbook cw = new XSSFWorkbook();
		
		Sheet cs = cw.createSheet(fileName);
		
		Row cr = cs.createRow(newRow);
		
		Cell cc = cr.createCell(newCell);
		
		cc.setCellValue(values);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		cw.write(fos);
		

	}
	
	public static void createCell(String shtName, int row, int newCell, String cellValue) throws Exception {
		
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\newFolder.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook cw = new XSSFWorkbook(fis);
		
		Sheet gs = cw.getSheet(shtName);
		
		Row gr = gs.getRow(row);
		
		Cell cc = gr.createCell(newCell);
		
		cc.setCellValue(cellValue);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		cw.write(fos);  
		
		System.out.println("Its done");

	}
	
	public static void createRow(String shtName, int newRow, int newCell, String cellValue) throws Exception {
		
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\newFolder.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook cw = new XSSFWorkbook(fis);
		
		Sheet gs = cw.getSheet(shtName);
		
		Row cr = gs.createRow(newRow);
		
		Cell cc = cr.createCell(newCell);
		
		cc.setCellValue(cellValue);
		
		FileOutputStream fos = new FileOutputStream(f);
		
		cw.write(fos);  
		
		System.out.println("Its done");
	}
	
	public static void updateOnly(String shtName, int row, int cell, String exValue, String cellValue) throws Exception {
		
		File f = new File("C:\\Users\\Yamuna\\eclipse-workspace\\MavenProject\\ExcelSheet\\newFolder.xlsx");
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook cw = new XSSFWorkbook(fis);
		
		Sheet gs = cw.getSheet(shtName);
		
		Row gr = gs.getRow(row);
		
		Cell gc = gr.getCell(cell);
		
		String stValue = gc.getStringCellValue();
		
		if (stValue.equals(exValue)) {
			
			gc.setCellValue(cellValue);
			
		}
		
		FileOutputStream fos = new FileOutputStream(f);
		
		cw.write(fos);  
		
		System.out.println("Its done");

	}
	

}
