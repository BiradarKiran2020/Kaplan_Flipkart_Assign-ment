package Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import Base.Pojo;
import Pom.FlipkartLoginPom;

public class FlipkartTest extends Pojo {

	public WebDriver driver;
	public FlipkartLoginPom loginPage;

	@BeforeTest
	@Parameters("browser")
	public void lunchBrowser(String browser) throws InterruptedException {

		if (browser.equals("chrome")) {

			driver = openChromeBrowser();

		}

		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");

		// driver.get("https://demoqa.com/droppable");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void loginPage() throws InterruptedException {

		System.out.println("Flipkart page opened");

		String act = driver.getCurrentUrl();
		System.out.println("The current URl " + act);

		String exp = "https://www.flipkart.com/";

		Assert.assertEquals(act, exp);

		System.out.println("The assertion successfull");

	}

	@Test(priority = 2)
	public void mouseHoverOnFashion() throws InterruptedException {

//		WebElement fashion = driver.findElement(By.xpath("(//div[@class='eFQ30H'])[3]"))

		loginPage = new FlipkartLoginPom(driver);

		loginPage.clickOnPopUp();

		System.out.println("Clicked on PopUp");

		Thread.sleep(2000);

		loginPage.hoverFashion();
		Thread.sleep(2000);

		System.out.println("Mouse Hover to the fashion");

		loginPage.hoverKids();
		System.out.println("Mouse Hover to the kids");
		Thread.sleep(2000);

		loginPage.clickOnJeans();
		System.out.println("Mouse Hover to the kids Jeans");
		Thread.sleep(2000);

		loginPage.sortPriceLowToHigh();
		System.out.println("Mouse Hover to the select low to high price");
		Thread.sleep(2000);

		loginPage.selectitem();

		System.out.println("clicked on the first items");
		Thread.sleep(1000);
		Set<String> window = driver.getWindowHandles();

		Iterator<String> it = window.iterator();

		String wind1 = it.next();
		String wind2 = it.next();
		Thread.sleep(1000);
		driver.switchTo().window(wind2);

		System.out.println("Switched to the child window");

		WebElement productText = driver.findElement(By.xpath("//span[@class='B_NuCI']"));

		System.out.println("The text of the first selected  Items " + productText.getText());

		Thread.sleep(1000);

		WebElement productPrice = driver.findElement(By.xpath("//div[@class='_25b18c']"));

		System.out.println("The selling price of the selected  Items " + productPrice.getText());

		Thread.sleep(1000);

		loginPage.toCart();
		Thread.sleep(1000);

		loginPage.ageSelect();
		Thread.sleep(1000);

		loginPage.toCart();
		Thread.sleep(1000);

		System.out.println("Item Added to the Cart");

		WebElement ItemText = driver.findElement(By.linkText("Kcoy Regular Boys Dark Blue Jeans"));

		if (ItemText.equals(productText)) {
			System.out.println("The Text of the selected item is same");
		} else {
			System.out.println("The text is not matching");
		}

		WebElement ItemPrice = driver.findElement(By.xpath("//div[@class='_3LxTgx']"));
		if (ItemPrice.equals(productPrice)) {
			System.out.println("The price is same ");
		} else {
			System.out.println("The price is different");
		}
		// driver.close();
		System.out.println("FlipKart browser closed");
	}

	@Test(priority = 3)
	public void dragDrop() throws InterruptedException {

		Actions action = new Actions(driver);
		System.out.println("navigating to dragdrop page");

		// driver.navigate().to("https://demoqa.com/droppable");
		Thread.sleep(2000);
		// driver.switchTo().frame(1);

		driver.navigate().to("https://demoqa.com/droppable");

		driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']")).click();

		// loginPage.clickonAcceptTab();
		System.out.println("clicked on Accept");

		WebElement drag = driver.findElement(By.id("notAcceptable"));

		System.out.println("Element is dragged");

		WebElement drop = driver.findElement(By.xpath("(//div[@class='drop-box ui-droppable'])[2]"));

		action.dragAndDrop(drag, drop).build().perform();

		// loginPage.toDrop();
		System.out.println("Element is dropped");
		// loginPage.toDrop();

		// driver.close();
		System.out.println("DragDrop browser closed");

	}

	@Test(priority = 4)
	public void naviagation() {

		System.out.println("navigating to alert");
		driver.navigate().to("https://demoqa.com/alerts");
		
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		
		driver.switchTo().alert().accept();
		System.out.println("Clicked Ok on the Alert PopUp");

	//	loginPage.alert();

		System.out.println("clicked on click me");

	}


	
	@Test(priority = 5)
	public void switchWindows() throws InterruptedException {

		driver.navigate().to("https://demoqa.com/browser-windows");
		System.out.println("Navigated to the switchWindowBroswer");
		Thread.sleep(2000);
		
		
	}
	
	
	
	
	 @Test(priority = 6)
		public void naviagate() throws InterruptedException {
			System.out.println("navigating to frames");

			driver.navigate().to("https://demoqa.com/nestedframes");

			System.out.println("open the nested frame window");
			// driver.switchTo().frame(1);
			Thread.sleep(2000);
		//			driver.close();

			System.out.println("Driver closed");

		}

	
			

	@AfterTest
	public void browserClose() {
		
		System.gc();
		driver.quit();
	}

}
