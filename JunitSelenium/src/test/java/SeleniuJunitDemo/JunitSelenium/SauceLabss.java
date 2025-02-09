package SeleniuJunitDemo.JunitSelenium;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SauceLabss {
	static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
		driver.close();
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
	public void Aopenurl() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Blogin() throws IOException {
		try {
			// waiting for particular element to visible by using id
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
			// Entering the username by using id locator
			driver.findElement(By.id("user-name")).sendKeys("standard_user");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			// Entering the username by using name locator
			driver.findElement(By.name("password")).sendKeys("secret_sauce");
			// wait.until(ExpectedConditions.elementToBeClickable(By.className("submit-button
			// btn_action")));
			// driver.findElement(By.className("submit-button btn_action")).click();
			driver.findElement(By.id("login-button")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));
			driver.findElement(By.xpath("//span[text()='Products']")).isDisplayed();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("resources\\Screenshots\\HomePage.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void Copenproduct() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Sauce Labs Backpack']")));
			driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
