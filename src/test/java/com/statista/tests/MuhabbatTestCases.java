package com.statista.tests;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class MuhabbatTestCases extends TestBase {
	HomePage homePage = new HomePage();
	ResultPage resultPage = new ResultPage();
	public String searchText = "homelessness";
	
	@Test
	public void verifySearchFunctionality() {

		assertTrue(homePage.isAt());
		assertTrue(homePage.logo.isDisplayed());
		assertTrue(homePage.searchBox.isDisplayed());
		assertTrue(homePage.searchBttn.isDisplayed());
		homePage.searchBox.sendKeys(searchText + Keys.ENTER);
		assertTrue(resultPage.isAt());
		//assertEquals(searchText, resultPage.searchResultValue.getText());
		
	}

	@Test
	public void verifySearchFunctionalitiesStadiesAndReports() {

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
	public void verifyDossiersInStadiesAndReports() {

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
	public void verifyAdditionalStudiesInStadiesAndReports() {

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

}


