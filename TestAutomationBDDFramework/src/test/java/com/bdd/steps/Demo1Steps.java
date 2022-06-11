package com.bdd.steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.bdd.variables.GlobalVariables.*;
import static com.bdd.utils.TakeScreenshot.*;

public class Demo1Steps {
	@When("user clicks on {string}")
	public void user_clicks_on(String linkName) {
		System.out.println(linkName);
	    cdriver.findElement(By.linkText(linkName)).click();
	} 	
	@Then("verify the title displayed correctly")
	public void verify_the_title_displayed_correctly() throws Exception {
	 String tempImg = cdriver.findElement(By.xpath("/html/body/div[1]/div[2]/div/span")).getText();
	 String pageTitle = cdriver.getTitle();
	 String pageUrl = cdriver.getCurrentUrl();
	 System.out.println(tempImg);
	 if(tempImg.equals("images") && pageTitle.equals("Google Images")) {
		 System.out.println("Image page loaded with URl  " + pageUrl);
		 takeSnapShot(cdriver, "D://Learning//Java//Screenshots/GoogleImage.png");
	 }
	 cdriver.quit();
	}
	
}
