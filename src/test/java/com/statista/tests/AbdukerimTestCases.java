package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class AbdukerimTestCases extends TestBase {

	@Test
	public void searchEmpty() throws InterruptedException {
		HomePage homePage = new HomePage();
		assertTrue(homePage.isAt());
		// Leave empty search box and click on Search button
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		assertTrue(resultPage.isAt());
		// Set in country filter "Afghanistan"
		resultPage.selectCountryInFilter("Afghanistan");
		// refresh
		resultPage.refreshBtn.click();
		// Verify "Afghanistan is selected"
		assertTrue(resultPage.getCountry("Afghanistan").isDisplayed());
		// Select North America
		Thread.sleep(2000);
		resultPage.chooseRegionByText("North America");
		// Number of countries is 3 after filter
		assertEquals(resultPage.allCounties.size(),3);
		// Verify countries 
		assertEquals(resultPage.allCounties.get(0).getText(),"Canada");
		assertEquals(resultPage.allCounties.get(1).getText(),"Mexico");
		assertEquals(resultPage.allCounties.get(2).getText(),"United States");
		
		
	}

}
