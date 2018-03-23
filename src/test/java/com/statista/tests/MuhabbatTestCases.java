package com.statista.tests;


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
		
		assertTrue(resultPage.elementsAreDispayed(resultPage.studAndRepProButtons));
		
		//
		
		
	}

}


