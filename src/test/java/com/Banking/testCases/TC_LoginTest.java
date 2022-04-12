package com.Banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Banking.pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("Opening the url");
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		System.out.println("input values sent");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			captureScreen(driver,"loginTest");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login failed");
			
		}
		
		
	}

}
