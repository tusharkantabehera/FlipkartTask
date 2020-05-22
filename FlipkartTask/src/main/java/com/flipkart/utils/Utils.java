package com.flipkart.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.flipkart.base.Base;


public class Utils extends Base{

	public static int PAGE_LOAD_TIMEOUT=15;
	public static int IMPLICITLY_WAIT=20;


	public static void takeScreenshotAtEndOfTest()
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
