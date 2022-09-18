package Thread;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHRM_MyInfo {
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='firstName']") private WebElement firstname;	
	@FindBy(xpath="//input[@name='middleName']") private WebElement middlename;	
	@FindBy(xpath="//input[@name='lastName']") private WebElement lastname;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement nickname;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]") private WebElement employeeId;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[4]") private WebElement otherid;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[5]") private WebElement driverLicence;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[7]") private WebElement ssnNumber;	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])") private WebElement nationality;	
	@FindBy(xpath="//span[text()='Indian']") private WebElement india;	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[2]") private WebElement marital;	
	@FindBy(xpath="//span[text()='Single']") private WebElement single;	
	//@FindBy(xpath="") private WebElement dob;	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[10]") private WebElement service;	
	@FindBy(xpath="(//button[@type='submit'])[2]") private WebElement save;	
	
	public orangeHRM_MyInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void firstname() throws InterruptedException
	{
		firstname.clear();
		Thread.sleep(2000);
		firstname.sendKeys("Shaikh");
	}
	public void middlename() throws InterruptedException
	{
		middlename.clear();
		Thread.sleep(2000);
		middlename.sendKeys("Salman");
	}
	public void lastname() throws InterruptedException
	{
		lastname.clear();
		Thread.sleep(2000);
		lastname.sendKeys("Rehman");
	}
	public void nickname() throws InterruptedException
	{
		nickname.clear();
		Thread.sleep(2000);
		nickname.sendKeys("Shaikh");
	}
	public void employeeId() throws InterruptedException
	{
		Thread.sleep(1000);
		employeeId.clear();
		employeeId.sendKeys("6532");
	}
	public void otherid()
	
	{
		otherid.clear();
		otherid.sendKeys("321456");
	}
	public void driverLicence()
	{
		driverLicence.clear();
		driverLicence.sendKeys("SAL32156");
	}
	
	public void ssnNumber()
	{
		ssnNumber.clear();
		ssnNumber.sendKeys("SKJ54");
	}
	
	public void nationality() throws InterruptedException
	{
		Thread.sleep(3000);
		nationality.click();
		Thread.sleep(2000);
		india.click();
	}
	
	public void marital() throws InterruptedException
	{
		Thread.sleep(2000);
		marital.click();
		Thread.sleep(2000);
		single.click();
	}
	
	
	public void service() throws InterruptedException
	{
		Thread.sleep(2000);
		service.sendKeys("commando");
	}
	public void save()
	{
		save.click();
	}
	
	
	
	
	
	
}
