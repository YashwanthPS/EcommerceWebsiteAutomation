package AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

	WebDriver driver;
	By login = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//div[@class=\"text-center\"]/h2");
	By navigationBar = By.xpath("//nav[@class=\"navbar-collapse collapse\"]");
	By header = By.cssSelector("div[class*='banner'] h3");

	LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLogin() {

		  driver.findElement(login).click();
		return new LoginPage(driver);
		
	}

	// //div[@class="text-center"]/h2

	public WebElement getTitle() {

		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar() {

		return driver.findElement(navigationBar);
	}
	
	public WebElement getHeader() {

		return driver.findElement(header);
	}
	
}
