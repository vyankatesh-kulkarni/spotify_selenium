package com.spotify.code;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.qu.utility.ExcelUtility;

public class TC_Spotify_002 extends TestBase {

	@Test(dataProvider = "getData2")
	public void CreateAccount(String email, String conEmail , String password, String displayName  , String year, String month , String day) throws InterruptedException {
		
		driver.get("https://www.spotify.com/in-en/free/");
		
		spotifyPage.getSignUpLink().click();
		
		
		spotifyPage.getemailField().sendKeys(email);
		Thread.sleep(1000);
		
		
		spotifyPage.getConfirmEmail().sendKeys(conEmail);
		Thread.sleep(1000);
		
		
		spotifyPage.getPass().sendKeys(password);
		Thread.sleep(1000);
		
		spotifyPage.getDisName().sendKeys(displayName);
		
		spotifyPage.getYear().sendKeys(year);
		
		spotifyPage.selectMonth(month);
		
		spotifyPage.getDay().sendKeys(day);
		
		
		spotifyPage.getGender().click();
		Thread.sleep(1000);
		
		spotifyPage.getChkbox().click();
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
		Thread.sleep(4000);
	}
	
	@DataProvider
	public String[][] getData2() throws IOException{
		
		String xlPath="C:\\Users\\vyankatesh\\Downloads\\signupSpotifyTestData.xlsx";
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
}
