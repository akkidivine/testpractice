package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy (xpath="//input[@id='src']")
	private WebElement source ;
	
	@FindBy (xpath="//input[@id='dest']")
	private WebElement destination ;
	
	@FindBy (xpath="//input[@id='onward_cal']")
	private WebElement date ;
	
	@FindBy (xpath="//button[text()='Search Buses']")
	private WebElement search ;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void selectSource() {
		source.sendKeys("Mumbai");
	}
	
	public void selectDestination() {
		destination.sendKeys("Delhi");
	}
	
	public void selectJourneyDate() {
		date.sendKeys("14-Jun-2022");
	}
	
	public void clickOnSearch() {
		search.click();
	}

}
