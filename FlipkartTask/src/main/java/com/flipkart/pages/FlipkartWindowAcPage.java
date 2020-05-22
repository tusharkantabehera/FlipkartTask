package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class FlipkartWindowAcPage extends Base{

	public FlipkartWindowAcPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='_1HmYoV _35HD7C'][2]/div[3]//descendant::div[@class='_1p7h2j']")
	private WebElement compareCheckbox2;
	
	@FindBy(xpath = "//div[@class='_1HmYoV _35HD7C'][2]/div[4]//descendant::div[@class='_1p7h2j']")
	private WebElement compareCheckbox3;
	
	@FindBy(xpath = "//span[text()='COMPARE']")
	private WebElement compareButton;
	
	public void clickOncompareCheckbox2()
	{
		compareCheckbox2.click();
	}
	
	public void clickOncompareCheckbox3()
	{
		compareCheckbox3.click();
	}
	
	public void clickOnCompare()
	{
		compareButton.click();
	}
}
