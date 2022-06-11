package com.bdd.variables;

import org.openqa.selenium.WebDriver;

public class GlobalVariables {
	public static WebDriver cdriver;
	
		//Smoke test variables
		public static String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		public static String[] gloMainMenuOption = {"Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Buzz"};
		public static String gloAdminMenuItems = "\"menu_admin_UserManagement\"";
		
	   // AddUserWebElement
		public static String userType = "//select[@id=\"systemUser_userType\"]";
		public static String empName = "//input[@id=\"systemUser_employeeName_empName\"]";
		public static String userName = "//input[@id=\"systemUser_userName\"]";
		public static String userStatus = "//*[@id=\"systemUser_status\"]";
		public static String userPassword = "//input[@id=\"systemUser_password\"]";
		public static String userConfPassword = "//input[@id=\"systemUser_confirmPassword\"]";
		public static String pageHeading = "//h1[@id=\"UserHeading\"]";
		public static String buttonSave = "//input[@id=\"btnSave\"]";
		public static String buttonCancel = "//input[@id=\"btnCancel\"]";
		public static String errorMsgEmpName = "//span[@for=\"systemUser_employeeName_empName\"]";
		public static String errorMsgUserName = "//span[@for=\"systemUser_userName\"]";
		public static String errorMsgPassword = "//span[@for=\"systemUser_password\"]";
		public static String empNameSuggestionDropdown = "//div[@class=\"ac_results\"]";
		public static String empNameSearchDropdown = "//div[@class=\"ac_results\"]";
	
}
