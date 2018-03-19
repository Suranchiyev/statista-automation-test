package com.statista.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;

public class StatisticsCheckBoxFilter {
	@Test
	public void achiveFilter() throws InterruptedException {
		HomePage homePage = new HomePage();
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Statistics
		homePage.searchBox.sendKeys("Statistics");
		homePage.searchBox.sendKeys(Keys.ENTER);
	
		ResultPage resultPage = new ResultPage();
		
		// Verify title
		assertTrue(resultPage.isAt());
		
		
		
}
}