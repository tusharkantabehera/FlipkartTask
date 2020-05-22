package com.flipkart.testCases;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.flipkart.base.Base;
import com.flipkart.pages.FlipkartComparePage;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.pages.FlipkartWindowAcPage;
import com.flipkart.pages.GooglePage;

public class AssignmentTest extends Base{

	GooglePage googlePage;
	FlipkartHomePage homePage;
	FlipkartWindowAcPage windowAcPage;
	FlipkartComparePage comparePage;
	
	@BeforeClass
	public void openUrl()
	{
		Base.initialization();
	} 
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test(priority = 1)
	public void googleSearchTest() throws InterruptedException
	{
		googlePage = new GooglePage();
		googlePage.enterKeyword("Flipkart");
		log.info("Keyword Flipkart Entered");
		Thread.sleep(2000);
		List<String> suggestions = googlePage.getSuggestions();
		for(int i=0;i<suggestions.size();i++)
		{
			System.out.println(suggestions.get(i));
		}
		
		Actions builder = new Actions(driver);  
		builder.sendKeys(Keys.ENTER).build().perform();
		log.info("Enter button Pressed");
		
	}
	
	@Test(priority = 2)
	public void openFlipkart() throws InterruptedException
	{
		googlePage.clickOnFlipkart();
		log.info("Flipkart site opened");
		homePage = new FlipkartHomePage();
		Thread.sleep(2000);
		homePage.quitPopup();
		log.info("Login pop-up closed");
		Thread.sleep(2000);
	}
	
	@Test(priority = 3)
	public void compareProducts() throws InterruptedException
	{
		homePage.clickOnTvAppLink();
		log.info("clicked on TV & Applications category");
		Thread.sleep(2000);
		homePage.clickOnwindowAc();
		windowAcPage = new FlipkartWindowAcPage();
		Thread.sleep(2000);
		windowAcPage.clickOncompareCheckbox2();
		Thread.sleep(2000);
		windowAcPage.clickOncompareCheckbox3();
		Thread.sleep(2000);
		windowAcPage.clickOnCompare();
		
	}
	@Test(priority = 4)
	public void addToCompare() throws InterruptedException
	{
		comparePage = new FlipkartComparePage();
		Thread.sleep(2000);
		comparePage.addAProduct();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void printProductDetails()
	{
		List<String> names = comparePage.getProductsNames();
		for(int i=0;i< names.size();i++)
		{
			System.out.println("Product Name"+(i+1)+":-"+names.get(i));
		}
		
		List<String> prices = comparePage.getProductsPrices();
		for(int i=0;i< prices.size();i++)
		{
			System.out.println("Product Price"+(i+1)+":-"+prices.get(i));
		}
	}
	
}



