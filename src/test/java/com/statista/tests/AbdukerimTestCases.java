package com.statista.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class AbdukerimTestCases extends TestBase {

	@Test
	public void searchEmpty() throws InterruptedException {
		HomePage homePage = new HomePage();
		// Leave empty search box and click on Search button
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		// Set in country filter "Afghanistan"
		resultPage.selectCountryInFilter("Afghanistan");
		// refresh
		resultPage.refreshBtn.click();
		// Verify "Afghanistan is selected"
		assertTrue(resultPage.getCountry("Afghanistan").isDisplayed());
		// Select North America
		Thread.sleep(2000);
		resultPage.selectRegionByText("North America");
	}

}
