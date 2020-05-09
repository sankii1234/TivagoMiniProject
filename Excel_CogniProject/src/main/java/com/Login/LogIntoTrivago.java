package com.Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DriverSetup.WebDriverSetup;
import com.Homepage.Search_forHotels;
import com.Login.LogIntoTrivago;

public class LogIntoTrivago extends WebDriverSetup{
		
		//Constructor is initialized for the driver 
		public LogIntoTrivago(WebDriver driver)
		{
			this.driver=driver;
		} 
		
		public WebElement mailbox;
		public WebElement mailsubmit;
		public WebElement passbox;
		public WebElement submitbox;
		
		//Performing login operation using the provided correct details
		// Used the id and name element whereever it is required 
		// This function will return the refarance of the next page 
		public Search_forHotels Dologin(String emailaddress,String password) throws InterruptedException 
		{
			
			mailbox =driver.findElement(By.id("check_email"));
			mailbox.sendKeys(emailaddress);
			mailsubmit= driver.findElement(By.id("login_email_submit"));
			mailsubmit.click();
			//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			Thread.sleep(3000);
			passbox =driver.findElement(By.id("login_password"));
			passbox.sendKeys(password);
			submitbox =driver.findElement(By.id("login_submit"));
			submitbox.click();
			return PageFactory.initElements(driver, Search_forHotels.class);
		}
}
