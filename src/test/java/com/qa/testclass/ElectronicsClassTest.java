package com.qa.testclass;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.ElectronicsClass;
import com.qa.pages.LoginClass;
import com.qa.testbase.BaseClass;

import junit.framework.Assert;

public class ElectronicsClassTest extends BaseClass{
	
	LoginClass loginclass;
	ElectronicsClass electronicsclass;
	
	
	
	//first create constructor for the class through which we can call parent class constructor for initializing elements ex: getting properties
	
	public ElectronicsClassTest()
	{
		super();
	}
	
	//here initialize browser
	
	//in before method only we are going to login because here we are validating electronics page
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginclass=new LoginClass();
				try {
		loginclass.clickOnMyaccount(prop.getProperty("username"),prop.getProperty("password"));
		
		//electronicsclass=loginclass.clickOnElectonics();
		}catch(Exception e)
		{
			System.out.println("not allowed to sigin");
		}
	
		
	}
	
	@Test
	public void validateElectronicsPageTitle()
	{
		String ETitle=electronicsclass.verifyElectronicsPageTitle();
		System.out.println(ETitle);
		Assert.assertEquals(ETitle, "Electronics Store in Canada","electronics page title not found");
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}

}
