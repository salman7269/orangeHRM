package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swaglabs_login {
WebDriver driver;
	@FindBy(xpath="//input[@id='user-name']") private WebElement username;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginButton;
	
	public Swaglabs_login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void username(String user)
	{
		username.sendKeys(user);
	}
	
	public void password(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void loginButton()
	{
		loginButton.click();
	}
	
	
}
