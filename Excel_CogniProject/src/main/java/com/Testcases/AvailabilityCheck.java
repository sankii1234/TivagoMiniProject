package com.Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.DriverSetup.*;
import com.Homepage.Search_forHotels;
import com.Homepage.searchResults;
import com.Login.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class AvailabilityCheck extends WebDriverSetup{
	
	//All the elements are declared globally to use in the different testcases in future
	WebDriver driver;
	WebDriverSetup wb =new WebDriverSetup();
	LogIntoTrivago LoginTrivago;
	Search_forHotels hotelsearch;
	searchResults results;
	

	//the parameters are passed through the excelsheet using apache poi 
	//In future if the cutomer needs to update it there is no need to change it in the project, just we have to update it to the TrivagoDetails.xlsx
	
	@Test(priority=1)
	public void bookingTestacaseOne() throws Exception
	{
		File file = new File("/Excel_CogniProject/TrivagoDetails.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("customervalid");
		String browser = sheet.getRow(0).getCell(1).getStringCellValue();
		String url = sheet.getRow(1).getCell(1).getStringCellValue();
		String username =  sheet.getRow(2).getCell(1).getStringCellValue();
		String password =  sheet.getRow(3).getCell(1).getStringCellValue();
		
		wb.getWebDriver(browser);
		wb.openWebsite(url);
		String s= wb.gettitle();
		
		LoginTrivago =wb.clickloginlink();
		Thread.sleep(2000);
		hotelsearch = LoginTrivago.Dologin(username, password);
		hotelsearch.searchlocation();
		hotelsearch.checkIndate("11");
		hotelsearch.checkOutdate("13");
		results =hotelsearch.NumberofRooms();
		results.slide();
		
		results.NumberOfHotels_1day();
		results.takeScreenShoton();
		closeBrowser();
	}
	
	
	
}
