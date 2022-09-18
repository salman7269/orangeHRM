package Test_classes;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM_classes.Swaglabs_homepage;
import POM_classes.Swaglabs_login;
import Utility_classes.GetDataFromExcel;
import Utility_classes.OpenChrome;
import Utility_classes.getScreenshot;

public class swagLab {
WebDriver driver;
ExtentReports extent;
ExtentTest logger;
	@BeforeClass
	public void setup()
	{
	  WebDriver driver= OpenChrome.SwagLab();
	  this.driver=driver;
	  
	  ExtentHtmlReporter report= new ExtentHtmlReporter("./test-output/SwagLab_Report.html");
	   extent= new ExtentReports();
	   extent.attachReporter(report);
	   logger= extent.createTest("VerifyLogin");
	   logger=extent.createTest("BuyProduct");
	}
	
	@AfterClass
	public void teardown()
	{
	 driver.quit();
	}
	
	@Test
	public void VerifyLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Swaglabs_login login= new Swaglabs_login(this.driver);
		Thread.sleep(2000);
		login.username(GetDataFromExcel.get_SwagLabs_data(1, 0));
		login.password(GetDataFromExcel.get_SwagLabs_data(1, 1));
		Thread.sleep(2000);
		login.loginButton();
		Thread.sleep(3000);
		String expURL="https://www.saucedemo.com/invento.html";
		String actURL=driver.getCurrentUrl();
		
		Assert.assertEquals(actURL, expURL, "Url is not matching");
	}
	
	@Test(priority=1)
	public void BuyProduct()
	{
		Swaglabs_homepage buy= new Swaglabs_homepage(driver);
		buy.buying_product();
	}
	
	@AfterMethod
	public void failedTestScreenshot(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE);
		{
			String temp= getScreenshot.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	}
	
	
	
	
}
