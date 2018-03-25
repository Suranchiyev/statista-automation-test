package com.statista.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.statista.utilities.ConfigurationReader;
import com.statista.utilities.Driver;

public class TestBase {
	
	
    protected WebDriver driver; 
    
	@BeforeMethod(alwaysRun = true)
    public void setUp() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigurationReader.getProperty("url"));
	}
	
	@AfterMethod
	public void ternDown() {
	    //Driver.closeDriver();
	}
	
}
