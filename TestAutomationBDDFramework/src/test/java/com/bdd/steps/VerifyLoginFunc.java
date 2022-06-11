package com.bdd.steps;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import static com.bdd.variables.GlobalVariables.*;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyLoginFunc {

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

	}

	@Then("user should be able to logout after {string} status")
	public void user_should_be_able_to_logout_after_status(String string) {
		if (string.equals("successful")) {
		cdriver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(cdriver.getCurrentUrl().contains("login")) {
			System.out.println("successfully logged out " + cdriver.getCurrentUrl());
		}
		}
		cdriver.close();
		cdriver.quit();
	}

}
