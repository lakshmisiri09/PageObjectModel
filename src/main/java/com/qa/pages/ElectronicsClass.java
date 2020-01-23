package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.BaseClass;

public class ElectronicsClass extends BaseClass{
	
	@FindBy(xpath="//span[contains(text(),'Electronics)]")
	WebElement electronicsPage;
	
	@FindBy(xpath="//article[contains(text(),'Top Deals in Electronics')]")
	WebElement topDeals;
	
	//here first take path of rollbak element and then use property parent here parent is label for this parent we have two siblings then take preceding sibling
	@FindBy(xpath="//span[@class='refinement-name' and contains(text(),'Rollback')]//parent::label//preceding-sibling::input")
	WebElement rollbackElement;
	
	@FindBy(xpath="//img[@class='image lazy-img lazy-img-loaded']")
	WebElement headphones;
	
	//first initialize the page objects
	
	public ElectronicsClass()
	{
	     PageFactory.initElements(driver, this);
	}
	
	//write methods for each and every thing for reusability
	
	public String verifyElectronicsPageTitle()
	{
		return driver.getTitle();
	}
	
	public TopDealsPage clickOnTopDeals()
	{
		topDeals.click();
		return new TopDealsPage();
	}
	
	public void clickOnRollback()
	{
		scrollElementIntoView(rollbackElement);
		if(rollbackElement.isDisplayed()) {
		rollbackElement.click();
	}
		else
			System.out.println("rollback element is not found");

}
}
