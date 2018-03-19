package com.statista.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.statista.pages.HomePage;
import com.statista.utilities.TestBase;

public class MuhabbatTestCases extends TestBase{

	@Test
	public void homePageTitleAndLogoVerification(){
		HomePage homePage = new HomePage(); 
	
	assertTrue(homePage.isAt());
	assertTrue(homePage.logo.isDisplayed());
	assertTrue(homePage.searchBox.isDisplayed());
	
//		
}
}
