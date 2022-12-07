package AutomationProject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeSceenShot {

	@Test
	public void screenShot() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		TakesScreenshot t = (TakesScreenshot)driver;
		//String text = result.getName();
	//	TakesScreenshot t =  (TakesScreenshot)driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		 String desti = System.getProperty("user.dir")+"\\screenshots\\123.png";
		//File dest= new File("C:\\Users\\psyas\\eclipse-workspace\\End2EndProject\\screenshots\\ss.png");
		try{
			FileUtils.copyFile(src, new File(desti));
		}
		catch(Exception e) {
			
		}
		
		
	}
}
