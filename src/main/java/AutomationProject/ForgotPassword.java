package AutomationProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;

	By email = By.id("user_email");
	By sendInstructions = By.cssSelector("input[type ='submit']");

	ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement emailTextField() {

		return driver.findElement(email);
	}

	public WebElement sendInstructions() {

		return driver.findElement(sendInstructions);
	}

}
