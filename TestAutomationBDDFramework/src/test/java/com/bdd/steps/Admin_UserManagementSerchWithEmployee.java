package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.cdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Then;

public class Admin_UserManagementSerchWithEmployee {

	List<String> tempList = new ArrayList<String>();

	@Then("user selects Employee name and click on search")
	public void user_selects_employee_name_and_click_on_search() {
		List<WebElement> userEmployee = cdriver.findElements(By.xpath("//tbody//tr//td[4]"));

		for (WebElement webElement : userEmployee) {
			tempList.add(webElement.getText());
		}

		cdriver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(getRandomEmployee(tempList));
		cdriver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys(Keys.ENTER);

		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		cdriver.findElement(By.id("searchBtn")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tempList.clear();
	}

	@Then("verify only {int} row with selected employee should be displayed")
	public void verify_only_row_with_selected_employee_should_be_displayed(Integer int1) {
		List<WebElement> employeeeSearchResult = cdriver.findElements(By.xpath("//tbody//tr//td[4]"));
		for (WebElement webElement : employeeeSearchResult) {
			tempList.add(webElement.getText());
		}

		Assert.assertTrue(tempList.size() == int1, "only  " + int1 + " result displayed");
	}

	@Then("verify that after clicking on Reset the search menu selection should show default values")
	public void verify_that_after_clicking_on_reset_the_search_menu_selection_should_show_default_values() {

		List<String> tempStatusSelOption = new ArrayList<String>();	{{tempStatusSelOption.add("All");}};
		List<String> tempRoleSelOption = new ArrayList<String>() ;	{{tempRoleSelOption.add("All");}};

		List<String> tempStatusSelOptionWE = new ArrayList<String>();
		List<String> tempRoleSelOptionWE = new ArrayList<String>();

		cdriver.findElement(By.id("resetBtn")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement userStatus = cdriver.findElement(By.id("searchSystemUser_status"));
		Select selectStatus = new Select(userStatus);

		WebElement userRole = cdriver.findElement(By.id("searchSystemUser_userType"));
		Select selectRole = new Select(userRole);

		List<WebElement> i = selectRole.getAllSelectedOptions();
		for (WebElement webElement : i) {
			tempRoleSelOptionWE.add(webElement.getText());
		}

		List<WebElement> j = selectStatus.getAllSelectedOptions();
		for (WebElement webElement : j) {
			tempStatusSelOptionWE.add(webElement.getText());
		}

		Assert.assertEquals(cdriver.findElement(By.id("searchSystemUser_userName")).getText(), "");
		Assert.assertEquals(cdriver.findElement(By.id("searchSystemUser_employeeName_empName")).getText(), "");
		Assert.assertEquals(tempStatusSelOption, tempStatusSelOptionWE);
		Assert.assertEquals(tempRoleSelOption, tempRoleSelOptionWE);

	}
	//Function to chose random emp name
	public String getRandomEmployee(List<String> tList) {

		Random ramdom = new Random();

		String temp = tList.get(ramdom.nextInt(tList.size()));
		if (temp.contains("Admin A")) {
			getRandomEmployee(tempList);
		}
		return temp;
	}
}
