/**
 * @author Ian
 *
 */
package com.statista.tests;
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
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Statistics
		homePage.searchBox.sendKeys("Statistics");
		homePage.searchBox.sendKeys(Keys.ENTER);
	
		
		
		// Verify title
		assertTrue(resultPage.isAt());
		//Verify checkboxes are displayed
		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));
		//verify checkboxes are selected
		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox)); 
		//verify icon is displayed
		assertTrue(resultPage.isIconDisplayed("Statistic"));
		//assertTrue(resultPage.statisticsIcon.isDisplayed());
		//verify text next to icon and click on it
		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Statistics"));
		//select Statistics
		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));
	
}
	
	@Test
	public void achiveFilterForecast() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Statistics
		homePage.searchBox.sendKeys("Forecast & survays ");
		homePage.searchBox.sendKeys(Keys.ENTER);
	
		
		
		// Verify title
		assertTrue(resultPage.isAt());
		//Verify checkboxes are displayed
		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));
		//verify checkboxes are selected
		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox)); 
		//verify icon is displayed
		assertTrue(resultPage.isIconDisplayed("Forecast"));
		//assertTrue(resultPage.statisticsIcon.isDisplayed());
		//verify text next to icon and click on it
		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Forecasts"));
		//select Statistics
		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));
	}
	
	@Test
	public void achiveFilterInfographics() {
		HomePage homePage = new HomePage();
		ResultPage resultPage = new ResultPage();
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Statistics
		homePage.searchBox.sendKeys("Infographics");
		homePage.searchBox.sendKeys(Keys.ENTER);
	
		
		
		// Verify title
		assertTrue(resultPage.isAt());
		//Verify checkboxes are displayed
		assertTrue(resultPage.elementsAreDispayed(resultPage.statisticsCheckBox));
		//verify checkboxes are selected
		assertTrue(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox)); 
		//verify icon is displayed
		assertTrue(resultPage.isIconDisplayed("Infographic"));
		//verify text next to icon and click on it
		assertTrue(resultPage.checkBoxTextDisplayed(resultPage.checkboxText, "Infographics"));
		//select Statistics
		assertFalse(resultPage.checkBoxesSelected(resultPage.statisticsCheckBox));
	}
}