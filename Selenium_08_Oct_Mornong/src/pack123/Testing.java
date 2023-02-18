package pack123;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testing {
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		// Implicit  => Waiting Time => throughout the browser
	
		// 3.141.59                        //deprecated methods 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
		
		//4.0.0
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://www.facebook.com/");
		
		// Implict wait sarat -> on NoSuchElementExcaption 10 sec
		WebElement user = driver.findElement(By.xpath("//input[@id='email']"));
		user.sendKeys("Velocity");
		
		// Explicit Wait   =>  Waiting Time + Condition (Frequency 500mSec of interval)
		                                    // WebDriver, long
		//WebDriverWait wait = new WebDriverWait(driver, 20 ); // 20 Sec
		
		                                             // Maximum waiting time
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25) );	
		                              // Condition                             // 20   10 => 21, 22 , 23 , 26....
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='pass']")));
		password.sendKeys("123234343");

		// Explicit Wait - 500ms
//		2.1sec
//		0Sec    0.5Sec    1Sec    1.5Sec  2 Sec   2.5Sec    -- 400ms loss
		

		//Fluent Wait - 1Sec
//		2.1sec
//		0Sec    1Sec    2Sec   3Sec    -- 900ms loss
		
//		100ms
//		0  100 200 300 400 500 ...... 2000  2100 -- 0ms loss
//		
		
		// Fluent Wait  => Waiting Time + Condition + Frequency 
		
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))      // Maximum Waiting Time 
				.pollingEvery(Duration.ofMillis(100))      // Frequency 
				.ignoring(NoSuchElementException.class);  // Condition       
		
		// Function
		WebElement loginButton = fwait.until(   new Function<WebDriver,WebElement>(){      		
			
			public WebElement apply(WebDriver driver)
			{
				WebElement ele = driver.findElement(By.xpath("//button[@name='logi']"));
				return ele ;
			}
		});
		
		
		
		
		
		
		
		
		
		
		// Delay  ,  Wait
		
		// Delay 
		Thread.sleep(3000);
				
		// atual execute 30 sec +  Delay 20 Sec => 50 sec 
		
		// atual execute 30 sec +  Wait 20 sec => 30 sec to 50 sec
		
		
		// Wait  => Waiting Time, Condition, Frequency 
		
		// Selemium Waits =>  Waiting Time, Condition, Frequency 
		              // permission to change the parameter
		// Implicit  => Waiting Time 
		// Explicit  => Waiting Time, Condition
		// Fluent    => Waiting Time, Condition, Frequency
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// Parameterization 
		
		// How to fetch data from excel sheet 
		
//		String path = "C:\\Users\\akash\\OneDrive\\Desktop\\Test.xlsx" ;
//		
//		// define the path 
//		InputStream file = new FileInputStream(path);
//		
//		                                // Open 
//		String data = WorkbookFactory.create(file).getSheet("Velocity").getRow(4).getCell(1).getStringCellValue();
//		
//		System.out.println(data);
		
//		test1, pass1,
//		test2, pass2,
//		test3, pass3,
//		test4, pass4,

		
		                  // sheet select
//		Sheet sheet = book.getSheet("name of sheet") ;
//		
//		int lastRow = sheet.getLastRowNum();
//		                // select row
//		Row row = sheet.getRow(row number) ;
//		
//		int latCell = row.getLastCellNum();
//		
//		               // cell select
//		Cell cell = row.getCell(cell number) ;
//		 
//		//             data copy 
//		String text = cell.getStringCellValue();
//		
//		double value = cell.getNumericCellValue();
//		
//		Date date = cell.getDateCellValue();
//		
		
//		System.setProperty("Webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (4)\\chromedriver.exe");
//	
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		
//		driver.get("https://www.flipkart.com/");
		
//		Thread.sleep(1000);
		
		// How to capture the screenshot in selenium 
		
//		TakesScreenshot t = (TakesScreenshot)driver ;
		             // visible area of application in the browser
		
//		for(int i = 1 ; i  < 6 ; i ++)
//		{
//			File src = t.getScreenshotAs(OutputType.FILE) ;
//			
//			File dest = new File("C:\\Users\\akash\\OneDrive\\Documents\\Automation\\New folder\\Test"+i+".jpeg");
//			
//			FileHandler.copy(src, dest) ;
//			
//		}
		
		
		// Image name -> random number - google it
		// Test-635463563536
		
		
		// Image name - current date & time - google it -> how to get the system date in java
		// Test- 04-01-2023 10 05 34 
		
		
		
		
		
		
		
		
		
		
		
		// How to handle the HTML Table -> using relative xpath and findElements() method
		
//		List<WebElement> cells = driver.findElements(By.xpath("//table[@id='customers']//td"));
//		
//		int size = cells.size(); // total no of data(WebElement) in collection(List)
//		System.out.println(size);
//		
		//WebElement c1 = cells.get(0);
		
//		for(int i = 0 ; i < cells.size() ; i++)
//		{
//			String text = cells.get(i).getText();
//			System.out.println(text);
//		}
		
		
//		Alfreds Futterkiste, Maria Anders, Germany,
//		Centro comercial Moctezuma, Francisco Chang, Mexico,
//		Ernst Handel, Roland Mendel, Austria,
//		
//		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
//
//		for(int j = 2 ; j < rows.size() ; j++)
//		{
//			
//			List<WebElement> cells = driver.findElements(By.xpath("//table[@id='customers']//tr["+ j +"]//td"));            
//				for(int i = 0 ; i < cells.size() ; i++)
//				{
//					
//					String text = cells.get(i).getText(); // actual result 
//					text.equals(a[i])
//		
//		System.out.println(text+",");
//				}
//		}
//		
		// expeted result => String [] 
		
		//pass
		//fail
		//pass
		//pass
		
		
		
		
		
		
		
		
		
		
//		ArrayList<String> addr = new ArrayList<String>( driver.getWindowHandles() );
//		driver.switchTo().window(addr.get(1)) ; // child browser alwas on index 1
//		
//		// How to handle the iframe
//		
//		//driver.switchTo().frame(2);  // Index 
//		//driver.switchTo().frame("iframeResult");  // attribute value of id attribute 
//		
//		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
//		
//		
//		// Swith from current frame to its iframe
//		driver.switchTo().frame(frame);
//		
//		WebElement tryit = driver.findElement(By.xpath("//button[text()='Try it']"));
//		
//		tryit.click();
//		
//		
//		
//		// Switch from current iframe to its immeditage frame
//		driver.switchTo().parentFrame(); 
//		
//		// switch from any iframe to main page direcly 
//		driver.switchTo().defaultContent();
//	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String a1 = addr.get(0);  // main page 
//		System.out.println(a1);
//		
//		String a2 = addr.get(1);  // line
//		System.out.println(a2);
//		
//		String a3 = addr.get(2); // alert
//		System.out.println(a3);
//		
//		String a4 = addr.get(3); // prompt
//		System.out.println(a4);
//		
//		String a5 = addr.get(4);  // confirm
//		System.out.println(a5);
//		
//		// to switch on child browser popup
//		driver.switchTo().window(a1);
//		Thread.sleep(1000);
//		System.out.println( driver.getCurrentUrl() );
//		
//		driver.switchTo().window(a2);
//		Thread.sleep(1000);
//		System.out.println( driver.getCurrentUrl() );
//		
//		driver.switchTo().window(a3);
//		Thread.sleep(1000);
//		System.out.println( driver.getCurrentUrl() );
//		
//		driver.switchTo().window(a4);
//		Thread.sleep(1000);
//		System.out.println( driver.getCurrentUrl() );
//		
//		driver.switchTo().window(a5);
//		Thread.sleep(1000);
//		System.out.println( driver.getCurrentUrl() );
//		
//		
		
		
		
		
		
		
		
		
		
//		Thread.sleep(3000);
//		
//		// How to handel the Alert popup
//		
//		Alert alt = driver.switchTo().alert();
//		
//		String text = alt.getText();
//		System.out.println(text);
//		
//		alt.accept(); // to click on NO/CANCEL/DISMISS/DENY

//		Thread.sleep(3000);
//		
//		// 2nd alert popup 
//		text = alt.getText();
//		System.out.println(text);
//		
//		alt.accept();
//		
//		
		// 1 . Click on main page without handling alert popup
		// 2 . wire the alert popup code even alert popup is not present on screen
		
		
		
		
		
		// or 
		
		// driver.switchTo().alert().accept();
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		
//		alt.sendKeys(null); // to send the data on Alert popup
//		String text = alt.getText(); // to get the text present on alert popup
//		
		
		
		
		
//	WebElement tryIt = driver.findElement(By.xpath("(//a[text()='Try it Yourself »'])[1]"));
//		
//		
//		Thread.sleep(3000) ;
//		
//		// How to perform the scroll down 	
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver ;
//		
//		// scroll down until target WebElement is not displayed on screen 
//		js.executeScript("arguments[0].scrollIntoView(true);", tryIt); 
//
//		Thread.sleep(1000) ;
//		js.executeScript("window.scrollBy(0,-100);"); 

		
		
		
		
		
		
		
		
		// How to perform drag and drop on browser
		
//		Actions act = new Actions(driver);
//		
//		act.dragAndDrop(link, firstName).build().perform();
//		
//		// OR
//		
//		act.moveToElement(link).clickAndHold().moveToElement(firstName).release().build().perform();
//		
		
		
		
		
		
		
		
//		act.moveToElement(accAndList).perform();
//		Thread.sleep(3000);
//		
//		act.moveToElement(yourOrder).perform();
//		Thread.sleep(3000);
//		
//		act.click().perform();
//		
//		//or
//		
//		act.moveToElement(accAndList).moveToElement(yourOrder).moveToElement(yourOrder).click().build().perform();
//		
		
		
		
		
		
		
		
		
//		act.click();  // Left click 
//		act.doubleClick() ; // Left double click
//		act.contextClick() ;  // Right Click 
//		act.moveToElement(loginButton) ;  // Move mouse pointer to target WebElement
//		act.dragAndDrop(source, target) ; // drag source webelement and drop on target webelement
//	
//		act.build();   // to combine the multiple mouse action in single line
//		act.perform(); // to execute the mouse action on the browser
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		driver.get();
//		WebElement userName = driver.findElement( By.xpath("//input[@type='text']") );
//		
//		
//		userName.sendKeys("xchgvhjbhj");
//		
//		WebElement creatNewAcc = driver.findElement(By.xpath("//a[text()='Create New Account']"));
//		creatNewAcc.sendKeys("");
//		
//		driver.manage().window().maximize();
//		
//		driver.navigate().back();
//		
		
		//String attributeValue = userName.getAttribute("attributeName");
		
//		String attributeValue = userName.getAttribute("aria-label");
//		
//		System.out.println(attributeValue);
		
//		String tagname = userName.getTagName();
//		
//		userName.sendKeys("velocity");
//		
//		Thread.sleep(3000);
//		
//		userName.clear();
//		
//		userName.sendKeys("class");
		
		// used to verify if check box or radio buttons is selected or not
		// true -> check box is selected
		// false -> check box is not selected
		
//		boolean result = custom.isSelected();
//		
//		if(result == true){
//			System.out.println(result);
//			System.out.println("Selected");
//		}
//		else{
//			System.out.println(result);
//			System.out.println("Not Selected");
//			custom.click();
//		}
//		
//		result = custom.isSelected();
//		System.out.println(result);
		
		
		
		
//		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
//		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
//		
//		firstName.sendKeys("Velocity");
//		lastName.sendKeys("class");
		
		
		
	}
}
