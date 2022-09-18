package Test_classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM_classes.orangeHRM_Login;
import Utility_classes.GetDataFromExcel;
import Utility_classes.OpenChrome;
import Utility_classes.getScreenshot;

public class orangeHRM_Test_with_extentReport {
WebDriver driver;
ExtentTest logger;
ExtentReports extent;

	@BeforeClass
	public void Setup()
	{
	WebDriver driver= OpenChrome.orangeHRM();
	this.driver=driver;
	 
	    ExtentHtmlReporter report= new ExtentHtmlReporter("./test-output/Extent_Report.html");
	    extent= new ExtentReports();
	    extent.attachReporter(report);
	    
	    logger=extent.createTest("Test2");
	    logger= extent.createTest("VerifyLogin");
	}
	@Test
	public void VerifyLogin() throws InterruptedException, IOException
	{
		orangeHRM_Login login= new orangeHRM_Login(driver);
		Thread.sleep(2000);
    	login.username(GetDataFromExcel.getdata(1, 0));
    	Thread.sleep(2000);
		login.password(GetDataFromExcel.getdata(1,1));
		Thread.sleep(2000);
        login.login();
        String expURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeLi";
    	String actURL=driver.getCurrentUrl();
        Assert.assertEquals(actURL, expURL);
     }
	@Test(priority=1)
	public void Test2()
	{
		System.out.println("2nd test case is passed");
		Assert.assertTrue(true);
	}
	
	@AfterMethod
	public void failScreenshot(ITestResult result) throws IOException
	{
if(result.getStatus()==ITestResult.FAILURE)
{
	String temp= getScreenshot.getScreenshot(driver);
	logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
}
extent.flush(); 
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
}
