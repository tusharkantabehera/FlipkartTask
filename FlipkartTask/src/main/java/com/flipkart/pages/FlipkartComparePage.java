package com.flipkart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class FlipkartComparePage extends Base{
	
public FlipkartComparePage()
{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//div[@class='col-2-5']/div[1]/descendant::div[text()='Choose Brand']")
private WebElement choosBrandLink;

@FindBy(xpath = "//div[@class='LG4KV_']/input[@placeholder='Choose Brand']")
private WebElement enterBrandName;

@FindBy(xpath = "//div[@class='LG4KV_']/div/div[text()='Samsung']")
private WebElement selectBrand;

@FindBy(xpath = "//div[@class='col-2-5']/div[1]/descendant::div[text()='Choose a Product']")
private WebElement choosProductLink;	

@FindBy(xpath = "//div[@class='LG4KV_']/div/div[2]")
private WebElement selectProduct;

@FindAll(@FindBy(xpath = "//div[@class='col-4-5']/descendant::a"))
private List<WebElement> productNames;	

@FindAll(@FindBy(xpath = "//div[@class='col-4-5']/descendant::div[@class='_1vC4OE']"))
private List<WebElement> productPrices;

public void addAProduct() throws InterruptedException
{
	choosBrandLink.click();
	Thread.sleep(2000);
	enterBrandName.sendKeys("Samsung");
	Thread.sleep(2000);
	selectBrand.click();
	Thread.sleep(2000);
	choosProductLink.click();
	Thread.sleep(2000);
	selectProduct.click();
}
public List<String> getProductsNames()
{
	List<String> names = new ArrayList<String>();
	for(int i=0;i<productNames.size();i++)
	{
		names.add(productNames.get(i).getText());
	}
	return names;
}

public List<String> getProductsPrices()
{
	List<String> prices = new ArrayList<String>();
	for(int i=0;i<productPrices.size();i++)
	{
		prices.add(productPrices.get(i).getText());
	}
	return prices;
}
}
