package com.adidas.qa.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.pages.HomePage;
import com.adidas.qa.test.util.Constants;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute.Use;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	JavascriptExecutor js;

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
	@Test(enabled = false)
	public void testAnotherWebsite3() {
		driver.get("https://www.mountsinai.org/");
		driver.navigate().to("https://www.amazon.com/");
		driver.navigate().back(); // Back to Mountsinai
		driver.navigate().forward(); // returned to Amazon
		driver.navigate().refresh(); // to refresh
	}
	

	//Use of Javascript instead of selenium, when selenium didn't respond
	@Test (enabled = false)
	public void sendKeysToAmazonSearch() throws InterruptedException, AWTException  {
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.com/"); //alternate to .get(), difference -- .get() method helps to initiate the browser until it is loaded
		// This will scroll down the page by 3000 pixel vertical
		Thread.sleep(4000); //used to see the scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)",""); //scroll down
		// This will scroll up the page by 3000 pixel vertical
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-3000)",""); //scroll-up
		Thread.sleep(5000);
		driver.navigate().back(); //Back to Adidas
		Thread.sleep(5000);
		driver.navigate().forward(); //returned to Amazon
		Thread.sleep(5000);
		driver.navigate().refresh();  // to refresh by selenium
		Thread.sleep(5000);
		
		js.executeScript("history.go(0)"); // To do refresh by Javascript
		Thread.sleep(5000);
		String sText =js.executeScript("return document.title;").toString(); // fetching page title by javascript
		System.out.println(sText);
		
		WebElement searchField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement submitButton = driver.findElement(By.xpath("//input[@tabindex='0' and @type='submit']"));
		
		js.executeScript("arguments[0].value='macbook air'", searchField); //to send keys
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", submitButton); //to do click
		
		Thread.sleep(5000);
		
		driver.navigate().to("https://www.mountsinai.org/");
		Thread.sleep(5000);
		//Dimension class is used for change the size of the page
		org.openqa.selenium.Dimension ds = new org.openqa.selenium.Dimension(480, 620); //Dimension class to reset size
		driver.manage().window().setSize(ds);
		Thread.sleep(4000); //to see the change
		driver.manage().window().fullscreen();
		Thread.sleep(4000);
		
		//SCROLL DOWN BY SELENIUM by ROBOT class
		Thread.sleep(2000);
		driver.navigate().to("https://www.amazon.com/");
		driver.manage().window().fullscreen();
		Robot robot = new Robot();

        // Scroll Down using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        Thread.sleep(4000);

        // Scroll Up using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_UP);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        Thread.sleep(4000);
        
      //SCROLL DOWN BY SELENIUM
        Thread.sleep(2000);
		driver.navigate().to("https://www.mountsinai.org/");
        
        Actions actions = new Actions(driver);

        // Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(4000);

        // Scroll Up using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
        Thread.sleep(4000);
	}

	// use of getAttribute
	// Use of normalize-space
	@Test(enabled = false)
	public void ourLocationsTest0() {
		driver.get("https://www.mountsinai.org/"); // I am using this line to work on Mount Sinai as Adidia doesn't have
													// much function
		String value = driver.findElement(By.xpath("//a[normalize-space(text())='Our Locations' and @class='hidden-xs dropdown']")).getAttribute("data-toggle");
		System.out.println(value);
	}

	// Use of Thread.sleep
	// Use of preceding-sibling
	// Use of Search something
	@Test(enabled = false)
	public void searchButtonTest1() throws InterruptedException {
		driver.get("https://www.mountsinai.org/");
		//clicking on search icon
		//preceding-sibling is for elder brother, following-sibling for younger brother
		driver.findElement(By.xpath("(//span[contains(text(),'Search')]//preceding-sibling::i[@class='fa fa-search'])[2]")).click();
		Thread.sleep(5000);
		//searching a doctor in search field
		driver.findElement(By.xpath("(//input[@class='js-yext-query yxt-SearchBar-input'])[2]")).sendKeys("Andrea Perez");
		Thread.sleep(5000);
		//clicking submit button
		driver.findElement(By.xpath("(//div[@class='yxt-SearchBar-buttonImage component'])[2]")).click();
		Thread.sleep(5000);
	}

	// isEnabled() is the method used to verify if the web element is enabled or
	// disabled within the web page. isEnabled() is primarily used with buttons.
	// Use of isEnabled()
	@Test(enabled = false)
	public void searchButtonTest2() throws InterruptedException {
		driver.get("https://www.mountsinai.org/");
		driver.findElement(
				By.xpath("(//span[contains(text(),'Search')]//preceding-sibling::i[@class='fa fa-search'])[2]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@class='js-yext-query yxt-SearchBar-input'])[2]"))
				.sendKeys("Andrea Perez");
		Thread.sleep(5000);
		boolean elementEnabled = driver
				.findElement(By.xpath("(//div[@class='yxt-SearchBar-buttonImage component'])[2]")).isEnabled();
		System.out.println(elementEnabled);
	}

	// isDisplayed() is the method used to verify the presence of a web element
	// within the web page.
	// Use of isDisplayed()
	@Test(enabled = false)
	public void testMen2() {
		boolean elementPresent = driver.findElement(By.xpath("(//a[text()='Men'])[1]")).isDisplayed();
		System.out.println(elementPresent);
	}

	// isSelected() is the method used to verify if the web element is selectable or
	// not. isSelected() method is predominantly used with radio buttons, dropdowns
	// and checkboxes.
	// not working, I have to look on it.
	@Test(enabled = false)
	public void findADocotorByPrimaryCareTest() {
		driver.get("https://www.mountsinai.org/");
		boolean elementSelected = driver.findElement(By.xpath("(//span[text()='Primary Care'])[1]")).isSelected();
		System.out.println(elementSelected);
	}
    
	// invocation count == how many times test a single test, timeout = range of time, threadpoolsize=?
	@Test(enabled = false, threadPoolSize = 3, invocationCount = 3, timeOut = 60000)
	public void urgentCareTest() throws InterruptedException {
		driver.get("https://www.mountsinai.org/");
		driver.findElement(By.xpath(
				"//span[contains(text(),'Urgent Care')]//parent::a[@class='hpcards__container--a']//parent::div[@class='hpcards__container--content']"))
				.click();
		Thread.sleep(5000);
	}

	// Use of Select class for dropdown by visible text
	//Use Of selectByVisibleText
	@Test(enabled = false)
	public void selectAlexaSkillsTest() {
		driver.get("https://www.amazon.com/");
		WebElement webElement = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
		Select dropdown = new Select(webElement);
		dropdown.selectByVisibleText("Alexa Skills");

	}
    // visible text is mostly used
	// Use of Select class for dropdown by index
	@Test(enabled = true)
	public void selectAppliances() {
		driver.get("https://www.amazon.com/");
		WebElement webElement = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
		Select dropdown = new Select(webElement);
		dropdown.selectByIndex(6);  //Appliances

	}
	//not working, I have to look
	// Use of Select class for dropdown by value
	@Test(enabled = false)
	public void selectArtsCraftsAndSewing() {
		driver.get("https://www.amazon.com/");
		WebElement webElement = driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect']"));
		Select dropdown = new Select(webElement);
		dropdown.deselectByValue("search-alias=arts-crafts");

	}

	//use of Hover Over
	@Test(enabled = false, priority = 1)
	public void testAboutUs() throws InterruptedException {
		driver.get("https://www.mountsinai.org/");
		Actions builder = new Actions(driver);
		WebElement aboutUs = driver
				.findElement(By.xpath("//a[@class='hidden-xs dropdown' and contains(text(),'About Us')]"));
		Thread.sleep(2000);
		builder.moveToElement(aboutUs).build().perform();
		Thread.sleep(2000);
		System.out.println(aboutUs.getText());
	}

	@Test(enabled = true, priority = 2)
	public void testListOfAboutUs() throws Exception {
		driver.get("https://www.mountsinai.org/");
		Actions builder = new Actions(driver);
		WebElement aboutUs = driver
				.findElement(By.xpath("//a[@class='hidden-xs dropdown' and contains(text(),'About Us')]"));
		Thread.sleep(2000);
		builder.moveToElement(aboutUs).build().perform();
		Thread.sleep(2000);
		System.out.println(aboutUs.getText());
		List<WebElement> list = driver.findElements(
				By.xpath("//span[contains(text(),'About Us')]//following-sibling::div[@class='menu-content']//a")); // see
																													// elements!
		int totalCount = list.size();
		System.out.println(totalCount);
		for (int i = 0; i < totalCount; i++) {
			System.out.println(list.get(i).getText());
		}
	}

	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}

}
