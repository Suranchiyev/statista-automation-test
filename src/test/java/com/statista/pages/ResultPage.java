package com.statista.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    
    
    /*
     *  This method gets Titles of the all search results 
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
		driver.findElement(By.xpath("//a[.='2']")).click();
		List<WebElement> resultsSecond;
		resultsSecond = driver.findElements(By.xpath("//h2"));
		for(WebElement el : resultsSecond) {
			resultsStr.add(el.getText());
		}

		driver.findElement(By.xpath("//a[.='1']")).click();

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
		if (driver.getTitle().equals("• Search | Statista")) {
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
	
	public WebElement getNumberOfResult() {
		return driver.findElement(By.cssSelector("h4[class='hl-module hideMobile']>span"));
	}

}
