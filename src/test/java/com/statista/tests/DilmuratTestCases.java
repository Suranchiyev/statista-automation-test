/**
 * @author Dilmurat
 *
 */
package com.statista.tests;

import static org.testng.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class DilmuratTestCases extends TestBase {
	@Test
	public void verifyarchiveIconIsWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		homePage.searchFor("Homelessness");

		assertTrue(resultPage.checkArchiveIconIsWorking("Search the Statista archive"));
	}

	@Test
	public void verifyArchiveisWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		assertTrue(homePage.isAt());

		homePage.searchFor("Homelessness");

		assertTrue(resultPage.isAt());

		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");

		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "All (incl. archive)"));
	}

	@Test
	public void verifyLocationFocusIconisWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		homePage.searchFor("Homelessness");

		assertTrue(resultPage.checkLocationFocusIconIsWorking("will be ranked higher"));
	}

	@Test
	public void verifyLocationFocusisWorking() throws InterruptedException {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();

		homePage.searchFor("Homelessness");
		resultPage.UnitedKingdom.click();
		resultPage.refreshBtn.click();
		Thread.sleep(2000);
		assertTrue(resultPage.match(resultPage.getResults(), "UK", "England", "Homelessness", "London", "homeless",
				"Poverty", "Wales"));

	}

	@Test
	public void verifyPublicationDateisWorking() throws InterruptedException {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		homePage.searchFor("Homelessness");

		assertTrue(resultPage.isAt());
		resultPage.yearSelect.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		resultPage.refreshBtn.click();
		assertTrue(resultPage.checkNumberOfResult("21"));
	}

	@Test
	public void verifyCompaniesfilterIsDisplayed() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();

		homePage.searchFor("Companies");

		assertTrue(resultPage.isAt());
		assertTrue(resultPage.companiesCheckbox.isDisplayed());
		assertTrue(resultPage.companiesIcon.isDisplayed());
		assertTrue(resultPage.companiesButton.isDisplayed());
		resultPage.companiesCheckbox.click();
		assertTrue(resultPage.checkOnlyOneChechBoxIsSelected("companies"));
	}
}