package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class SmokeTestMainMenuLinkAvailability {

	@Then("user should be able to see all main menu options")
	public void user_should_be_able_to_see_all_main_menu_options() {

		List<WebElement> mainMenuOption = cdriver.findElements(By.className("firstLevelMenu"));

		for (WebElement webElement : mainMenuOption) {
			if (Arrays.asList(gloMainMenuOption).contains(webElement.getText())) {
				System.out.print(webElement.getText() + ",");
			} else {
				System.out.println(webElement.getText() + "not present");
			}

		}
	}

	@Then("user should be able to see all sub menu items for {string} menu")
	public void user_should_be_able_to_see_all_sub_menu_items_for_menu(String string) {
		List<WebElement> adminSubMenuItems = cdriver.findElements(By.xpath("//li[@class=\"main-menu-first-level-list-item\"]/ul/li/a"));
		for(WebElement webEle :adminSubMenuItems ) {
			System.out.print(webEle.getAttribute("value") + ",");
		}
		
	}
}
