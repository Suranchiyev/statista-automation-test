/**
 * @author Beknazar
 *
 */
package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class SearchFunctionalites02 extends TestBase {
	HomePage homePage;
	ResultPage resultPage;

	@Test
	public void verifySearchFunctionWithArchiveFilterTC01() {
		homePage = new HomePage();
		resultPage = new ResultPage();

		assertTrue(homePage.isAt());

		homePage.searchFor("Red Lobster");

		assertTrue(resultPage.isAt());
		assertTrue(resultPage.elementsAreDispayed(resultPage.searchResults), "Result artices are not displayed");
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());
		assertTrue(resultPage.checkNumberOfResult("34"), "Number of result is not 34");
		// Verify results are match with search value. Throw keywords
		assertTrue(resultPage.match(resultPage.getResults(), "Red Lobster", "Lobster", "restaurant", "food", "species",
				"price", "Darden", "dining"));
		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "no archive"),
				"In archive options 'no archive' is't selected by default");
		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");
		resultPage.refreshBtn.click();
		assertTrue(resultPage.checkNumberOfResult("35"), "Number of results is not 35");
	}

	@Test
	public void searchFunctionStudiesReportTC02() {
		homePage = new HomePage();
		resultPage = new ResultPage();

		assertTrue(homePage.isAt());
		homePage.searchFor("Red Lobster");

		assertTrue(resultPage.elementsAreDispayed(resultPage.searchResults), "Result artices are not displayed");
		resultPage.studiesAndReports.click();
		assertTrue(resultPage.checkNumberOfResult("2"), "Number of results is not 2");
		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "no archive"),
				"In archive options 'no archive' is't selected by default");

		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");
		resultPage.refreshBtn.click();

		assertTrue(resultPage.checkNumberOfResult("3"), "Number of results is not 3");
		assertTrue(resultPage.match(resultPage.getResults(), "Darden"));
	}

	@Test
	public void searchAndFilterTC03() {
		homePage = new HomePage();
		homePage.searchBox.sendKeys("Amazon" + Keys.ENTER);
		resultPage = new ResultPage();

		assertTrue(resultPage.isAt());
		resultPage.studAndRepIIcon.click();

		assertTrue(resultPage.checkNumberOfResult("93"), "Number of results is not 93");
		resultPage.chooseLocationFocusByText("United States");

		assertTrue(resultPage.match(resultPage.getResults(), "Amazon", "e-commerce", "outlook", "healthcare", "app",
				"top", "smart", "digit", "market", "Online", "Awards", "Drone", "analys", "Software", "e-readers",
				"book", "Video", "u.s.", "Report", "electronic", "Telecommunication", "world", "retailers", "estate"));
	}

	@Test
	public void searchAndFilterNegativeTC04() {
		homePage = new HomePage();

		assertTrue(homePage.isAt());
		homePage.searchBox.sendKeys("Cybertek" + Keys.ENTER);

		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		resultPage.chooseLocationFocusByText("Mexico");

		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());

		resultPage.searchAccuracyWideRadio.click();

		assertTrue(resultPage.isNoResults(), "System gave some result");
	}

	@Test
	public void searchFilterTC05() {
		homePage = new HomePage();
		assertTrue(homePage.isAt());
		homePage.searchBox.sendKeys("homelessness" + Keys.ENTER);

		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		resultPage.chooseRegionByText("North America");

		int expect = 3;
		int actual = resultPage.allCounties.size();

		assertTrue(expect == actual, "Number of country does not match");
		assertEquals(resultPage.allCounties.get(0).getText(), "Canada");
		assertEquals(resultPage.allCounties.get(1).getText(), "Mexico");
		assertEquals(resultPage.allCounties.get(2).getText(), "United States");
	}

	@Test
	public void searchAndFilterTC06() {
		homePage = new HomePage();
		assertTrue(homePage.isAt());
		homePage.searchBox.sendKeys("Digital Markets" + Keys.ENTER);
		

		resultPage = new ResultPage();
		assertTrue(resultPage.isAt());

		resultPage.elementsAreDispayed(resultPage.checkBoxes);

	}

}
