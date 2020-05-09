package com.Homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverSetup.WebDriverSetup;
import com.Login.*;
import com.Homepage.*;
import com.Testcases.*;


public class searchResults extends WebDriverSetup {
	
	
	public searchResults(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	//This function is to set the price range on the basis of customer requirement 
	//Chrome extension pageRuler is used to get the correct Co-ordinates of the slider
	public WebElement slider;
	public void slide()
	{
		
		slider =driver.findElement(By.xpath("//*[@id='page_wrapper']/section/div/div/ul/li[1]/div/div/div[2]/div[2]"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(slider, -258, 0).perform();

		
	}
	
	//The function returns the number of hotels displayed in the trivago webpage
	// java executor is to scroll down the page
	public void NumberOfHotels_1day() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='js-splitview-map-container']/div/div[2]/button[2]/span[1]")).click();
		
		   Thread.sleep(5000);
		   JavascriptExecutor js = (JavascriptExecutor) this.driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		   js.executeScript("window.scrollBy(0,-550)", "");
		   Thread.sleep(5000);
		   	
		   List<WebElement> number = driver.findElements(By.xpath("//*[@id=\"js_itemlist\"]/li"));
		   System.out.println("Number of Hotels available on Trivago in Mumbai on pageOne is    "+ (number.size()-2));
		   System.out.println("Total number of Hotels available on Trivago in Mumbai is    "+ (number.size()-2)*5);
	}
		

}
