package mavendemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		// Download gecko driver from https://github.com/mozilla/geckodriver/releases
		// TODO : This should be moved to config file
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\swagata.chatterjee\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String URL = "https://en.wikipedia.org/wiki/Main_Page";
		driver.navigate().to(URL);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}
}
