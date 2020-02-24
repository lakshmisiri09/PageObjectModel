/*
 * author sirisha
 */

package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.BaseClass;

public class LoginClass extends BaseClass{
	
	
	//page objects
	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myAccount;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit'][@id='account-signin-btn']")
	WebElement signIn;
	
	@FindBy(xpath="//span[contains(text(),'All electronics')]")
	WebElement electronicsElement;
	
	//initialize page objects with current class constructor
	public LoginClass()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void clickOnMyaccount(String un,String pw)
	{
		//MyAccounts tab is mouse over thats why we are using actions class
		Actions action=new Actions(driver);
		action.moveToElement(myAccount).sendKeys(Keys.DOWN).click().build().perform();
		emailId.sendKeys(un);
		passWord.sendKeys(pw);
		scrollElementIntoView(signIn);
		try {
		signIn.click();
		}catch(Exception e)
		{
			System.out.println("not signed in");
		}
		
		}
	
	 public ElectronicsClass clickOnElectonics() {
		 
		 //the below method scrollElementIntoView written in BaseClass 
		 scrollElementIntoView(electronicsElement);
		 if(electronicsElement.isDisplayed())
		 {
			 electronicsElement.click();
		 }
		 else
		 {
			 System.out.println("element electonics not visible");
		 
		 }
		 //after clicking electronics page will be open that means it land on electronics page thats why this method returns electronics page object
		 return new ElectronicsClass();
		 
	 }
	

}
