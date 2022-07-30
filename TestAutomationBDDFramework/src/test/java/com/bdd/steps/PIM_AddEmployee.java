package com.bdd.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import static com.bdd.variables.GlobalVariables.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIM_AddEmployee {

	Logger log = Logger.getLogger("newLogger");
	WebDriverWait w = new WebDriverWait(cdriver, 3);
	SoftAssert s = new SoftAssert();
	String empId = "";
	String empFistNameInput = "";
	String empLastNameInput = "";
	int randomNum;
	String[] name = gloRandomName[randomNumberGenerator()].split("\\s+");
	

	@And("^user navigates to PIM -> employee list tag$")
	public void userNavigatesToPIMEmployeeListTag() {
		log.info("Entering PIM Module");
		log.info("Searching for PIM module and clicking on it");

		// Below code makes sure that the navigation to PIM is successful before moving
		// to next step

		boolean condition = true;
		int i = 0;

		while (condition && (i < 5)) {
			w.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewPimModule"))).click();
			String redUrl = cdriver.getCurrentUrl();

			if (redUrl.contains("viewEmployeeList")) {
				condition = false;
				i++;
				log.info(condition + "  " + i);
			} else {
				condition = true;
			}

			log.info("PIM module element found and clicked");

			//s.assertEquals(redUrl, "https://opensource-demo.orangehrmlive.com/index.php/pim/viewEmployeeList",					"User redirected correctly");
			log.info("User redirected to = " + redUrl);
		}
		s.assertAll();
	}

	@And("^user clicks on Add button$")
	public void userClicksOnAddButton() {
		log.info("Entering module to click on Add button in PIM");

		w.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAdd"))).click();
		log.info("Entering module to click on Add button in PIM");

		String redUrl = cdriver.getCurrentUrl();

		s.assertEquals(redUrl, "https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee",
				"User redirected correctly");
		log.info("User redirected to = " + redUrl);
		
		s.assertAll();
	}

	@Then("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		
		string = name[0];
		string2 = name[1]; 
		
		empFistNameInput = string;
		empLastNameInput = string2;
		
		log.info("finding first name element and entering firstname");
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))).click();
		cdriver.findElement(By.id("firstName")).sendKeys(string);

		log.info("finding first name element and entering lastname");
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))).click();
		cdriver.findElement(By.id("lastName")).sendKeys(string2);
		
		
	}

	@Then("user uploads the photo")
	public void user_uploads_the_photo() throws InterruptedException {
		log.info("photo uploading");

		WebElement chooseFile = cdriver.findElement(By.id("photofile"));
		chooseFile.sendKeys("D:\\Learning\\git\\TestAutomationBDDFramework\\EmpImage.jpg");
		Thread.sleep(5000);
		log.info("file uploaded");
		
		
	}

	@Then("user clicks on Save button")
	public void user_clicks_on_save_button() {

		log.info("inside save button module");

		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnSave"))).click();
		log.info("inside save button module");
		
	}

	@And("^capture assigned empid$")
	public void captureAssignedEmpid() {

		// w.until(ExpectedConditions.presenceOfElementLocated(By.id("employeeId")));

		empId = cdriver.findElement(By.id("employeeId")).getAttribute("value");
		log.info("new employee id assigned - " + empId);
		
		
	}

	@And("^user clicks on Save button without entering first name or last name$")
	public void userClicksOnSaveButtonWithoutEnteringFirstNameOrLastName() {
		
		//w.until(ExpectedConditions.presenceOfElementLocated(By.id("chkLogin"))).click();
		
		user_clicks_on_save_button();

		w.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='validation-error' and contains(@for, 'lastName')]")));
		w.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[@class='validation-error' and contains(@for, 'firstName')]")));
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("user_password")));
		
		

		String errorMsgFN = cdriver
				.findElement(By.xpath("//span[@class='validation-error' and contains(@for, 'firstName')]")).getText();
		String errorMsgLN = cdriver
				.findElement(By.xpath("//span[@class='validation-error' and contains(@for, 'lastName')]")).getText();

		WebElement t = cdriver
				.findElement(By.xpath("//span[@class='validation-error' and contains(@for, 'firstName')]"));
		String stf = t.getCssValue("color");
		String c = Color.fromString(stf).asHex();

		WebElement t1 = cdriver
				.findElement(By.xpath("//span[@class='validation-error' and contains(@for, 'lastName')]"));
		String stl = t1.getCssValue("color");
		String cl = Color.fromString(stl).asHex();

		System.out.println("first name color = " + c + "    " + "last name color = " + cl);

		s.assertEquals(errorMsgFN, "Required", "First name validation error passed");
		s.assertEquals(errorMsgLN, "Required", "Last name validation error passed");

		s.assertEquals(c, "#aa4935", "First name validation field boarder color correct");
		s.assertEquals(cl, "#aa4935", "First name validation field boarder color correct");
		s.assertAll();
		
		//w.until(ExpectedConditions.presenceOfElementLocated(By.id("chkLogin"))).click();
	}

	@And("^verify if new Employee is added$")
	public void verifyIfNewEmployeeIsAdded() throws InterruptedException {

		log.info("navigating to pim -> employee tab");
		userNavigatesToPIMEmployeeListTag();

		// Searching for the employee with emp id captured before
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("empsearch_id")));

		WebElement empsearchid = cdriver.findElement(By.id("empsearch_id"));
		empsearchid.click();
		empsearchid.sendKeys(empId);

		w.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn"))).click();

		Thread.sleep(1000);

		log.info("searching for newly created employee");

		// check only 1 row should be displayed for given employee id

		int countRows = cdriver.findElements(By.xpath("//*[@id=\"resultTable\"]//tbody//tr")).size();

		s.assertEquals(countRows, 1, "Only 1 row displayed in the result");
		log.info("Only one row displayed");

		String empid = cdriver.findElement(By.xpath("//*[@id=\"resultTable\"]//tbody//tr[1]//td[2]//a")).getText();
		String empFirstName = cdriver.findElement(By.xpath("//*[@id=\"resultTable\"]//tbody//tr[1]//td[3]//a")).getText();
		String empLastName = cdriver.findElement(By.xpath("//*[@id=\"resultTable\"]//tbody//tr[1]//td[4]//a")).getText();
		
		//System.out.println(empFistNameInput +empLastNameInput + empId  );
		//System.out.println(empFirstName +empLastName + empid  );
		
		s.assertEquals(empFistNameInput, empFirstName, "First Name Matched");
		s.assertEquals(empLastNameInput, empLastName, "Last Name Matched");
		s.assertEquals(empId, empid, "Emp id Matched");
		
		s.assertAll();

		log.info("new employee found");

	}

	@And("^user \"([^\"]*)\" create login details$")
	public void userCreateLoginDetails(String arg1) {

		if (arg1.equals("yes")) {

			w.until(ExpectedConditions.presenceOfElementLocated(By.id("chkLogin"))).click();
			

			if (w.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name"))).isDisplayed()
					&& w.until(ExpectedConditions.presenceOfElementLocated(By.id("user_password"))).isDisplayed()
					&& w.until(ExpectedConditions.presenceOfElementLocated(By.id("re_password"))).isDisplayed()
					&& w.until(ExpectedConditions.presenceOfElementLocated(By.id("status"))).isDisplayed()) {
				log.info("All element displayed");
				
				cdriver.findElement(By.id("user_name")).sendKeys(empFistNameInput+"_"+empLastNameInput);
				cdriver.findElement(By.id("user_password")).sendKeys(empFistNameInput+"_"+empLastNameInput);
				cdriver.findElement(By.id("re_password")).sendKeys(empFistNameInput+"_"+empLastNameInput);
				user_clicks_on_save_button();
				
			} else {
				log.info("login Details Not created");
			}
		}

	}
	
	public int randomNumberGenerator() {
		Random ramNum = new Random();
		randomNum = ramNum.nextInt(50);
		return randomNum;
	}
	
	
}
