package dataProviderUtilityWithXlsReader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import com.adidas.qa.test.base.BasePage;
import java.util.ArrayList;
import java.util.Iterator;

public class LogInByXls extends BasePage {

	@FindBy(xpath = "//a[text()='Log in']")
	public static WebElement login;
	
	@FindBy(xpath = "//input[@id='login-email']")
	public static WebElement emailField;
	
	@FindBy(xpath = "//input[@id='login-password']")
	public static WebElement passwordField;
	
	@FindBy(xpath = "//button[@class='gl-cta gl-cta--primary']//parent::div[@class='gl-vspace-bpall-small']")
	public static WebElement logInSubmitButton;

	@DataProvider
	public Iterator<Object[]> supplyDataExcel() {
		ArrayList<Object[]> testDataExcel = XlsDataReaderUtil.getDataFromExcel();
		return testDataExcel.iterator();
	}

	public void logInByDataProvider(String email, String password) throws Exception {
		Thread.sleep(5000);
		login.click();
		Thread.sleep(5000);
		emailField.sendKeys(email);
		Thread.sleep(5000);
		passwordField.sendKeys(password);
		Thread.sleep(5000);
		logInSubmitButton.click();
	}

}
