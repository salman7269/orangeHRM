package Test_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_classes.google;
import io.github.bonigarcia.wdm.WebDriverManager;

public class google_test {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		google g= new google(driver);
		g.search();
		
	}

}
