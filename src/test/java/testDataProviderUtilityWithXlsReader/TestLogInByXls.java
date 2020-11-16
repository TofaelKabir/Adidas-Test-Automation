package testDataProviderUtilityWithXlsReader;

import dataProviderUtilityWithXlsReader.LogInByXls;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.adidas.qa.test.base.BasePage;
import com.adidas.qa.test.pages.HomePage;


public class TestLogInByXls extends LogInByXls {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	HomePage homePage;
	JavascriptExecutor js;
	LogInByXls logInByXls;

    @BeforeMethod
    public void initializePageObject() {
    	basePage = new BasePage();
		prop = basePage.init_properties();
		driver = basePage.init_driver(prop);
        logInByXls = PageFactory.initElements(driver, LogInByXls.class);
    }

    @Test(dataProvider = "supplyDataExcel")
    public void loginTestWithDataProvider(String email, String passCode) throws Exception {
        logInByXls.logInByDataProvider(email,passCode);
        
    }
    @AfterTest
	public void quitBrowser() {
		driver.quit();
	}


}
