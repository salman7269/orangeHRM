package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orangeHRM_homepage {

	WebDriver driver;

	@FindBy(xpath="//span[text()='My Info']") private WebElement myInfo;
	
	public orangeHRM_homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void myInfo()
	{
		myInfo.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
