/**
 * @author Ian
 *
 */
package com.statista.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class IanTestCases extends TestBase {
	@Test
	public void achiveFilter() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();

		assertTrue(homePage.isAt());

		assertTrue(homePage.logo.isDisplayed());

		homePage.searchBox.sendKeys("Statistics");
		homePage.searchBox.sendKeys(Keys.ENTER);

		assertTrue(resultPage.isAt());

		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));

		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));

		assertTrue(resultPage.isIconDisplayed("Statistic"));

		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Statistics"));

		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));

	}

	@Test
	public void achiveFilterForecast() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();

		assertTrue(homePage.isAt());

		assertTrue(homePage.logo.isDisplayed());

		homePage.searchBox.sendKeys("Forecast");
		homePage.searchBox.sendKeys(Keys.ENTER);

		assertTrue(resultPage.isAt());

		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));

		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));

		assertTrue(resultPage.isIconDisplayed("Forecast"));

		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Forecasts"));

		assertFalse(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));
	}

	@Test
	public void achiveFilterInfographics() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();

		assertTrue(homePage.isAt());

		assertTrue(homePage.logo.isDisplayed());

		homePage.searchBox.sendKeys("Infographics");
		homePage.searchBox.sendKeys(Keys.ENTER);

		assertTrue(resultPage.isAt());

		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));

		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));

		assertTrue(resultPage.isIconDisplayed("Infographic"));

		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Infographics"));

		assertFalse(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));
	}
}