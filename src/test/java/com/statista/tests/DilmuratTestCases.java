/**
 * @author Dilmurat
 *
 */
package com.statista.tests;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.BrowserUtils;
import com.statista.utilities.TestBase;

public class DilmuratTestCases extends TestBase {
	@Test
	public void verifyarchiveIconIsWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		// Search for "Homelessness"
		homePage.searchFor("Homelessness");
		// comparing archive icons value equals expected result
		assertTrue(resultPage.checkArchiveIconIsWorking("Search the Statista archive"));
	}

	@Test
	public void verifyArchiveisWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		// Verify Title
		assertTrue(homePage.isAt());

		// Search for Red Homelessness
		homePage.searchFor("Homelessness");

		// Verify title
		assertTrue(resultPage.isAt());

		// select All (incl. archive) from the drop down
		resultPage.selectOptionByVisibleText(resultPage.archiveOptions, "All (incl. archive)");
		// Verify that archive field is selected
		assertTrue(resultPage.checkOptionIsSelected(resultPage.archiveOptions, "All (incl. archive)"));
		// resultPage.refreshBtn.click();
		// Verify that Change to archive to "All (incl.archive)" added one more result

	}

	@Test
	public void verifyLocationFocusIconisWorking() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		// Search for "Homelessness"
		homePage.searchFor("Homelessness");
		// comparing archive icons value equals expected result
		assertTrue(resultPage.checkLocationFocusIconIsWorking("will be ranked higher"));
	}

	@Test
	public void verifyLocationFocusisWorking() throws InterruptedException {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
		// Search for "Homelessness"
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
		// Search for "Homelessness"
		homePage.searchFor("Homelessness");
		// Verify title
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
		// Search for "Companies"
		homePage.searchFor("Companies");
		// Verify title
		assertTrue(resultPage.isAt());
		assertTrue(resultPage.companiesCheckbox.isDisplayed());
		assertTrue(resultPage.companiesIcon.isDisplayed());
		assertTrue(resultPage.companiesButton.isDisplayed());
		resultPage.companiesCheckbox.click();
		assertTrue(resultPage.checkOnlyOneChechBoxIsSelected("companies"));
}
}