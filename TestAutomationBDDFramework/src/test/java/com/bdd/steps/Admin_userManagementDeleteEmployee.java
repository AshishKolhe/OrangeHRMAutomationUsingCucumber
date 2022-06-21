package com.bdd.steps;
import static com.bdd.variables.GlobalVariables.cdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Admin_userManagementDeleteEmployee {
	
	List<String> tempList = new ArrayList<String>();
	String empName = "";
	WebDriverWait wait = new WebDriverWait(cdriver, 10);
	
	@Given("user selects an employee to delete")
	public void user_selects_an_employee_to_delete() {
		
		List<WebElement> userEmployee = cdriver.findElements(By.xpath("//tbody//tr//td[3][text()=\"ESS\"]//following-sibling::td[1]"));
		for (WebElement webElement : userEmployee) {
			tempList.add(webElement.getText());
		}
		
		empName = getRandomEmployee(tempList);
		System.out.println(empName);
		WebElement isCheckbox = cdriver.findElement(By.xpath("//td[text()=\"" +empName +"\"]/preceding-sibling::td[3]"));
		isCheckbox.click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
	}
	
	
	@Then("deletion shoulb be successful")
	public void deletion_shoulb_be_successful() {
		
		cdriver.findElement(By.id("btnDelete")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialogDeleteBtn")));
		
		cdriver.findElement(By.id("dialogDeleteBtn")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> userEmployee = cdriver.findElements(By.xpath("//tbody//tr//td[4]"));

		for (WebElement webElement : userEmployee) {
			tempList.add(webElement.getText());
		}
		
		if(tempList.contains(empName)) {
			System.out.println("employee deleted");
		}else {
			System.out.println("Employee not deleted");
		}
		empName="";
	}
	
	@Then("user cancels the deletion")
	public void user_cancels_the_deletion() {
		
		cdriver.findElement(By.id("btnDelete")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='btn reset']")));
		
		cdriver.findElement(By.xpath("//input[@class='btn reset']")).click();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	   
	}
	@Then("Employe should be displayed in the table")
	public void employe_should_be_displayed_in_the_table() {
	 
		List<WebElement> userEmployee = cdriver.findElements(By.xpath("//tbody//tr//td[4]"));

		for (WebElement webElement : userEmployee) {
			tempList.add(webElement.getText());
		}
		System.out.println(empName);
		if(tempList.contains(empName)) {
			System.out.println("employee not deleted");
		}else {
			System.out.println("Employee deleted");
		}
	}
	
	
	
	public String getRandomEmployee(List<String> tList) {

		Random ramdom = new Random();

		String temp = tList.get(ramdom.nextInt(tList.size()));
		int i = 0;
		for (String string : tList) {
			if(temp.equals(string)) {
				i++;
			}
			
		}
		if(i>1) {
			getRandomEmployee(tempList);
		}
		return temp;
	}

}
