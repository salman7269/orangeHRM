package Utility_classes;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class getScreenshot {

	public static String getScreenshot(WebDriver driver) throws IOException
	{
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String path="D://screenshot/"+System.currentTimeMillis()+".jpg";
	File trg= new File(path);
	FileUtils.copyFile(src, trg);
	return path;
		
	}
	
}
