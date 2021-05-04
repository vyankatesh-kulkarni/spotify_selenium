package com.spotify.code;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.qu.utility.ExcelUtility;

public class TC_Spotify_001 extends TestBase{
	
	@Test(dataProvider = "getData")
	public void LoginToAccount(String username , String password) throws InterruptedException {
		
		if(spotifyPage.getPageTitle().contains("Play free on mobile  - Spotify") == false ) {
			spotifyPage.goToHomePage();
		}
		
		
		spotifyPage.getloginLink().click();
		
		Thread.sleep(1500);
		
		spotifyPage.getUsername().clear();
		spotifyPage.getUsername().sendKeys(username);
		
		spotifyPage.getPassword().clear();
		spotifyPage.getPassword().sendKeys(password);
		
		
		
		Thread.sleep(2000);
		
		spotifyPage.getPassword().sendKeys(Keys.ENTER);
		
		Thread.sleep(8000);
		
		String title = spotifyPage.getPageTitle();
		System.out.println(title);
		
		Actions action = new Actions(driver);
		if (title.contains("Account overview")) {
			spotifyPage.getPremiumLink().click();
			Thread.sleep(4000);
			action.moveToElement(spotifyPage.getProfileIcon()).click().perform();
			//spotifyPage.getProfileIcon().click();
			Thread.sleep(4000);
			spotifyPage.getLogoutText().click();
			
			Thread.sleep(4000);
		
		}
	
		
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException{
		
		String xlPath="C:\\Users\\vyankatesh\\Downloads\\spotifyTestData.xlsx";
		String xlSheet = "Sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		 
		String [][] data = new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			}
		}
		return data;
		
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	
}
