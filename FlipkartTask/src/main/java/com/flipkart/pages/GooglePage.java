package com.flipkart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class GooglePage extends Base{

	@FindBy(name = "q")
	private WebElement searchBar;
	
	@FindAll(@FindBy(xpath = "//ul[@class='erkvQe']/li"))
	private List<WebElement> suggestions;
	
	@FindBy(xpath = "//a[@href='https://www.flipkart.com/']/h3[text()='Flipkart']")
	private WebElement flipkartLink;

	public GooglePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterKeyword(String keyword)
	{
		searchBar.sendKeys(keyword);
	}
	
	public List<String> getSuggestions()
	{

		List<String> names = new ArrayList<String>();
		for(int i=0;i < suggestions.size();i++)
		{
			names.add(suggestions.get(i).getText());
		}
		return names;
	}
	public void clickOnFlipkart()
	{
		flipkartLink.click();
	}
	
}
