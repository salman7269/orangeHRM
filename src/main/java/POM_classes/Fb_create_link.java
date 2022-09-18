package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fb_create_link {
WebDriver driver;


   @FindBy(xpath="//*[contains(text(),'Create')]")  private WebElement create;
	
	public Fb_create_link(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void click_createAccount()
	{
		create.click();
	}
}
