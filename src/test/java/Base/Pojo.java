package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pojo {
	
	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:/ChromeDriver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
		return driver;

	}


}
