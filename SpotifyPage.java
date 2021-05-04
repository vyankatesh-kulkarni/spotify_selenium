package com.spotify.code;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SpotifyPage {
WebDriver driver;
String url;
	
	public SpotifyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	// Signup methods  ///////////////
	
	@FindBy(xpath="/html/body/div[2]/div[1]/header/div/nav/ul/li[5]")
	WebElement signUpLink;
	
	public WebElement getSignUpLink() {
		return signUpLink;
	}
	
	@FindBy(id="email")
	WebElement emailField;
	
	public WebElement getemailField() {
		return emailField;
	}
	
	
	
	@FindBy(id="confirm")
	WebElement confirmEmail;
	
	public WebElement getConfirmEmail() {
		return confirmEmail;
	}
	
	@FindBy(id="password")
	WebElement pass;
	
	public WebElement getPass() {
		return pass;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/div/form/fieldset/div/div[1]/label/span[2]")
	WebElement gender;
	
	public WebElement getGender() {
		return gender;
	}
	
	@FindBy(xpath="//*[@id=\"__next\"]/main/div[2]/div/form/div[6]/div/label")
	WebElement chkbox;
	public WebElement getChkbox() {
		return chkbox;
	}
	
	@FindBy(id="displayname")
	WebElement disName;
	public WebElement getDisName() {
		return disName;
	}
	
	@FindBy(id="year")
	WebElement year;
	public WebElement getYear() {
		return year;
	}
	
	@FindBy(id="month")
	WebElement month;
	
	public WebElement getMonth() {
		return month; 
	}
	
	public void selectMonth(String value) {
		Select selMonth = new Select(getMonth());
		selMonth.selectByVisibleText(value);
	}
	
	
	
	@FindBy(id="day")
	WebElement day;
	public WebElement getDay() {
		return day;
	}
	
	/// login methods ////////////////////////
	
	@FindBy(xpath="/html/body/div[2]/div[1]/header/div/nav/ul/li[6]/a")
	WebElement loginLink;
	
	public WebElement getloginLink() {
		return loginLink;
	}
	
	@FindBy(id="login-username")
	WebElement username;
	
	public WebElement getUsername() {
		return username;
	}
	
	@FindBy(id="login-password")
	WebElement password;
	
	public WebElement getPassword() {
		return password;
	}
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public WebElement getloginButton() {
		return loginButton;
	}
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[2]/div[3]/div[2]/div/article[2]/div/a")
	WebElement premiumText;
	
	public WebElement getPremiumLink(){
		System.out.println("get premium link");
		return premiumText;
	}
	

	
	@FindBy(xpath="//*[@id=\"__next\"]/div[1]/header/div/nav/ul/li/button/div[2]/span")
	WebElement profileIcon;
	
	public WebElement getProfileIcon() {
		return  profileIcon;
	}
	
	@FindBy(xpath="//*[@id=\"profileMenu\"]/ul/li[2]/a")
	WebElement logoutText;
	
	public WebElement getLogoutText() {
		return logoutText;
	}
	
	public void goToHomePage() {
		driver.get("https://www.spotify.com/in-en/free/");
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	
}
