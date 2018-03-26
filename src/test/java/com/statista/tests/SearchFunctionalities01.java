/**
 * @author Abdukerim
 *
 */
package com.statista.tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class SearchFunctionalities01 extends TestBase {
	HomePage homePage;
	ResultPage resultPage;
	@Test
	public void searchForHomelessnessNTC1() {
		homePage = new HomePage();
		resultPage = new ResultPage();

		assertTrue(homePage.isAt());

		homePage.searchBox.sendKeys("homelessness" + Keys.ENTER);

		resultPage.chooseRegionByText("Africa");
		resultPage.refreshBtn.click();

		assertTrue(resultPage.countryNotDisplyed("Canada"));
	}

	@Test 
	public void searchEmpty() throws InterruptedException {
		homePage = new HomePage();
		assertTrue(homePage.isAt());

		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		assertTrue(resultPage.isAt());

		resultPage.selectCountryInFilter("Afghanistan");

		resultPage.refreshBtn.click();

		assertTrue(resultPage.getCountry("Afghanistan").isDisplayed());

		Thread.sleep(2000);
		int numOfAfg = resultPage.getNumber(resultPage.numberOfSearchResult);
		resultPage.chooseRegionByText("North America");
		// refresh
		resultPage.refreshBtn.click();
		Thread.sleep(2000);
		int numOfNA = resultPage.getNumber(resultPage.numberOfSearchResult);
		System.out.println(numOfAfg);
		System.out.println(numOfNA);
		// Verify that number of result is more than the results in step 3
		assertTrue(numOfNA > numOfAfg);
	}


}
