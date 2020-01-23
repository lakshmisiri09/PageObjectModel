package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.utils.UtilitiesClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	//BaseClass constructor used to initialize properties object to config variable from config.properties file
	
	public BaseClass() {

		try {
			 prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
					
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//initialize the browsers
	
	public static void initialization()
	{
	        String browsername=prop.getProperty("browser");
	        if(browsername.equals("chrome"))
	        {
	        	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	        	driver=new ChromeDriver();
	        }
	        else if (browsername.equals("firefox"))
	        {
	               driver=new FirefoxDriver();	
	        }
	        
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().implicitlyWait(UtilitiesClass.implicittime,TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(UtilitiesClass.pageloadtime, TimeUnit.SECONDS);
	        
	        driver.get(prop.getProperty("url"));
	        
	}
	
	public void scrollElementIntoView(WebElement element)
	{
		//WebElement element=driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
	
}