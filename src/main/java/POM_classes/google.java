package POM_classes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class google {
WebDriver driver;

	@FindBy(name = "q")
	private WebElement search;
	
	public google(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void search()
	{
		search.sendKeys("Velocity Pune", Keys.ENTER);
	}
	
	
	
	
}
