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
		String URL = "http://54.82.9.134/DomainMapping/index.php";
		driver.navigate().to(URL);
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.id("Username")).sendKeys("b");
		driver.findElement(By.id("Password")).sendKeys("a");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.close();
	}
}
