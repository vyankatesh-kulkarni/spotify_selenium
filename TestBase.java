package com.spotify.code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class TestBase {
	WebDriver driver;
	
	SpotifyPage spotifyPage;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser, String url)  {
		
		if(Browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\webdriver90\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		}
		
		else if(Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver","C:\\webdriver90\\firefoxdriver.exe");
			
			driver = new ChromeDriver();
			}
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		
		
		spotifyPage = new SpotifyPage(driver);
	}
		
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}

