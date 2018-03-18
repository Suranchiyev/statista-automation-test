package com.statista.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statista.utilities.Driver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage() {
    	this.driver = Driver.getDriver();
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "loginStat_username")
    public WebElement username;
    
    @FindBy(id = "loginStat_password")
    public WebElement password;
    
    @FindBy(id = "loginStat_submitLogin")
    public WebElement loginButton;
    
    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccountMenu;
    
	public void login(String username, String password) {
	     this.username.sendKeys(username);
	     this.password.sendKeys(password+Keys.ENTER);
	}
	
	public boolean isAt() {
		return driver.getTitle().contains("Login");
	}

}
