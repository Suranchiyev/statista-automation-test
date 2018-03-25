/**
 * @author 10X
 *
 */
package com.statista.navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.statista.utilities.Driver;

public class Header {
   private WebDriver driver; 
   public Header() {
	   driver = Driver.getDriver();
	   PageFactory.initElements(driver, this);
   }
   
}
