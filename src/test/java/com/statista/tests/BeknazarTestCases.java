package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class BeknazarTestCases extends TestBase {
	

	@Test
	public void verifySearchFunctionWithArchiveFilter(){
		HomePage homePage = new HomePage();
        // Verify Title
		assertTrue(homePage.isAt());
		
		// Search for Red Lobster
		homePage.searchBox.sendKeys("Red Lobster");
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		
		// Verify title
		assertTrue(resultPage.isAt());
		
		// Verify options are displayed
		assertTrue(resultPage.optionsAreDispayed(resultPage.searchResults));
		
		// Verify Search accuracy selected "Normal" be default
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());
		
		// Verify number of result is 34
		assertTrue(resultPage.checkNumberOfResult("34"));
		
		// Verify results match with searching value
		assertTrue(resultPage.match(resultPage.getResults(), "Red Lobster",
				"Lobster","restaurant","food","species","price","Darden","dining"));
		
		//Verify Archive search filter default come as "no archive" 
		Select archiveList = new Select(resultPage.archive);
		assertEquals(archiveList.getFirstSelectedOption().getText(),"no archive");
		archiveList.selectByVisibleText("All (incl. archive)");
		resultPage.refreshBtn.click();
		
		//Verify that Change to archive to "All (incl.archive)" added one more result
		assertTrue(resultPage.checkNumberOfResult("35"));
	}
	
	@Test
	public void searchFunctionStudiesReport() {
		HomePage homePage = new HomePage();
		//Verify Title
		assertTrue(homePage.isAt());
		// Search for Red Lobster
		homePage.searchBox.sendKeys("Red Lobster");
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		
		// Verify options are displayed
		assertTrue(resultPage.optionsAreDispayed(resultPage.searchResults));
				
		// Click Studies&Reports
		resultPage.studiesAndReports.click();
		
		// Verify number of result is 2
		assertTrue(resultPage.checkNumberOfResult("2"));
		
		//Verify Archive search filter default come as "no archive" 
		Select archiveList = new Select(resultPage.archive);
		assertEquals(archiveList.getFirstSelectedOption().getText(),"no archive");
		archiveList.selectByVisibleText("All (incl. archive)");
		resultPage.refreshBtn.click();
		
		// Verify number of result is 3
		assertTrue(resultPage.checkNumberOfResult("3"));
		
		// Verify results match with searching value
		assertTrue(resultPage.match(resultPage.getResults(),"Darden"));
	}
}
