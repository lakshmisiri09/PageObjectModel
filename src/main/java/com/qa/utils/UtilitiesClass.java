package com.qa.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.internal.Utils;

import com.qa.testbase.BaseClass;

public class UtilitiesClass extends BaseClass{
	
	public static long pageloadtime=20;
	public static long implicittime=20;
	
	public static void  getScreenShot(String screenShotName)
	{
		File scr= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String desF=System.getProperty("user.dir")+"/screenshots/"+screenShotName +".PNG";
		
		Utils.copyFile(scr,new File(desF));
		
		
	}

}
