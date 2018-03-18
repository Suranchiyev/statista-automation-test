package com.statista.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.statista.utilities.Driver;

public class ResultPage {

	private WebDriver driver;

	public ResultPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "accuracy_1")
	public WebElement searchAccuracyNormallRadio;

	@FindBy(css = "h4[class='hl-module hideMobile']>span")
	public WebElement numberOfSearchResult;

    @FindBy(xpath="//h2")
    public List<WebElement> searchResults;
    
    @FindBy(id = "archive")
    public WebElement archive;
    
    @FindBy(id = "refreshBtn")
    public WebElement refreshBtn;
     
    @FindBy(xpath ="//h3[contains(text(),'Studies & Reports')]")
    public WebElement studiesAndReports;
    
    @FindBy(xpath="//input[@class='entitiy__checkbox']")
    public List<WebElement> statisticsCheckBox;
    
    @FindBy(xpath="//*[@class='entitiy__label']/span")
    public List<WebElement> checkBoxOptions;
    
    
    /*
     *   This method gets Titles of the all search results in the first two
     *   pages.   
     *   It converts WebElement to String because WebElement keeps only
     *   reference to Element, since search result might be store in multiple 
     *   pages. It looses value once driver change focus. 
     */
	public List<String> getResults(){
		List<String> resultsStr = new ArrayList<>();
		List<WebElement> resultsFirst;
		resultsFirst = driver.findElements(By.xpath("//h2"));
		for(WebElement el : resultsFirst) {
			resultsStr.add(el.getText());
		}
		try {
		driver.findElement(By.xpath("//a[.='2']")).click();
		List<WebElement> resultsSecond;
		resultsSecond = driver.findElements(By.xpath("//h2"));
		for(WebElement el : resultsSecond) {
			resultsStr.add(el.getText());
		}
		System.out.println("Results on  two pages");

		driver.findElement(By.xpath("//a[.='1']")).click();
		}catch(Exception e) {
			System.out.println("Results in one page");
		}

		return resultsStr;
	}
	
    /*
     *    This method accept List of String(results)
     *    And keyWords for checking if result is relevant to the searching
     *    value
     */
	public boolean match(List<String> results, String... keyWords) {
		boolean check = true;
		for (String str : results) {
			for (String keyWord : keyWords) {
				if (str.toLowerCase().contains(keyWord.toLowerCase())) {
					check = false;
				}
			}
			if (check) {
				System.out.println(str);
				return false;
			}
			check = true;
		}
		return true;
	}

	public boolean isAt() {
		if (driver.getTitle().contains(" Search | Statista")) {
			return true;
		}
		return false;
	}

	public int getNumber(WebElement element) {
		String str = element.getText();
		String numbers = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				numbers += str.charAt(i) + "";
			}
		}

		return Integer.parseInt(numbers);
	}
	
	public boolean checkNumberOfResult(String expected) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		boolean matched = wait.until(ExpectedConditions.textToBe(By.cssSelector("h4[class='hl-module hideMobile']>span"), "("+expected+")"));
		return matched;
	}
	
	public boolean optionsAreDispayed(List<WebElement> list) {
		for(WebElement e : list) {
			if(!e.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isSmthngDisplayed (List<WebElement> something, List<WebElement> options, String word) {
		for (int i=0; i<something.size(); i++) {
			if(something.isEmpty()){
				System.out.println("There are no checkboxes displayed on the page");
				return false;
			}else {
				for (int j=0; j<options.size(); j++) {
					String str=options.get(j).getText();
					if(str.equals(word)) {
						System.out.println("The check box option "+word+" is found");
						return true;
					}else {
						System.out.println("The check box option "+word+" is NOT found");
						return false;
					}
					
				}
				return true;
			}
			
		}
		return false;
		
	}

}
