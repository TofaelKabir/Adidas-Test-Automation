package com.adidas.qa.test.pages;

import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	//this is one way to write
	By logo = By.xpath("//a[@data-auto-id='logo']"); //adidas
	
	//this is second way to write (most common)	
	@FindBy(xpath = "//input[@placeholder='Search']") //adidas
	WebElement searchField;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForElementPresent(logo); // better to use something which is present in home page

	}

	public String getHomePageTitle() {
		return elementUtil.doGetTitle();
	}

	public boolean verifyApplicationLogo() {
		return elementUtil.doIsDisplayed(logo);
	}

	public void checkSearchField() {
		searchField.click();
	}
	
	
	
	@FindBy(xpath = "//a[text()='Help']//parent::div")
	WebElement help;
	
	public void checkHelp() {
		help.click();
	}
	
	@FindBy(xpath = "//a[text()='Exchanges & Returns']")
	WebElement exchang;
	
	public void checkExchange() {
		exchang.click();
	}

}

