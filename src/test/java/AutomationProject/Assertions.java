package AutomationProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assertions extends Base {

	WebDriver driver;
	LandingPage p;

	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
		// driver.get("https://demo.actitime.com/login.do");
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void openBrowser() throws Exception {

		 p = new LandingPage(driver);
		p.getTitle().getText();
		Assert.assertEquals(p.getTitle().getText(), "FEATURED COURSES");
		// checking navigation bar is enabled or not
		// p.getNavigationBar().isEnabled();
		Assert.assertTrue(p.getNavigationBar().isDisplayed());
		// Assert.assertFalse(p.getNavigationBar().isDisplayed());

	}

	@Test
	public void checkheader()  {
		p = new LandingPage(driver);
		System.out.println(p.getHeader().getText());
		Assert.assertEquals(p.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
