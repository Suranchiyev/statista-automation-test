package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class TestSearchFunctionalities extends TestBase {
	

	@Test
	public void countriesFilter() throws InterruptedException {
		HomePage homePage = new HomePage();
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Red Lobster
		homePage.searchBox.sendKeys("Red Lobster");
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		
		// Verify title
		assertTrue(resultPage.isAt());
		
		// Verify Search accuracy selected "Normal" be default
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());
		
		// Verify number of result is 34
		int result = resultPage.getNumber(resultPage.numberOfSearchResult);
		assertEquals(34,result);
		
		// Verify results match with searching value
		System.out.println(resultPage.searchResults.size());
		assertTrue(resultPage.match(resultPage.searchResults, "Red Lobster",
				"Lobster","restaurant","food","species","price","Darden"));

	}
}
