package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

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

//	@After(order=1)
//	public void takescreenshotAtEndOfTest(Scenario scenario) throws IOException{
//		if(scenario.isFailed())
//		{
//			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//			String currentDir= System.getProperty("user.dir");
//			FileUtils.copyFile(scrFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+".png"));
//		}
//	}
//	
//	@After(order=0)
//	public void teardown()
//	{
//		driver.close();
//	}
	
}
