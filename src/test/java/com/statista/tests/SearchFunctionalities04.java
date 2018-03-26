/**
 * @author Muhabbat
 *
 */
package com.statista.tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class SearchFunctionalities04 extends TestBase {
	HomePage homePage;
	ResultPage resultPage;
	public String searchText = "homelessness";
	
	@Test
	//To verify the searching functionality is available and testable
	public void verifySearchFunctionality() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.searchBox.isDisplayed());
		assertTrue(homePage.searchBttn.isDisplayed());
		homePage.searchBox.sendKeys(searchText + Keys.ENTER);
		assertTrue(resultPage.isAt());
		assertEquals(searchText, resultPage.searchResultValue.getAttribute("value"));
		
	}

	@Test
	//To verify the searching functionality "Studies and Reports" is available and testable.
	public void verifySearchFunctionalitiesStadiesAndReports() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.searchBox.isDisplayed());
		homePage.searchBox.sendKeys(searchText + Keys.ENTER);
		
		assertTrue(resultPage.isAt());
		assertTrue(resultPage.studiesAndReports.isDisplayed());
		assertTrue(resultPage.studAndRepIIcon.isDisplayed());
		
		assertTrue(resultPage.checkBoxesSelected(resultPage.studAndRepCheckBoxes));
		
		assertTrue(resultPage.Dossiers.isDisplayed());
		assertTrue(resultPage.statistaStudies.isDisplayed());
		assertTrue(resultPage.industryCountryReports.isDisplayed());
		assertTrue(resultPage.additionalStudies.isDisplayed());
		
		assertTrue(resultPage.elementsAreDispayed(resultPage.studAndRepProButtons));
		
		
	}
	
	@Test
	//To verify the searching functionality "Dossiers" is available and testable.
	public void verifyDossiersInStadiesAndReports() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.searchBox.isDisplayed());
		homePage.searchBox.sendKeys(searchText + Keys.ENTER);
		
		assertTrue(resultPage.isAt());
		assertTrue(resultPage.studiesAndReports.isDisplayed());
		assertTrue(resultPage.studAndRepIIcon.isDisplayed());
		
		assertTrue(resultPage.checkBoxesSelected(resultPage.studAndRepCheckBoxes));
		
		assertTrue(resultPage.Dossiers.isDisplayed());
		assertTrue(resultPage.statistaStudies.isDisplayed());
		assertTrue(resultPage.industryCountryReports.isDisplayed());
		assertTrue(resultPage.additionalStudies.isDisplayed());
		
		assertTrue(resultPage.elementsAreDispayed(resultPage.studAndRepProButtons));
		
		resultPage.Dossiers.click();
		assertTrue(resultPage.isAt());
		
		assertTrue(resultPage.checkNumberOfResult("4"));
		assertTrue(resultPage.noteInformation.getText().contains("Filtered view"));
	}
	
	@Test
	//To verify the searching functionality "Additional studies" is available and testable.
	public void verifyAdditionalStudiesInStadiesAndReports() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.searchBox.isDisplayed());
		homePage.searchBox.sendKeys(searchText + Keys.ENTER);
		
		assertTrue(resultPage.isAt());
		assertTrue(resultPage.studiesAndReports.isDisplayed());
		assertTrue(resultPage.studAndRepIIcon.isDisplayed());
		
		assertTrue(resultPage.checkBoxesSelected(resultPage.studAndRepCheckBoxes));
		
		assertTrue(resultPage.Dossiers.isDisplayed());
		assertTrue(resultPage.statistaStudies.isDisplayed());
		assertTrue(resultPage.industryCountryReports.isDisplayed());
		assertTrue(resultPage.additionalStudies.isDisplayed());
		
		assertTrue(resultPage.elementsAreDispayed(resultPage.studAndRepProButtons));
		
		resultPage.additionalStudies.click();
		assertTrue(resultPage.isAt());
		
		assertTrue(resultPage.checkNumberOfResult("7"));
		assertTrue(resultPage.noteInformation.getText().contains("Filtered view"));
	}

	@Test
	//Verifying functionality of Consumer Markets filter checkbox
	public void verifyConsumerFunctionality() {
		homePage = new HomePage();
		resultPage = new ResultPage();
		
		assertTrue(homePage.isAt());
		assertTrue(homePage.searchBox.isDisplayed());
		
		homePage.searchBox.sendKeys("Consumer Markets"+ Keys.ENTER);
		assertTrue(resultPage.isAt());
		assertTrue(resultPage.conMarketCheckBox.isDisplayed());
		resultPage.conMarketCheckBox.click();
		
		assertFalse(resultPage.conMarketCheckBox.isSelected());
		assertTrue(resultPage.consumerMarkets.getText().contains("Consumer Markets"));
		assertTrue(resultPage.conMarketIcon.isDisplayed());
		
		resultPage.conMarketCheckBox.click();
		resultPage.ditgitalMarketCheckBox.click();
		assertTrue(resultPage.conMarketCheckBox.isSelected());
		assertFalse(resultPage.ditgitalMarketCheckBox.isSelected());
		assertFalse(resultPage.companiesCheckbox.isSelected());
	} 
}


