package mavendemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

	public static void main(String[] args) {
		// Download gecko driver from https://github.com/mozilla/geckodriver/releases
		// TODO : This should be moved to config file
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\swagata.chatterjee\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
//		String URL = "https://en.wikipedia.org/wiki/Main_Page";
//		driver.navigate().to(URL);
//		String title = driver.getTitle();
//		System.out.println(title);
//		driver.quit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(" ");
		driver.manage().window().maximize();
		int count = 0;
		for (String line : queryList) {
			String[] parts = line.split("/t");
			count = count + 1;
			if (parts[0].length() != 0) {
				driver.findElement(By.id("search-field")).clear();
				driver.findElement(By.id("search-field")).sendKeys(parts[0]);
				driver.findElement(By.id("btn-search")).click();
				Thread.sleep(5000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				do {
					Thread.sleep(5000);
					for (int second = 0;; second++) {
						if (second >= 5) {
							break;
						}
						jse.executeScript("window.scrollBy(0,500)", "");
						Thread.sleep(1500);
					}
					try {
						driver.findElement(By.linkText("Next »")).click();
					} catch (Exception ex) {
						break;
					}
				} while (true);
			}
		}
		System.out.println("No. of queries executed: " + count);
		driver.close();
	}
}
