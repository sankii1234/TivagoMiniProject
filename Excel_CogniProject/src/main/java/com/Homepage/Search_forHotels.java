package com.Homepage;

import com.Login.*;
import com.DriverSetup.*;
import com.Testcases.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_forHotels extends WebDriverSetup{

	WebDriver driver;
	public Search_forHotels(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement locationbox;
	
	//The location where the hotels to be searched is added to the searchbox 
	public void searchlocation()
	{
		locationbox = driver.findElement(By.id("querytext"));
		locationbox.click();
		locationbox.sendKeys("Mumbai");
		// this is to add the explicit wait 
		WebElement myDynamicElement = (new WebDriverWait(driver, 40))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"suggestion-64981/200\"]/div")));
		
		driver.findElement(By.xpath("//*[@id=\"suggestion-64981/200\"]/div")).click();
	}
	public WebElement checkinbox;
	public WebElement checkoutbox;
	//Function to enter the checkindate 
	public void checkIndate(String checkindate)
	{
		
		
		
		List<WebElement> list1dates=driver.findElements(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div[4]/div[2]/div/table//td"));
		
		
		for(WebElement ele:list1dates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(checkindate))
			{
				ele.click();
				break;
			}
			
		}
		
		
		}
	//Function to enter the checkoutdate
	public void checkOutdate(String checkoutdate)
	{
		/*checkoutbox=driver.findElement(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div[3]/button[3]/span/span"));
		checkoutbox.click();*/
		List<WebElement> list2dates=driver.findElements(By.xpath("//*[@id=\"js-fullscreen-hero\"]/div[1]/form/div[4]/div[2]/div/table//td"));
		
		for(WebElement ele:list2dates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(checkoutdate))
			{
				ele.click();
				break;
			}
			
		}
		
	}
	//this function is to select the required number of rooms to be booked 
	public searchResults NumberofRooms()
	{
		WebElement adultbox=driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/form/button[1]/span"));
		// /html/body/div[4]/div[2]/div[4]/div[1]/form/div[4]/div/div/ul/li[1]/button/div
		driver.findElement(By.cssSelector("li.roomtype-item:nth-child(1) > button:nth-child(1) > div:nth-child(1)")).click();
		driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/form/button[2]")).click();
		/*try {
			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/form/div[4]/fieldset/div/div[1]/div/button[1]")).click();;
			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/form/div[4]/fieldset/ul/li[2]/button")).click();
			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/form/button[2]")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			adultbox.sendKeys(Keys.TAB);
			e.printStackTrace();
		}*/
		
		
		return PageFactory.initElements(driver, searchResults.class);
	}
	
}
