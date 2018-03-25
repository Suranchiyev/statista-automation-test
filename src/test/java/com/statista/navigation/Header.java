/**
 * @author 10X
 *
 */
package com.statista.navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.statista.utilities.Driver;

public class Header {
   private WebDriver driver; 
   public Header() {
	   driver = Driver.getDriver();
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(id = "statistaLogo")
   public WebElement logo;
   
   @FindBy(css = "a[href='/customercloud/global-consumer-survey']")
   public WebElement globalSurveyLink;
   
   @FindBy(xpath = "//a[@href='/accounts/' and @class='navMain__navigationItem']")
   public WebElement priceLink;
   
   @FindBy(css = "a[href='/outlook/digital-markets']")
   public WebElement digitalMarketLink;
   
   @FindBy(css = "a[href='/outlook/consumer-markets']")
   public WebElement consumerMarketsLink;
   
   @FindBy(css = "a[href='/studies-and-reports/']")
   public WebElement reportsLink;
   
   @FindBy(css = "li[class='navMain__item navMain__item--expanded']>span")
   public WebElement statisticsLink;
   
   @FindBy(id = "q")
   public WebElement searchTopButton;
   
   
   
   
   
}
