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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import POM_classes.Fb_create_link;
import POM_classes.Fb_create_link_page;
import Utility_classes.GetDataFromExcel;
import Utility_classes.OpenChrome;
import Utility_classes.getScreenshot;

public class Facebook_Test {
WebDriver driver;
ExtentReports extent;
ExtentTest logger;

@BeforeClass
public void Setup()
{
	WebDriver driver=OpenChrome.Facebook();
	this.driver=driver;
	ExtentHtmlReporter report= new ExtentHtmlReporter("./test-output/Facebook.html");
	   extent= new ExtentReports();
	   extent.attachReporter(report);
	   logger=extent.createTest("open_createAccount_page");
	   logger= extent.createTest("Fill_information");
	   logger= extent.createTest("Click_SignUP");
}
@AfterClass
public void TearDown()
{
	driver.quit();
}
@Test(priority=1)
public void open_createAccount_page() throws InterruptedException, EncryptedDocumentException, IOException
{
	Fb_create_link click= new Fb_create_link(driver);
	click.click_createAccount();
	Thread.sleep(2000);
}
@Test(priority=2)	
public void Fill_information() throws EncryptedDocumentException, IOException, InterruptedException	
{
	Fb_create_link_page page= new Fb_create_link_page(driver);
	page.firstname(GetDataFromExcel.get_Facebook_Data(1, 0));
	page.lastname(GetDataFromExcel.get_Facebook_Data(1, 1));
	page.email(GetDataFromExcel.get_Facebook_Data(1, 2));
	page.new_password(GetDataFromExcel.get_Facebook_Data(1, 3));
	Thread.sleep(2000);
	page.DOB_day(GetDataFromExcel.get_Facebook_Data2(1, 4));
	Thread.sleep(2000);
	page.DOB_month(GetDataFromExcel.get_Facebook_Data(1, 5));
	Thread.sleep(2000);
	page.DOB_year(GetDataFromExcel.get_Facebook_Data2(1, 6));
}
@Test(priority=3)
public void Click_SignUP()
{
	Fb_create_link_page page= new Fb_create_link_page(driver);
	page.signup();
	Assert.fail(); //purposely failing the test case to validate the failed screenshot
}
@AfterMethod
public void FailTestCaseScreenshot(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		String temp= getScreenshot.getScreenshot(driver);
		logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	}
	extent.flush();
}	
}
