package com.statista.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.statista.pages.HomePage;
import com.statista.pages.ResultPage;
import com.statista.utilities.TestBase;

public class BeknazarTestCases extends TestBase {
	

	@Test
	public void achiveFilter() throws InterruptedException {
		HomePage homePage = new HomePage();
        // Verify Title
		assertTrue(homePage.isAt());
	
		// Verify logo is displayed
		assertTrue(homePage.logo.isDisplayed());
		
		// Search for Red Lobster
		homePage.searchBox.sendKeys("Red Lobster");
		homePage.searchButton.click();
		ResultPage resultPage = new ResultPage();
		
		// Verify title
		assertTrue(resultPage.isAt());
		
		// Verify Search accuracy selected "Normal" be default
		assertTrue(resultPage.searchAccuracyNormallRadio.isSelected());
		
		// Verify number of result is 34
		int result = resultPage.getNumber(resultPage.numberOfSearchResult);
		assertEquals(result,34);
		
		// Verify results match with searching value
		assertTrue(resultPage.match(resultPage.getResults(), "Red Lobster",
				"Lobster","restaurant","food","species","price","Darden","dining"));
		
		//Verify Archive search filter default come as "no archive" 
		Select archiveList = new Select(resultPage.archive);
		assertEquals(archiveList.getFirstSelectedOption().getText(),"no archive");
		archiveList.selectByVisibleText("All (incl. archive)");
		resultPage.refreshBtn.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,5);
		boolean check = wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("h4[class='hl-module hideMobile']>span"), "(35)"));
		//Verify Change archive to "All (incl.archive)" should add one more options
		result = resultPage.getNumber(driver.findElement(By.cssSelector("h4[class='hl-module hideMobile']>span")));
		assertEquals(result,35);

	}
}
