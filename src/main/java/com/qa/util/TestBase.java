package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

public TestBase()
{
	try {
		prop=new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\febin\\eclipse-workspace\\CucumberPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
		
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}
}
public static void initialize()
{
	String projectPath= System.getProperty("user.dir");
	System.out.println(projectPath);
	System.setProperty("webdriver.chrome.driver","C:\\Users\\febin\\eclipse-workspace\\CucumberPOM\\src\\test\\resource\\Driver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
	
	
}
public static void tearDown() {
	driver.close();
}
}
