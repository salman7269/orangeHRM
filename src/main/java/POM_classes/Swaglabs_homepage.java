package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swaglabs_homepage {
WebDriver driver;
	@FindBy(xpath="//div[text()='Sauce Labs Bolt T-Shirt']") private WebElement product;
	
	public Swaglabs_homepage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void buying_product()
	{
		product.click();
	}
}
