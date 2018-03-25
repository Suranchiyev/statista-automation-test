package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class BeknazarTestCases extends TestBase {
	HomePage homePage;
	ResultPage resultPage;

	@Test
	public void verifySearchFunctionWithArchiveFilterTC01() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		// Verify Title
		assertTrue(homePage.isAt());

		// Search for Red Lobster
		homePage.searchFor("Red Lobster");

		// Verify title
		assertTrue(resultPage.isAt());

		// Verify options are displayed
		assertTrue(resultPage.elementsAreDispayed(resultPage.searchResults), "Result artices are not displayed");

		// Verify Search accuracy selected "Normal" be default
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());

		// Verify number of result is 34
		assertTrue(resultPage.checkNumberOfResult("34"), "Number of result is not 34");

		// Verify results match with searching value
		assertTrue(resultPage.match(resultPage.getResults(), "Red Lobster", "Lobster", "restaurant", "food", "species",
				"price", "Darden", "dining"));

		// Verify Archive search filter by default come as "no archive"
		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "no archive"),
				"In archive options 'no archive' is't selected by default");

		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");
		resultPage.refreshBtn.click();

		// Verify that Change to archive to "All (incl.archive)" added one more result
		assertTrue(resultPage.checkNumberOfResult("35"),"Number of results is not 35");
	}

	@Test
	public void searchFunctionStudiesReportTC02() {
		homePage = new HomePage();
	    resultPage = new ResultPage();

		// Verify Title
		assertTrue(homePage.isAt());

		// Search for Red Lobster
		homePage.searchFor("Red Lobster");

		// Verify results are displayed
		assertTrue(resultPage.elementsAreDispayed(resultPage.searchResults), "Result artices are not displayed");

		// Click Studies&Reports
		resultPage.studiesAndReports.click();

		// Verify number of result is 2
		assertTrue(resultPage.checkNumberOfResult("2"), "Number of results is not 2");

		// Verify Archive search filter by default come as "no archive"
		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "no archive"),
				"In archive options 'no archive' is't selected by default");

		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");

		resultPage.refreshBtn.click();

		// Verify number of result is 3
		assertTrue(resultPage.checkNumberOfResult("3"), "Number of results is not 3");

		// Verify results match with searching value
		assertTrue(resultPage.match(resultPage.getResults(), "Darden"));
	}

	@Test
	public void searchAndFilterTC03(){
		homePage = new HomePage();
		homePage.searchBox.sendKeys("Amazon"+Keys.ENTER);
		resultPage = new ResultPage();
		
		//Verify title of ResultPage
		assertTrue(resultPage.isAt());
		resultPage.studAndRepIIcon.click();
		
		
		// Verify number of result is 93
		assertTrue(resultPage.checkNumberOfResult("93"), "Number of results is not 93");		
		resultPage.chooseLocationFocusByText("United States");

		
		//Verify results are relevant to search value
		assertTrue(resultPage.match(resultPage.getResults(),"Amazon","e-commerce","outlook","healthcare",
				"app","top","smart","digit","market","Online","Awards","Drone","analys",
				"Software","e-readers","book","Video","u.s.","Report","electronic",
				"Telecommunication","world","retailers","estate"));
	}

	@Test
	public void searchAndFilterNegativeTC04() {
		homePage = new HomePage();
		// Verify title of HomePage
		assertTrue(homePage.isAt());
		homePage.searchBox.sendKeys("Cybertek"+Keys.ENTER);
		
		// Verify title of ResultPage
		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		resultPage.chooseLocationFocusByText("Mexico");
		
		// Verify Search accuracy selected "Normal" be default
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());
		
		resultPage.searchAccuracyWideRadio.click();
		
		//Search result should NOT gave us nothing
		assertTrue(resultPage.isNoResults(),"System gave some result");
	}
	/**
	1. Go to the Https://www.statista.com home page.
    2. Use the main search box to search for “homelessness” and hit the enter key
    3. Choose “North America” from the region select box
    4. Expect to see the only “Canada”, “Mexico”, and “United States” webelements to be visible
     from the country filter check box area.
		**/
	@Test
	public void searchFilterTC05(){
		homePage = new HomePage();
		assertTrue(homePage.isAt());
		homePage.searchBox.sendKeys("homelessness"+Keys.ENTER);
		
		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		resultPage.chooseRegionByText("North America");
		
		// Expect to see the only “Canada”, “Mexico”, and “United States”
		int expect = 3;
		int actual = resultPage.allCounties.size();
		assertTrue(expect == actual,"Number of country does not match");
		assertEquals(resultPage.allCounties.get(0).getText(), "Canada");
		assertEquals(resultPage.allCounties.get(1).getText(), "Mexico");
		assertEquals(resultPage.allCounties.get(2).getText(), "United States");	
	}
	
	@Test
	public void searchAndFilterTC06() {
		homePage = new HomePage();
		homePage.searchBox.sendKeys("Digital Markets"+Keys.ENTER);
		assertTrue(homePage.isAt());
		
		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		
		resultPage.elementsAreDispayed(resultPage.checkBoxes);
		
	}
	
	
}
