package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResult {
	WebDriver driver;
	
	@FindBy (xpath="(//div[@class='clearfix bus-item'])[1]")
	private WebElement searchResult;
	
	@FindBy (xpath="//span[text()='Amenities']")
	private WebElement amenities;
	
	@FindBy (xpath="(//span[text()='Bus Photos'])[1]")
	private WebElement busPhotos;
	
	@FindBy (xpath="//div[text()='No Bus Image Found']")
	private WebElement busPhtotsReult;
	
	
	public SearchResult(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	public void moveToSearchResult() {
		Actions act=new Actions(driver);
		act.moveToElement(searchResult).perform();
		amenities.isDisplayed();
	}
	
	public void clickOnAmenities() {
		amenities.click();
	}
	
	public void clickOnBusPhotos() {
		busPhotos.click();
	}
	
	public String checkResult() {
		String result=busPhtotsReult.getText();
		return result;
		
	}
	

	

}
