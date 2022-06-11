package com.bdd.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static com.bdd.variables.GlobalVariables.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.en.Then;

public class AddUser {
	@Test
	@Then("User should be able to locate {string} button")
	public void user_should_be_able_to_locate_button(String string) {
		cdriver.findElement(By.xpath("//a[@id=\"menu_admin_viewAdminModule\"]")).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath("//input[@id=\"btnAdd\"]")).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("user should be navigate to {string}")
	public void user_should_be_navigate_to(String string) {
		String currUrl = cdriver.getCurrentUrl();
		if (currUrl.contains(string)) {
			System.out.println("current url " + currUrl);
		} else {
			System.out.println("navigation unsuccessful");
		}
	}

	@Then("all elements are displayed correctly")
	public void all_elements_are_displayed_correctly() {

		String userType = "//select[@id=\"systemUser_userType\"]";
		String empName = "//input[@id=\"systemUser_employeeName_empName\"]";
		String userName = "//input[@id=\"systemUser_userName\"]";
		String userStatus = "//*[@id=\"systemUser_status\"]";
		String userPassword = "//input[@id=\"systemUser_password\"]";
		String userConfPassword = "//input[@id=\"systemUser_confirmPassword\"]";
		String pageHeading = "//h1[@id=\"UserHeading\"]";
		String buttonSave = "//input[@id=\"btnSave\"]";
		String buttonCancel = "//input[@id=\"btnCancel\"]";

		// Check if all elements are displayed
		if (cdriver.findElement(By.xpath(userType)).isDisplayed()
				&& cdriver.findElement(By.xpath(empName)).isDisplayed()
				&& cdriver.findElement(By.xpath(userName)).isDisplayed()
				&& cdriver.findElement(By.xpath(userStatus)).isDisplayed()
				&& cdriver.findElement(By.xpath(userPassword)).isDisplayed()
				&& cdriver.findElement(By.xpath(userConfPassword)).isDisplayed()
				&& cdriver.findElement(By.xpath(pageHeading)).isDisplayed()
				&& cdriver.findElement(By.xpath(buttonSave)).isDisplayed()
				&& cdriver.findElement(By.xpath(buttonCancel)).isDisplayed()) {
			System.out.println("All elements displayed on the page");
		}
		// Check if the user type dropdown contains correct values
		checkDropDownValues(userType, "Admin", "ESS");

		// Check if the user status dropdown contains correct values
		checkDropDownValues(userStatus, "Enabled", "Disabled");

	}

	public void checkDropDownValues(String dropName, String firstValue, String secondValue) {
		WebElement userTypeDropdown = cdriver.findElement(By.xpath(dropName));
		Select sel = new Select(userTypeDropdown);

		List<WebElement> userTypeDropdownOption = sel.getOptions();

		if (userTypeDropdownOption.size() == 2) {

			for (WebElement webElement : userTypeDropdownOption) {
				if (webElement.getText().equals(firstValue) || webElement.getText().equals(secondValue)) {
					System.out.println("option " +  webElement.getText());

				}

			}

		}

	}
}
