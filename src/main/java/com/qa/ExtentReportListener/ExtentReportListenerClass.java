package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.qa.utils.UtilitiesClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportListenerClass implements IReporter {

	public WebDriver driver;
	//the below class is not available in version 4
	// public ExtentHtmlReporter htmlreporter;

	// variables for classes
	public ExtentReports extent;
	public ExtentTest test;

	// for using those variables first instantiate them by using methods
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub

		// A file separator is a character that is used to separate directory names that
		// make up a path to a particular location
		//here true parameter because extent report already there then it will replace with new report
		extent = new ExtentReports(outputDirectory + File.separator + "extent.html", true);
		
		//or
		//extent=new ExtentReports(System.getProperty("user.dir" + "/test-output/extentreport.html",true);

		for (ISuite suite : suites) {
			String suitename = suite.getName();

			// getting the results for the said suite

			Map<String, ISuiteResult> suiteResults = suite.getResults();

			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();

				buildTestNodes(tc.getPassedTests(), LogStatus.PASS);
				buildTestNodes(tc.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(tc.getSkippedTests(), LogStatus.SKIP);
			}
		}
		//it close connection from extent report
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status)
	{
		
		if(tests.size()>0)
		{
			for(ITestResult result: tests.getAllResults())
			{
				test=extent.startTest(result.getMethod().getMethodName());
		
				test.setStartedTime(getTime(result.getStartMillis()));
			    test.setEndedTime(getTime(result.getEndMillis()));
			    for(String group:result.getMethod().getGroups())
			    
			    	test.assignCategory(group);
			    
			    if(result.getThrowable()!=null)
			    {
			    	//for sending failure message to the logs it give error message
			    	test.log(status,result.getThrowable());
			}else
			{
				test.log(status,"Test" + status.toString().toLowerCase() +"ed");
			}
			    extent.endTest(test);
		}
		}
	
}
	
	private Date getTime(long millis)
	{
		Calendar calender=Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}
}
