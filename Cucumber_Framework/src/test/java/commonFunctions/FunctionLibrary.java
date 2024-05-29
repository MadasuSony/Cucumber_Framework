package commonFunctions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.Assert;

public class FunctionLibrary 
{
	public static WebDriver driver;
	public static Properties conpro;
	//method for launch browser
	public static WebDriver startBrowser() throws Throwable
	{
		conpro = new Properties();
		//load property file here
		conpro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
		if(conpro.getProperty("Browser").equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(conpro.getProperty("Browser").equalsIgnoreCase("Firefox")) 
		{
			driver = new FirefoxDriver();
		}
		else 
		{
			Reporter.log("Browser value is not matching",true);
		}
		return driver;

	}
	//method for launching Url
	public static void openUrl() 
	{
		driver.get(conpro.getProperty("Url"));
	}
	//method for to wait for any webelement in a page 
	public static void waitForElement(String LocatorType, String LocatorValue,String TestData) 
	{
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(TestData)));

		if(LocatorType.equalsIgnoreCase("id"))
		{
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorValue)));
		}
		if (LocatorType.equalsIgnoreCase("name")) 
		{
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LocatorValue)));
		}
		if (LocatorType.equalsIgnoreCase("xpath")) 
		{
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LocatorValue)));
		}
	}	
	//method for any textbox
	public static void typeAction(String LocatorType,String LocatorValue,String TestData)
	{

		if(LocatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(LocatorValue)).clear();
			driver.findElement(By.id(LocatorValue)).sendKeys(TestData);	
		}

		if(LocatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(LocatorValue)).clear();
			driver.findElement(By.name(LocatorValue)).sendKeys(TestData);
		}

		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).clear();
			driver.findElement(By.xpath(LocatorValue)).sendKeys(TestData);
		}
	}
	//method for any buttons,check boxes,radio buttons,links and images 
	public static void clickAction(String LocatorType, String LocatorValue)
	{
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(LocatorValue)).click();
		}
		if(LocatorType.equalsIgnoreCase("id")) 
		{
			driver.findElement(By.id(LocatorValue)).sendKeys(Keys.ENTER);
			
		}
		if(LocatorType.equalsIgnoreCase("name")) 
		{
			driver.findElement(By.name(LocatorValue)).click();
		}
	}
	//method for validate title
	public static void validateTitle(String Expected_Title) 
	{
		String Actual_Title = driver.getTitle();
		try {
			Assert.assertEquals(Actual_Title, Expected_Title,"Title is not matching");		
		}catch(AssertionError a) {
			System.out.println(a.getMessage());
		}
	}
	//method for closing
	public static void closeBrowser() 
	{
		driver.quit();
	}
	//method for generate data format
	public static String generateDate()
	{
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("YYYY_MM_dd hh_mm_ss");
		return df.format(date);
	}
	//method for ListBoxes
	public static void dropDownAction(String LocatorType, String LocatorValue, String TestData)
	{
		if(LocatorType.equalsIgnoreCase("id"))
		{
			//convert testdata string type into integer
			int value = Integer.parseInt(TestData);
			Select Itemselect = new Select(driver.findElement(By.id(LocatorValue)));
			Itemselect.selectByIndex(value);
		}
		if(LocatorType.equalsIgnoreCase("name"))
		{
			//convert testdata string type into integer
			int value = Integer.parseInt(TestData);
			Select Itemselect = new Select(driver.findElement(By.name(LocatorValue)));
			Itemselect.selectByIndex(value);
		}
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			//convert testdata string type into integer
			int value = Integer.parseInt(TestData);
			Select Itemselect = new Select(driver.findElement(By.xpath(LocatorValue)));
			Itemselect.selectByIndex(value);
		}
	}
	//method for capturing stock number into notepad
	public static void captureStock(String LocatorType, String LocatorValue) throws Throwable
	{
		String StockNum = "";
		if(LocatorType.equalsIgnoreCase("name"))
		{
			StockNum = driver.findElement(By.name(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("id"))
		{
			 StockNum = driver.findElement(By.id(LocatorValue)).getAttribute("value");
		}
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
			StockNum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
		}
		//create NotePad
		FileWriter fw = new FileWriter("./CaptureData/StockNumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(StockNum);
		bw.flush();
		bw.close();
	}
	//method validate stock number in table
	public static void stockTable() throws Throwable
	{
		//read stock number from NotePad
		FileReader fr = new FileReader("./CaptureData/StockNumber.txt");
		BufferedReader br = new BufferedReader(fr);
		String Exp_Data = br.readLine();
		//if search TextBox already displayed don't click search panel button
		if(!driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).isDisplayed())
			//if search TextBox not displayed click search panel button
			driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
		//clear text in search TextBox
		driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).clear();
		//enter stock number into search textbox
		driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).sendKeys(Exp_Data);
		driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
		Thread.sleep(3000);
		String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[8]/div/span/span")).getText();
		Reporter.log(Act_Data+"    "+Exp_Data, true);
		try 
		{
			Assert.assertEquals(Act_Data, Exp_Data, "Stock number Should not Match");
		} catch (AssertionError a) 
		{
			Reporter.log(a.getMessage(), true);
		}
	}
		//method for capturing Supplier Number into NotePad
		public static void captureSup(String LocatorType, String LocatorValue)throws Throwable
		{
			String SupplierNum="";
			if(LocatorType.equalsIgnoreCase("xpath"))
			{
				SupplierNum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
			}
			if(LocatorType.equalsIgnoreCase("name"))
			{
				SupplierNum = driver.findElement(By.name(LocatorValue)).getAttribute("value");
			}
			if(LocatorType.equalsIgnoreCase("id"))
			{
				SupplierNum = driver.findElement(By.id(LocatorValue)).getAttribute("value");
			}
			//create NotePad
			FileWriter fw = new FileWriter("./CaptureData/Suppliers.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(SupplierNum);
			bw.flush();
			bw.close();
		}
		//method for validating Supplier Number in table
		public static void supplierTable()throws Throwable
		{
			//read supplier Number into NotePad
			FileReader fr = new FileReader("./CaptureData/Suppliers.txt");
			BufferedReader br = new BufferedReader(fr);
			String Exp_Data = br.readLine();
			if(!driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).isDisplayed())
				driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
				driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).clear();
				driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).sendKeys(Exp_Data);
				driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
				Thread.sleep(3000);
				String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
				Reporter.log(Act_Data+"   "+Exp_Data);
				try 
				{
					Assert.assertEquals(Act_Data, Exp_Data, "Supplier Number Should Not Match");
				} catch (AssertionError e) 
				{
					Reporter.log(e.getMessage(), true);
				}
		}
		//method for capturing customer number in table
		public static void captureCus(String LocatorType, String LocatorValue)throws Throwable
		{
			String CustomerNum="";
			if(LocatorType.equalsIgnoreCase("xpath"))
			{
				CustomerNum = driver.findElement(By.xpath(LocatorValue)).getAttribute("value");
			}
			if(LocatorType.equalsIgnoreCase("name"))
			{
				CustomerNum = driver.findElement(By.name(LocatorValue)).getAttribute("value");
			}
			if(LocatorType.equalsIgnoreCase("id"))
			{
				CustomerNum = driver.findElement(By.id(LocatorValue)).getAttribute("value");
			}
			FileWriter fw = new FileWriter("./CaptureData/Customers.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(CustomerNum);
			bw.flush();
			bw.close();
		}
		//method for validating customer Number in table
		public static void customerTable()throws Throwable
		{
			FileReader fr = new FileReader("./CaptureData/Customers.txt");
			BufferedReader br = new BufferedReader(fr);
			String Exp_Data = br.readLine();
			if(!driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).isDisplayed())
				driver.findElement(By.xpath(conpro.getProperty("search-panel"))).click();
				driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).clear();
				driver.findElement(By.xpath(conpro.getProperty("search-textbox"))).sendKeys(Exp_Data);
				driver.findElement(By.xpath(conpro.getProperty("search-button"))).click();
				Thread.sleep(3000);
				String Act_Data = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
				Reporter.log(Act_Data+"    "+Exp_Data);
				try 
				{
					Assert.assertEquals(Act_Data, Exp_Data, "Customer Number Should Not Match");
				} catch (AssertionError b) 
				{
					Reporter.log(b.getMessage(), true);
				}
		}

	
}