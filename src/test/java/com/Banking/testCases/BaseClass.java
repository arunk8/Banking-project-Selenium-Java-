package com.Banking.testCases;

import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig rc= new ReadConfig();
	
	public String baseURL=rc.getBaseURL();
	public String userName=rc.getUserName();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		System.out.println("browseeeeeeeeeer"+br);
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
			driver= new ChromeDriver();
		}
		
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(" gett urll 50");
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void teadDown()
	{
		driver.quit();
		System.out.println(" quit 59");
	}
	
	public void captureScreen(WebDriver driver,String testName)throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		System.out.println(path);
		File target= new File(path);
		FileUtils.copyFile(source, target);
		
	}
	
	public Boolean isAlertPresent(WebDriver driver) throws Exception
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException ex) {
			return false;
		}
	}
}
//User ID :	mngr395282
//Password :	sEdYpuh