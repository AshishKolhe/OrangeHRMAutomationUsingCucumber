package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.cdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Admin_UserManagementSearchUserStatus {
	@Given("user select {string} from user status dropdown")
	public void user_select_from_user_status_dropdown(String string) {
		WebElement userStatus = cdriver.findElement(By.id("searchSystemUser_status"));
		Select select = new Select(userStatus);
		select.selectByVisibleText(string);
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cdriver.findElement(By.id("searchBtn")).click();
	}
	@Then("Verify only employees with Status {string} status is displayed")
	public void verify_only_employees_with_status_status_is_displayed(String string) {
		List<WebElement> userRoleSearchResult = cdriver.findElements(By.xpath("//tbody//tr//td[5]"));
		if (string.equals("All")) {
			for (WebElement webElement : userRoleSearchResult) {
				if (webElement.getText().equals("Enabled") || webElement.getText().equals("Disabled")) {
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
