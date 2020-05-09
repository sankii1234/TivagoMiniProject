package com.DriverSetup;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Homepage.Search_forHotels;
import com.Login.LogIntoTrivago;
import com.Testcases.*;


import com.DriverSetup.*;
import com.Login.*;

// This class has all the common functions which are used repeatedly
// Functions from this used to reduce the code and improve the readability
public class WebDriverSetup  {
			
			// Global webdriver is decleared
			public  static WebDriver driver ;
			
			// we can also pass the parameters form testng xml file 
			// But As the per the requirement the values are passed from the excelsheet Using apache poi.
			/*@Test
			@Parameters("browser")*/
			public  void getWebDriver(String browser) // project supports two drivers chrome and firefox from any remote loc , just the required path to be changed 
			{
				try
				{
					if(browser.equalsIgnoreCase("chrome"))  
					{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
					driver = new ChromeDriver();
					}
				}catch(Exception e)
				{
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				try {
					if(browser.equalsIgnoreCase("firefox"))
					{
						System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe" );
						driver = new FirefoxDriver();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			}
			
			//Navigating to the url
			public void openWebsite(String url)  
			{
				driver.navigate().to(url);
			}
			
			//Function to fetch the title
			public String gettitle()
			{
				return driver.getTitle();
			}
			public void takeScreenShoton()
			{
				TakesScreenshot takescreenshot = (TakesScreenshot) driver;
				File sourcefile = takescreenshot.getScreenshotAs(OutputType.FILE);
				
				File destfile = new File("/Excel_CogniProject/OutoutScreenshots"+DateWiseUpdate.getTimeStamp()+".png");
				try {
					FileUtils.copyFile(sourcefile, destfile);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();	
				}
			}
			public static void closeWindow()
			{
				driver.close();
			}
			public static void closeBrowser()
			{
				driver.quit();
			}
			
			
			public WebElement loginLink;
			
			// The page is navigated to the login page 
			public LogIntoTrivago clickloginlink()
			{
				loginLink = driver.findElement(By.xpath("//*[@id='js_navigation']/div/div[1]/button/span"));
				loginLink.click();
				return PageFactory.initElements(driver, LogIntoTrivago.class);
			}
			
			//Additional code to handle the random cookies
//			public void acceptcookie()
//			{
//				By cookies_accept = By.xpath("//*[@id=\"onetrust-policy-text\"]");
//			   // By cookies_gotIt = By.xpath("//a[text()='Got it!']");
//			    WebDriverWait wait = new WebDriverWait(driver, 10);
//			    wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//			    wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));
//			}

			
			
			
}
