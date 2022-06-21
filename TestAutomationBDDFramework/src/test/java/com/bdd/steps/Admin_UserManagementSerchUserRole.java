package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Admin_UserManagementSerchUserRole {
	@Given("user select {string} from User role dropdown")
	public void user_select_from_user_role_dropdown(String string) {
		WebElement userRole = cdriver.findElement(By.id("searchSystemUser_userType"));
		Select select = new Select(userRole);
		select.selectByVisibleText(string);
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cdriver.findElement(By.id("searchBtn")).click();
	}

	@Then("Verify only employees with {string} role is displayed")
	public void verify_only_employees_with_role_is_displayed(String string) {
		List<WebElement> userRoleSearchResult = cdriver.findElements(By.xpath("//tbody//tr//td[3]"));
		if (string.equals("All")) {
			for (WebElement webElement : userRoleSearchResult) {
				if (webElement.getText().equals("Admin") || webElement.getText().equals("ESS")) {
					// System.out.println(webElement.getText());
				} else {
					System.out.println("Search Failed");
				}

			}
		} else {

			for (WebElement webElement : userRoleSearchResult) {
				if (webElement.getText().equals(string)) {
					// System.out.println(webElement.getText());
				} else {
					System.out.println("Search Failed");
				}

			}
		}
	}
}
