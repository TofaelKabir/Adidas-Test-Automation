package com.adidas.qa.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Properties;
import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.pages.HomePage;
import com.adidas.qa.test.util.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

	@Test()
	public void verifyHomePageAppLogo() {
		Assert.assertTrue(homePage.verifyApplicationLogo(), "Application logo is not present...");
	}

	@Test()
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is: " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home Page Title doesn't match...");
	}


	@Test
	public void testSearchField() {
		homePage.checkSearchField();
	}
	
	@Test
	public void testLightSearch() throws AWTException, InterruptedException {
		WebElement element = driver.findElement(By.id("search-query"));
		element.click();
		element.sendKeys("Light");
		Thread.sleep(5000);
		element.sendKeys(Keys.ENTER);
Thread.sleep(5000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		Thread.sleep(5000);
//		
		
		//driver.findElement(By.xpath("//input[@id='search-query']")).sendKeys("Light", Keys.ENTER);
		//driver.findElement(By.xpath("button[@type='submit' and @class='styles__Button-RC__sc-ajxwy0-3 styles__SearchIconExtended-RC__sc-ajxwy0-4 hrQoSE search-icon']")).click();
	
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}

