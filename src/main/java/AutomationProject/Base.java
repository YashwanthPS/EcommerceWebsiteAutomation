package AutomationProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	WebDriver driver;
	Properties prop;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\psyas\\eclipse-workspace\\End2EndProject\\data.properties");
		prop = new Properties();
		prop.load(file);

	//	String browserName = System.getProperty("browser");
		 String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			// execute in Chrome browser
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\psyas\\eclipse-workspace\\End2EndProject\\drivers\\chromedriver.exe");
			// driver = WebDriverManager.chromedriver().create();

			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else {
			// execute in firefox driver
			System.setProperty("webdriver.chrome.driver", "./End2EndProject/drivers/geckodriver.exe");
			driver = WebDriverManager.firefoxdriver().create();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("headless");
//			driver = new FirefoxDriver(options);
//			// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		return driver;
		
		
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

}
