package POM_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Fb_create_link_page {
WebDriver driver;
@FindBy(xpath="//input[@name='firstname']")  private WebElement firstname ;
@FindBy(xpath="//input[@name='lastname']")  private WebElement lastname ;
@FindBy(xpath="//input[@name='reg_email__']")  private WebElement email ;
@FindBy(xpath="//input[@name='reg_passwd__']")  private WebElement new_pass ;
@FindBy(xpath="//select[@id='day']")  private WebElement DOB_day;
@FindBy(xpath="//select[@id='month']")  private WebElement DOB_month;
@FindBy(xpath="//select[@id='year']")  private WebElement DOB_year;
@FindBy(xpath="(//button[@type='submit'])[2]")  private WebElement signup;
	
	public Fb_create_link_page (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void firstname(String first)
	{
		firstname.sendKeys(first);
	}
	public void lastname(String last)
	{
		lastname.sendKeys(last);
	}
	public void email(String emails)
	{
		email.sendKeys(emails);
	}
	public void new_password(String pass)
	{
		new_pass.sendKeys(pass);
	}
	public void DOB_day(int day)
	{
		DOB_day.sendKeys(Integer.toString(day));
		
	}
	public void DOB_month(String month)
	{
		DOB_month.sendKeys((month));
	}
	public void DOB_year(int year)
	{
		DOB_year.sendKeys(Integer.toString(year));
	}
	
	public void signup()
	{
		signup.click();
	}
}
