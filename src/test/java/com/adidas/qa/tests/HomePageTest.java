package com.adidas.qa.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;
import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.pages.HomePage;
import com.adidas.qa.test.util.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test(enabled = false)
	public void verifyHomePageAppLogo() {
		Assert.assertTrue(homePage.verifyApplicationLogo(), "Application logo is not present...");
	}

	// Use of priority and enabled
	@Test(priority = 1, enabled = false)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page Title doesn't match...");
	}

	@Test(enabled = false)
	public void testSearchField() {
		homePage.checkSearchField();
	}

//	@Test()
//	public void testSearchField() {
//		WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']"));
//    	JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click()", searchField);
//
//	}

	@Test(enabled = false)
	public void testHelp() {
		homePage.checkHelp();
	}

	@Test(enabled = false)
	public void testExchange() {
		homePage.checkExchange();
	}

	// shortest way to write test cases
	@Test(enabled = false)
	public void testMen() {
		driver.findElement(By.xpath("(//a[text()='Men'])[1]")).click();

	}

	// use of expectedExceptions, not running really, ignoring the test for the
	// moment
	@Test(enabled = false, expectedExceptions = ElementClickInterceptedException.class)
	public void testOrderTracker1() {
		driver.findElement(By.xpath("//a[text()='Order Tracker']//parent::div")).click();

	}

	// When Selenium fail, we can use JavascriptExecutor as alternate
	@Test(enabled = false)
	public void testOrderTracker2() {
		WebElement orderTracker = driver.findElement(By.xpath("//a[text()='Order Tracker']//parent::div"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", orderTracker);

	}

	// "Search" any item by clicking "Search" button from webPage
	// although it is failing, because search field disappear after writing anything
	@Test(enabled = false)
	public void testSearchItem1() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Sneakers");
		driver.findElement(By.xpath("//div[@class='search-icon___1MZ8G']")).click();

	}

	// "Search" any item by clicking "Enter" button from keyboard
	@Test(enabled = false)
	public void testSearchItem2() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Sneakers", Keys.ENTER);

	}

	// Use of clear method, code copied from top one
	@Test(enabled = false)
	public void testSearchItem3() {
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Sneakers", Keys.ENTER);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();

	}

	// use of 'get' method to navigate to another website
	@Test(enabled = false)
	public void testAnotherWebsite1() {
		driver.get("https://www.mountsinai.org/");
	}

	// use of 'navigate to' method to navigate to another website
	@Test(enabled = false)
	public void testAnotherWebsite2() {
		driver.get("https://www.mountsinai.org/");
		driver.navigate().to("https://www.amazon.com/");
	}

	// use of 'back', 'forward' and 'refresh' method to navigate to another website
	@Test(enabled = true)
	public void testAnotherWebsite3() {
		driver.get("https://www.mountsinai.org/");
		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().back(); // Back to Mountsinai
		driver.navigate().forward(); // returned to Amazon
		driver.navigate().refresh(); // to refresh
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}

// from Lowes
//@Test
//public void testLightSearch() throws AWTException, InterruptedException {
//	WebElement element = driver.findElement(By.id("search-query"));
//	element.click();
//	element.sendKeys("Light");
//	Thread.sleep(5000);
//	element.sendKeys(Keys.ENTER);
//Thread.sleep(5000);
//	Robot robot = new Robot();
//	robot.keyPress(KeyEvent.VK_ENTER);
//	Thread.sleep(5000);
//	

// driver.findElement(By.xpath("//input[@id='search-query']")).sendKeys("Light",
// Keys.ENTER);
// driver.findElement(By.xpath("button[@type='submit' and
// @class='styles__Button-RC__sc-ajxwy0-3
// styles__SearchIconExtended-RC__sc-ajxwy0-4 hrQoSE search-icon']")).click();

//}
