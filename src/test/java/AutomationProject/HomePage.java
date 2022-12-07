package AutomationProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends Base {

	// WebDriver driver;

	@BeforeTest
	public void startBrowser() throws IOException {
		driver = initializeDriver();
		// driver.get("https://demo.actitime.com/login.do");
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void openBrowser(String username, String password) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		LandingPage p = new LandingPage(driver);

		LoginPage lp = p.getLogin();
		lp.emailTextField().sendKeys(username);
		lp.passwordTextField().sendKeys(password);
		lp.loginButton();
		ForgotPassword fp = lp.forgotPassword();
		fp.emailTextField().sendKeys(username);
		fp.sendInstructions().click();

		// LoginPage l = new LoginPage(driver);
		// Thread.sleep(2000);
		// l.emailTextField().sendKeys(username);
		// Thread.sleep(2000);
		// l.passwordTextField().sendKeys(password);
		// Thread.sleep(2000);
		// l.loginButton().click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "nonregestered1@gamiul.com";
		data[0][1] = "invalidpassword";

		data[1][0] = "nonregestered2@gamiul.com";
		data[1][1] = "invalidpassword";

		return data;
	}

}
