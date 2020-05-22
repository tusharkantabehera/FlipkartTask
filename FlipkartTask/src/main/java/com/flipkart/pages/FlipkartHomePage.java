package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class FlipkartHomePage extends Base{
	

	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	private WebElement quitButton;
	
	@FindBy(xpath ="//span[@class='_1QZ6fC _3Lgyp8' and contains(text(),'TVs & Appliances')]")
	private WebElement tvAppLink;
	
	@FindBy(xpath = "//a[@title='Window ACs']")
	private WebElement windowAcLink;
	
	public FlipkartHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void quitPopup()
	{
		quitButton.click();
	}
	public void clickOnTvAppLink()
	{
		tvAppLink.click();
	}
	public void clickOnwindowAc()
	{
		windowAcLink.click();
	}

}
