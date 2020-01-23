package com.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
			System.out.println(" the test method execution starts: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The test method sucess:"+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	
		try
		{
			UtilitiesClass.getScreenShot(result.getName());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
