package com.qa.testclass;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ElectronicsClass;
import com.qa.pages.LoginClass;
import com.qa.testbase.BaseClass;

public class LoginClassTest extends BaseClass{
	
	//first call parent class objects by using super() keyword then we can use initialization method
	
	LoginClass loginclass;
	ElectronicsClass electronicsclass;
	
	public LoginClassTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setup()
	{
		initialization();
		//create object for LoginClass then we can use methods of that class
		loginclass=new LoginClass();
	}
	
	@Test(priority=1)
	public void walmartTitleTest()
	{
		String title=loginclass.validatePageTitle();
		System.out.println(title);
		
		//if u want to pass test case remove comments in below
		//Assert.assertEquals(title,"Online Shopping Canada: Everyday Low Prices at Walmart.ca!");
		
		//the below assertion is for getting failed page screenshot we are failing test case by intentionally
		Assert.assertTrue(false);
		
	}
	@Test(priority=2)
	public void validateclickOnMyAccount()
	{
		try
		{
		loginclass.clickOnMyaccount(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("login to myaccount sucessful");
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority=3)
	public void validateElectronicsTest()
	{   
		try
		{
		electronicsclass=loginclass.clickOnElectonics();
		System.out.println("sucessfully clicked on all electronics element");
		
		//String etitle=loginclass.validatePageTitle();
		//System.out.println(etitle);
		//assert.assertEquals(etitle,"Electronics Store in Canada");
		
		}
		catch(Exception e){
			e.printStackTrace();
	}
	}
	
	@AfterMethod()
	public void teardown()
	{
		driver.close();
	}

}
