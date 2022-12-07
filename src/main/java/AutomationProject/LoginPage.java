package AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	
	By email = By.id("user_email");
	By password = By.id("user_password");
	By loginButton = By.xpath("//input[@value=\"Log In\"]");
	By forgotPassword = By.cssSelector("[href*='password']");

	LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailTextField() {

		return driver.findElement(email);
	}

	public WebElement passwordTextField() {

		return driver.findElement(password);
	}

	public WebElement loginButton() {

		return driver.findElement(loginButton);
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return  new ForgotPassword(driver);
	}
}
