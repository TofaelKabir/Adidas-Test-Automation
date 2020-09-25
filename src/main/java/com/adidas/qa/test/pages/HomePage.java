package com.adidas.qa.test.pages;

import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.util.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	By logo = By.xpath("//a[@data-auto-id='logo']"); //adidas
	//By logo = By.xpath("//div[@class='lowes-logo']");  //from Lowes
	

	@FindBy(xpath = "//input[@data-auto-id='searchinput']") //adidas
	//@FindBy(xpath = "//input[@id='search-query']") //from Lowes
	
	public static WebElement searchField;

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

}

