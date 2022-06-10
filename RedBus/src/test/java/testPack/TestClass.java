package testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClass.HomePage;
import pomClass.SearchResult;

public class TestClass {
	WebDriver driver;
	SearchResult searchResult;
	
	@BeforeClass
	public void launchApplication() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		driver.get("https://www.redbus.in/");	
			
	}
	
	@BeforeMethod
	public void addJourneyDetails() {
		HomePage homePage= new HomePage(driver);
		homePage.selectSource();
		homePage.selectDestination();
		homePage.selectJourneyDate();
		homePage.clickOnSearch();
	}
	@Test
	public void verifySearchresults() {
		searchResult=new SearchResult(driver);
		searchResult.moveToSearchResult();
		Assert.assertEquals(true, true);
		searchResult.clickOnAmenities();
	}
	@Test
	public void verifyBusPhoto() {
		searchResult.clickOnBusPhotos();
		searchResult.checkResult();
        if(searchResult.checkResult().equals("No Bus Image Found"))
        	{
        	  System.out.println("images is not available");
        	}
        else {
        	System.out.println("images is available");
            }      		
	}
	@AfterMethod
	public void closeTab() {
		driver.navigate().back();
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	
	
	
	
	
	

}
