package com.statista.pages;

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
    
    /*  I will finish this method tomorrow
	public List<WebElement> getResults() throws InterruptedException {
		List<WebElement> results;
		results = driver.findElements(By.xpath("//h2"));
		driver.findElement(By.xpath("//a[.='2']")).click();
		Thread.sleep(2000);
		results.addAll(driver.findElements(By.xpath("//h2")));
		System.out.println("From Result Page: "+results.size());
		driver.findElement(By.xpath("//a[.='1']")).click();
		Thread.sleep(2000);
		return results;
	}
	*/

	public boolean match(List<WebElement> results, String... keyWords) {
		boolean check = true;
		for (WebElement el : results) {
			for (String keyWord : keyWords) {
				if (el.getText().toLowerCase().contains(keyWord.toLowerCase())) {
					check = false;
				}
			}
			if (check) {
				System.out.println(el.getText());
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

}
