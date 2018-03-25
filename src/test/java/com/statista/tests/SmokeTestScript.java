/**
 * @author 10X
 *
 */
package com.statista.tests;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.LoginPage;
import com.statista.pages.ResultPage;
import com.statista.utilities.ConfigurationReader;
import com.statista.utilities.TestBase;

public class SmokeTestScript extends TestBase {
    /**    
     *    Steps:
     *    1. Login with valid credentials 
     *    2. Search for "information technology"
     *    
     *    Expected result:
     *    1. System should allow logging 
     *       - verify login link is displayed
     *       - verify title match in HomePage
     *       - verify title match in LoginPage
     *       - verify "My Account" link is displayed after success logging in 
     *       
     *    2. System should response with relevant information about IT
     *       - verify title in HomePage
     *       - verify searchBox is displayed
     *       - verify title in resultPage
     *       
     */
	
	
	@Test
	public void smokeTest() {
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		ResultPage resultPage = new ResultPage();

		assertTrue(homePage.isAt());
		
		assertTrue(homePage.loginLink.isDisplayed());
		homePage.loginLink.click();
		
		assertTrue(loginPage.isAt());
		
		loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
		
		assertTrue(loginPage.myAccountMenu.isDisplayed());
		
		assertTrue(homePage.isAt());
		
		assertTrue(homePage.searchBox.isDisplayed());
		
		homePage.searchBox.sendKeys("information technology"+Keys.ENTER);
		
		assertTrue(resultPage.isAt());
		
		//System should response with relevant information about IT
		assertTrue(resultPage.match(resultPage.getResults(), "IT","information","technology",
				"tech","Digital","device","development","indoor","cyber","ict","storage"));
		
	}
}
