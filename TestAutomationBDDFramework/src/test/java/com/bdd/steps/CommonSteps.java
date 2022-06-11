package com.bdd.steps;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static com.bdd.implementation.AppAccess.*;
import static com.bdd.variables.GlobalVariables.cdriver;

import java.util.concurrent.TimeUnit;

public class CommonSteps {
	WebDriver cdriver;
	Logger logger = Logger.getLogger(getClass());
	@Given("user navigates to {string}")
	public void user_navigates_to(String string)  {
		
		
		logger.info("info message execution");
		logger.error("error message");
		logger.fatal("fatal message");
		logger.warn("warn message");
		accessapplication(string);
	    System.out.println("In given step");
	}
	
	public void waitSeconds(int seconds) {
		cdriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	@And("close the browser")
	public void closeTheBrowser()  {
		cdriver.close();
		cdriver.quit();
	}

}
