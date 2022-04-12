package com.Banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.pageObjects.LoginPage;
import com.Banking.utilities.XLUtils;

public class TC_LoginTestDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData")
	public void loginTestDDT(String user,String pwd) throws Exception
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		System.out.println(user +"   " +pwd);
		lp.clickSubmit();
		if(isAlertPresent(driver)==true)
		{
			logger.info("Login Failed");
			captureScreen(driver,"loginTest");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else
		{	
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login Passed");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(true);
			
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getLoginData() throws IOException
	{
		//String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\Banking\\testData\\BankingProject_Testdata.xlsx";
		String path="C:\\Users\\hi\\Selenium\\Banking\\BankingProject_Testdata.xlsx";
		//"C:\Users\hi\Selenium\Banking\BankingProject_Testdata.xlsx";
		int colcount= XLUtils.getCellCount(path, "sheet1", 1);
		System.out.println(colcount);
		int rowcount= XLUtils.getRowCount(path, "sheet1");
		System.out.println(rowcount);
		String data[][]=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
				System.out.println(data[i-1][j]);
			}
		}
		return data;
	}
}
