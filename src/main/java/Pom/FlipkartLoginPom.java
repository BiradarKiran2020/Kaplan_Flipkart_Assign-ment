package Pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartLoginPom {
	WebDriver driver;
	Actions action;
	
	Alert alertPopUp;
 
	@FindBy(xpath ="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement LoginPopUp;

	@FindBy(xpath ="(//div[@class='xtXmba'])[3]")
	private WebElement fashionDeals;

	@FindBy(linkText = "Kids")
	private WebElement Kids;
	
	@FindBy(linkText = "Boys & Girls Jeans")
	private WebElement KidsJeans;
	
	@FindBy(xpath = "(//div[@class='_10UF8M'])[1]")
	private WebElement PriceSort;
  
	@FindBy(xpath="(//div[@class='_3ywSr_'])[1]")
    private WebElement Anyitem;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
    private WebElement addtocart;
	
	@FindBy(xpath="//li[@id='swatch-0-size']")
    private WebElement selectAge;
	
	@FindBy(xpath="//a[@id='droppableExample-tab-accept']")
    private WebElement AcceptTab;

	
	@FindBy(id="notAcceptable")
    private WebElement Dragable;

	@FindBy(xpath="(//div[@class='drop-box ui-droppable'])[2]")
    private WebElement Dropable;
	
	
	@FindBy(xpath="//button[@id='alertButton']")
	private WebElement AlertPop;

	
	
	public FlipkartLoginPom(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
	

	}

	public void clickOnPopUp() {
		LoginPopUp.click();
	}

	public void hoverFashion() {
	    action=new Actions(driver);
		action.moveToElement(fashionDeals).build().perform();

	}
   

	public void hoverKids() {
		 action=new Actions(driver);
		action.moveToElement(Kids).build().perform();

	}
	
	public void clickOnJeans() {
		KidsJeans.click();
		
	}
	
	public void sortPriceLowToHigh() {
		PriceSort.click();
	}
	
	public void selectitem() {
		Anyitem.click();
	}
	
	public void toCart() {
		addtocart.click();
	}
	
	public void ageSelect() {
		selectAge.click();
	}
	
	public void clickonAcceptTab() {
		AcceptTab.click();
	}
	
//	public void drag() {
//		Dragable.click();
//	
//	}
//	
//
//	   public void clickonDrag() {
//		   Dragable.click();
//	}
//

	   public void toDrop() {
		//   Dropable.click();
		   Actions action=new Actions(driver);
		   
		   action.dragAndDrop(Dragable, Dropable).build().perform();
	   }

	public void alert() {
		AlertPop.click();
	}

}