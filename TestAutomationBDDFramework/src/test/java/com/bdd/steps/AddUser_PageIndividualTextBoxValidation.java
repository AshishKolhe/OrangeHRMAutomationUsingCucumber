package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddUser_PageIndividualTextBoxValidation {

	Logger log = Logger.getLogger(getClass());

	String selectedEmpName;

	int min = 1;
	int max = 100;
	int b = (int) (Math.random() * (max - min + 1) + min);
	String B = String.valueOf(b);

	@And("^user tried to enter the name which is not in the list$")
	public void userTriedToEnterTheNameWhichIsNotInTheList() {

		String incorrectEmpName = "vwxyz";
		log.error("validating emp name");

		cdriver.findElement(By.xpath(empName)).sendKeys(incorrectEmpName);
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String errorMessageEmployeeName = cdriver.findElement(By.xpath(errorMsgEmpName)).getText();
		String errorMessageEmployeeNameColor = cdriver.findElement(By.xpath(errorMsgEmpName)).getCssValue("color");
		System.out.println(errorMessageEmployeeName + " " + Color.fromString(errorMessageEmployeeNameColor).asHex());

		log.error(errorMessageEmployeeName + " " + Color.fromString(errorMessageEmployeeNameColor).asHex());
		log.error("validating emp name- completed");

	}

	@And("^user tried to enter the name which exists in the list$")
	public void userTriedToEnterTheNameWhichExistsInTheList() {
		String correctEmpName = "k";
		cdriver.findElement(By.xpath(empName)).clear();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath(empName)).sendKeys(correctEmpName);
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement empNameSearchDD = cdriver.findElement(By.xpath(empNameSearchDropdown));
		// wait.until(ExpectedConditions.visibilityOf(empNameSearchDD));
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		List<WebElement> optionsToSelect = empNameSearchDD.findElements(By.tagName("li"));

		int g = generateRamdon(optionsToSelect.size());
		selectedEmpName = (optionsToSelect.get(g)).getText().toLowerCase().replace(" ", "");
		optionsToSelect.get(g).click();

		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("selected text " + selectedEmpName);

	}

	@Then("user name selected in user name field")
	public void user_name_selected_in_user_name_field() {
		String userNameNewString = selectedEmpName.concat(B);
		cdriver.findElement(By.xpath(userName)).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath(userName)).sendKeys(userNameNewString);
	}

	@Then("password {string} entered in both password field")
	public void password_entered_in_both_password_field(String string) {
		cdriver.findElement(By.xpath(userPassword)).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath(userPassword)).sendKeys(string);

		cdriver.findElement(By.xpath(userConfPassword)).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		cdriver.findElement(By.xpath(userConfPassword)).sendKeys(string);
	}

	@Then("click on {string} button")
	public void click_on_button(String string) {
		string = buttonSave;
		cdriver.findElement(By.xpath(string)).click();
		cdriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Then("verify sucessful navigation to {string}")
	public void verify_sucessful_navigation_to(String string) {
		
		if(isloadComplete(cdriver)) {
		if(cdriver.getCurrentUrl().equals(string)){
			System.out.println("successfully created");
		}
		else {
			
			click_on_button(buttonSave);
			cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			verify_sucessful_navigation_to(string);
		}
		}
	}

	public int generateRamdon(int size) {
		int c = 0;
		int d = size;
		int f = (int) (Math.random() * (c - d + 1) + d);
		return f;
	}

	public static boolean isloadComplete(WebDriver cdriver) {
		return ((JavascriptExecutor) cdriver).executeScript("return document.readyState").equals("loaded")
				|| ((JavascriptExecutor) cdriver).executeScript("return document.readyState").equals("complete");
	}
}
