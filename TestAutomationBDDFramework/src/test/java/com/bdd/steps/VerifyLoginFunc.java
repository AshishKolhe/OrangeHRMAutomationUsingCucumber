package com.bdd.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.bdd.variables.GlobalVariables.*;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLoginFunc {

	Actions a = new Actions(cdriver);
	JavascriptExecutor js = (JavascriptExecutor) cdriver;

	@When("enter user name as {string} and password as {string}")
	public void enter_user_name_as_and_password_as(String string, String string2) {

		// find user name field and enter user name
		WebElement userNameField = cdriver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		userNameField.click();
		userNameField.sendKeys(string);

		// Find password field and enter password
		WebElement passwordField = cdriver.findElement(By.id("txtPassword"));
		passwordField.click();
		passwordField.sendKeys(string2);

		// Click on Submit button
		cdriver.findElement(By.id("btnLogin")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("user should be able to login {string}")
	public void user_should_be_able_to_login(String string) {

		// If login is successful
		if (string.equals("successful")) {
			String tempRedirectUrl = cdriver.getCurrentUrl();
			if (tempRedirectUrl.contains("dashboard")) {
				System.out.println("login succesful" + tempRedirectUrl);
			} else {
				System.out.println("login unsuccessful" + tempRedirectUrl);
			}
		}

		// if login is unsuccessful
		if (string.equals("unsuccessful")) {
			String unsuccLogin = cdriver.findElement(By.xpath("//span[@id=\"spanMessage\"]")).getText();
			String unsuccUrl = cdriver.getCurrentUrl();
			if (unsuccLogin.contains("Invalid credentials") && unsuccUrl.contains("validateCredentials")) {
				System.out.println("login unsuccessful " + unsuccLogin + cdriver.getCurrentUrl());

			}
		}
		//cdriver.switchTo().defaultContent();
	}

	@Then("user should be able to logout after {string} status in {string} browser")
	public void user_should_be_able_to_logout_after_status_in_browser(String string, String string2) throws InterruptedException {
		if (string.equals("successful")) {
			if (string2.equals("firefox")) {
				System.out.println("firefox function");
				firefoxLogout();
			} else {
				NormalLogout(string);
			}
		}
		else {
			System.out.println("login unsuccessful no need to logout");
		}
		
	}
	
	@Then("close the driver")
	public void close_the_driver() {
		//cdriver.close();
		cdriver.quit();
	}

	public void firefoxLogout() throws InterruptedException {

		//Logout functionality for firefox is different because firefox is not able to identify element and click on it.  Hence Javascript executor is used to click on the link
		
		WebElement b = cdriver.findElement(By.xpath("//*[@id=\"welcome\"]"));
		js.executeScript("arguments[0].click();", b);

		new WebDriverWait(cdriver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();

		Thread.sleep(2000);
		if (cdriver.getCurrentUrl().contains("login")) {
			System.out.println("successfully logged out " + cdriver.getCurrentUrl());
		}

	}

	public void NormalLogout(String string) {
		
		// logout functionality for chrome and edge.
		
		if (string.equals("successful")) {

			//cdriver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
			new WebDriverWait(cdriver, 20).until(ExpectedConditions.elementToBeClickable(By.id("welcome"))).click();
			new WebDriverWait(cdriver, 20).until(ExpectedConditions.elementToBeClickable(By.linkText("Logout"))).click();
			new WebDriverWait(cdriver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id("btnLogin")));
			
			if (cdriver.getCurrentUrl().contains("login")) {
				System.out.println("successfully logged out " + cdriver.getCurrentUrl());
			}
		}
	}
	
}
