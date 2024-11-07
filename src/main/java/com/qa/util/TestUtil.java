package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.Scenario;
import io.cucumber.java.After;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtil extends TestBase {
	
	static int IMPLICIT_WAIT=20;
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir= System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
	}
	
	public static void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public static void performMenuAction(WebElement menuName)
	{
		Actions action=new Actions(driver);
		action.moveToElement(menuName).build().perform();
	}
	
	//Method to select a window
		public static void selectOpenWindow(String parentWindow,String windowTitle)
		{
			Set<String>openWindows=driver.getWindowHandles();
			Iterator<String> it=openWindows.iterator();
			while(it.hasNext())
			{
				String childWindow=it.next();
				if(!parentWindow.equalsIgnoreCase(childWindow))
				{
					
					driver.switchTo().window(childWindow);
				}
			}
		}
	
	// Function to select a date from calendar
		public static void pickDateFromCalendar(WebElement monthAndYear, String dateToSelect, WebElement yearForward, WebElement monthForward, WebElement monthBackward,WebElement yearBackward ) throws InterruptedException
		{
			String actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
			int intYear=Integer.parseInt(monthAndYear.getText().split(" ")[1].trim());
			int intexpYear=Integer.parseInt(dateToSelect.split("-")[2].trim());
			String expMonthInString=dateToSelect.split("-")[1].trim();
			try
			{
			int intexpMonth=Integer.parseInt(dateToSelect.split("-")[1].trim());
			expMonthInString=monthNumberToFullName(intexpMonth);
			}
			catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
			String expDay= dateToSelect.split("-")[0].trim();
			while(intexpYear>intYear)
			{
				monthForward.click();
				intYear=Integer.parseInt(monthAndYear.getText().split(" ")[1].trim());
				if(intYear==intexpYear)
				{
					break;
				}
			}		
			actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
			while(expMonthInString!=actMonth)
			{
				if(actMonth.equalsIgnoreCase(expMonthInString))
				{
					break;
				}

				monthForward.click();
				actMonth=monthAndYear.getText().split(" ")[0].trim().replace(",", "");
			}
			
			driver.findElement(By.xpath("//td[text()='"+expDay+"']")).click();
		}
		
	// Method to convert month from number to name (String equivalent)
		public static String monthNumberToFullName(int monthNumber) {
			  return Month.of(monthNumber).getDisplayName(TextStyle.FULL, Locale.getDefault());
			}

}
