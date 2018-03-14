package utilities;

import org.openqa.selenium.WebDriver;
public class Driver {
	private static WebDriver driver;

	public static WebDriver getDriver() {
	   // TODO use bonnies garci plugin 
		return driver;
	}

	public static void quit() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
