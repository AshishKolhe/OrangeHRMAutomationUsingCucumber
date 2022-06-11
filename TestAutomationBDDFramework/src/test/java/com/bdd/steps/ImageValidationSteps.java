package com.bdd.steps;

import org.openqa.selenium.By;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.bdd.variables.GlobalVariables.*;

public class ImageValidationSteps {
	
		
	@When("user clicks on search bar")
	public void user_clicks_on_search_bar() {
		//Searching for the string
		cdriver.findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys("park");
		//clicking on search buttons
		cdriver.findElement(By.xpath("//button[@class=\"Tg7LZd\"]")).click();
	}
	@Then("verify search term is entered")
	public void verify_search_term_is_entered() {
	    String redirectedUrl = cdriver.getCurrentUrl();
	    if(redirectedUrl.contains("q=park") && redirectedUrl.contains("sclient=img")) {
	    	System.out.println("test passed  :" + redirectedUrl );
	    }else {
	    	System.out.println("test Failed  :" + redirectedUrl );
	    }
	    
	}
}
