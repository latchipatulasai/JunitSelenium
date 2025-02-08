package SeleniuJunitDemo.JunitSelenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SauceLabs {
	static WebDriver driver;

	@org.junit.Test
	public void login() {
		// auto download chrome driver
		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver", "https://www.saucedemo.com/");
		driver = new ChromeDriver();
		// opening url
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		// Assert.assertEquals(title, "Swa Labs");
		System.out.println(title);
	}
}
