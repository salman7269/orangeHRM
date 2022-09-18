package Test_classes;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POM_classes.orangeHRM_Login;
import POM_classes.orangeHRM_homepage;
import Thread.orangeHRM_MyInfo;
import Utility_classes.GetDataFromExcel;
import Utility_classes.OpenChrome;
import Utility_classes.getScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class orangeHRM_Test {

WebDriver driver;


@BeforeClass
public void setup()
{
	WebDriver driver=OpenChrome.orangeHRM();
	this.driver=driver;
}
@AfterClass
public void teardown()
{
	driver.quit();
}

@Test(priority=1)
public void login() throws InterruptedException, IOException
{
	
	Thread.sleep(3000);
	orangeHRM_Login login= new orangeHRM_Login(driver);
	Thread.sleep(2000);

	login.username("Admin");
	login.password("admin123");
	login.login();
	String expURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
	String actURL=driver.getCurrentUrl();
	Assert.assertEquals(actURL, expURL);
	getScreenshot.getScreenshot(this.driver);
	Thread.sleep(3000);
}
@Test(priority=2)
public void myInfo() throws InterruptedException
{
	orangeHRM_homepage myInfo= new orangeHRM_homepage(driver);
	myInfo.myInfo();
	Thread.sleep(3000);
}

@Test(priority=3)
public void information() throws InterruptedException
{
	orangeHRM_MyInfo info= new orangeHRM_MyInfo(driver);
	Thread.sleep(3000);
	info.firstname();
	info.middlename();
	info.lastname();
	info.nickname();
	Thread.sleep(2000);
	info.employeeId();
	info.otherid();
	Thread.sleep(2000);
	info.driverLicence();
	info.ssnNumber();
	Thread.sleep(3000);
	info.nationality();
	Thread.sleep(3000);
	info.marital();
	Thread.sleep(2000);
//	info.service();
//	Thread.sleep(3000);
	info.save();
	Thread.sleep(5000);
	
}





	
	
	
	
	
	
	
	
	
	
	
	
}
