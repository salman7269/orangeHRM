package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHRM_Login {
WebDriver driver;

	@FindBy(xpath="//input[@name='username']") private WebElement user;
	@FindBy(xpath="//input[@name='password']") private WebElement pass;
	@FindBy(xpath="//button[@type='submit']") private WebElement login;
	
	
	public orangeHRM_Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void username(String urName)
	{
		user.sendKeys(urName);
	}
	public void password(String urPass)
	{
		pass.sendKeys(urPass);
	}
	public void login()
	{
		login.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
