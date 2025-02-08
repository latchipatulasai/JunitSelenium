package SeleniuJunitDemo.JunitSelenium;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@FixMethodOrder(MethodSorters.DEFAULT)
public class SauceLabss {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("before ");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after ");
	}

	@Test
	public void openurl() {
		System.out.println("test method");
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
