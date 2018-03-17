package com.statista.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statista.utilities.Driver;
import com.statista.utilities.TestBase;

public class HomePage extends TestBase {
    
	private WebDriver driver;
	
	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "logoLink")
	public WebElement logo;
	
	@FindBy(id = "homepageSearch")
	public WebElement searchBox;
	
	
}
