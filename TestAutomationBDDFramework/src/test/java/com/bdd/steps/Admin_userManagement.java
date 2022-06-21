package com.bdd.steps;
import static com.bdd.variables.GlobalVariables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.bdd.steps.CommonSteps.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Admin_userManagement {
	@Test
	@Given("user should navigate to admin {string} menu and then to user management {string} menu")
	public void user_should_navigate_to_admin_menu_and_then_to_user_management_menu(String string, String string2) {
		WebElement l = cdriver.findElement(By.id(string));
	    if(l.isDisplayed()) {
	    	moveToElement(string);
	    	l.click();
	    	moveToElement(string2);
	    	cdriver.findElement(By.id(string2)).click();    	
	    }
	}
	@Given("verify if user is user successfully navigated")
	public void verify_if_user_is_user_successfully_navigated() {
		Assert.assertEquals(cdriver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers#");
    	System.out.println("Navigation Successful");
	}
	

	@Then("Verify if all the fields are displayed")
	public void verify_if_all_the_fields_are_displayed() {
		List<String> tempList = new ArrayList<String>();
	    
	    for (String string : gloAdminUserManagementElements) {
			if(cdriver.findElement(By.id(string)).isDisplayed()) {
				tempList.add(string);
			}
		}
	    Assert.assertEquals(tempList.toArray(), gloAdminUserManagementElements);
	}
	
	@Then("Verify if the table is displayed and populated with values")
	public void verify_if_the_table_is_displayed_and_populated_with_values() {
		
		//Verify Table Headers
		List<String> locArrayToStoreMenuItems = new ArrayList<>();

		List<WebElement> mainMenuOption = cdriver.findElements(By.className("header"));

		// insert all the element values in local array for comparison

		for (int i = 0; i < mainMenuOption.size(); i++) {
			locArrayToStoreMenuItems.add(mainMenuOption.get(i).getText());
			//System.out.println(mainMenuOption.get(i).getText());
		}
		
		Assert.assertTrue(Arrays.equals(locArrayToStoreMenuItems.toArray(), gloAdminUserManagementTableHeaders));
		
		
		
		//Verify if the table contents are displayed
	   List<WebElement> odd = cdriver.findElements(By.xpath("//tr[@class=\"odd\"]"));
	   List<WebElement> even = cdriver.findElements(By.xpath("//tr[@class=\"even\"]"));
	   Assert.assertTrue((odd.size() >0 && even.size()>0), "Row values are higher than 0 " + odd.size() +" " + even.size()); 
	}

	
	
	public void moveToElement(String string) {
		Actions a = new Actions(cdriver);
		WebElement l = cdriver.findElement(By.id(string));
		a.moveToElement(l).perform();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
