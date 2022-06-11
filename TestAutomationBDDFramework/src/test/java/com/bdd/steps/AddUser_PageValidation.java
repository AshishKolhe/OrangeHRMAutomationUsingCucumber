package com.bdd.steps;
import static com.bdd.variables.GlobalVariables.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;

public class AddUser_PageValidation {
	SoftAssert  softAssert = new SoftAssert();
	
	@Test
	@And("click on Save without entering any values")
	
	
	
	public void click_On_Save_Without_Entering_AnyValues()  {
		
		//clicking on Save button without entering any values
		cdriver.findElement(By.xpath(buttonSave)).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Validating error messages
		String errorMessageEmployeeName = cdriver.findElement(By.xpath(errorMsgEmpName)).getText();
		String errorMessageEmployeeNameColor = cdriver.findElement(By.xpath(errorMsgEmpName)).getCssValue("color");
		String errorMessageUserName = cdriver.findElement(By.xpath(errorMsgUserName)).getText();
		String errorMessageUserNameColor = cdriver.findElement(By.xpath(errorMsgUserName)).getCssValue("color");
		String errorMessagePassword = cdriver.findElement(By.xpath(errorMsgPassword)).getText();
		String errorMessagePasswordColor = cdriver.findElement(By.xpath(errorMsgPassword)).getCssValue("color");
		
		String errMsgEmpNameColor = Color.fromString(errorMessageEmployeeNameColor).asHex();
		String errMsgUserNameColor = Color.fromString(errorMessageUserNameColor).asHex();
		String errMsgPasswordColor = Color.fromString(errorMessagePasswordColor).asHex();
		
		
		softAssert.assertEquals(errorMessageEmployeeName, "Employee does not exist", "Employee name error message matched");
		softAssert.assertEquals(errorMessageUserName, "Required", "User Name error message Matched");
		softAssert.assertEquals(errorMessagePassword, "Required","password error message Matched");
		softAssert.assertEquals(errMsgEmpNameColor,"#aa4935","Error color for emp name field matched");
		softAssert.assertEquals(errMsgUserNameColor,"#aa4935","Error color for username field matched");
		softAssert.assertEquals(errMsgPasswordColor,"#aa4935","Error color for password field matched");
		softAssert.assertAll();
		
		System.out.println(errorMessageEmployeeName + " " + errorMessageUserName + " " + errorMessagePassword );
		
	}

	@And("click on cancel without entering any values")
	public void click_On_Cancel_Without_Entering_AnyValues()  {
		
		String urlBeforeCancel = cdriver.getCurrentUrl();
		System.out.println(urlBeforeCancel);
		
		cdriver.findElement(By.xpath(buttonCancel)).click();
		cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String urlAfterCancel = cdriver.getCurrentUrl();
		softAssert.assertEquals(urlAfterCancel, "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers?userId=");
		
		
	}

}
