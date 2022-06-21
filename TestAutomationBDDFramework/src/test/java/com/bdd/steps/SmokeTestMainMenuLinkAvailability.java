package com.bdd.steps;

import static com.bdd.variables.GlobalVariables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;

public class SmokeTestMainMenuLinkAvailability {

	SoftAssert soft = new SoftAssert();
	Actions a = new Actions(cdriver);
	List<String> locArrayToStoreMenuItems = new ArrayList<>();

	@Test
	@Then("user should be able to see all main menu options")
	public void user_should_be_able_to_see_all_main_menu_options() {

		// Find all webelement with classname
		List<WebElement> mainMenuOption = cdriver.findElements(By.className("firstLevelMenu"));

		// insert all the element values in local array for comparison

		for (int i = 0; i < mainMenuOption.size(); i++) {
			locArrayToStoreMenuItems.add(mainMenuOption.get(i).getText());
			System.out.println(mainMenuOption.get(i).getText());
		}
		Assert.assertTrue(Arrays.equals(locArrayToStoreMenuItems.toArray(), gloMainMenuOption), "equal arrays");

		// clearing the list to be used in following methods
		locArrayToStoreMenuItems.clear();
	}

	@Test
	@Then("user should be able to see all sub menu items for {string} menu")
	public void user_should_be_able_to_see_all_sub_menu_items_for_menu(String string) {
		// finding whether user management element is available
		for (String str : gloMainMenuItemsById) {

			WebElement l = cdriver.findElement(By.id(str));
			a.moveToElement(l).perform();
			cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			boolean allFound = true;

			String[] tempStr = {};

			String[] strOfArr = str.split("_");

			// Below code is so set the value of emptry string to performance. This is a
			// design flaw in website and trying it work with reporting
			if (strOfArr[1].equals("")) {
				strOfArr[1] = "performance";
				System.out.println(strOfArr[1]);
			} else {
				System.out.println(strOfArr[1]);
			}
			switch (strOfArr[1]) {
			case ("admin"):
				tempStr = gloAdminSubMenuItemsById;
				break;
			case ("pim"):
				tempStr = gloPimSubMenuItemsById;
				break;
			case ("leave"):
				tempStr = gloLeaveSubMenuItemsById;
				break;
			case ("time"):
				tempStr = gloTimeSubMenuItemsById;
				break;
			case ("recruitment"):
				tempStr = gloRecruitmentSubMenuItemsById;
				break;
			case ("performance"):
				tempStr = gloPerformanceSubMenuItemsById;
				break;
			case ("maintenance"):
				tempStr = gloMaintenanceSubMenuItemsById;
			}

			for (String str1 : tempStr) {
				// System.out.println(str1);
				if (cdriver.findElement(By.id(str1)).isDisplayed()) {
					allFound = true;
				} else {
					allFound = false;
				}

			}
			if (allFound) {
				System.out.println("all elements displayed for " + strOfArr[1]);
			} else {
				System.out.println("not all elements displayed for " + strOfArr[1]);
			}
		}

	}

	@Test
	@Then("user should be able to see all children menu items")
	public void user_should_be_able_to_see_all_children_menu_items() {

		System.out.println("\n" + "For Admin Menu");
		getGrandchildrenMenuOptions("menu_admin_viewAdminModule", "menu_admin_UserManagement",
				gloAdminUserManagementSubMenuItems);
		getGrandchildrenMenuOptions("menu_admin_viewAdminModule", "menu_admin_Job", gloAdminJobSubMenuItems);
		getGrandchildrenMenuOptions("menu_admin_viewAdminModule", "menu_admin_Organization",
				gloAdminOrganizationSubMenuItems);
		getGrandchildrenMenuOptions("menu_admin_viewAdminModule", "menu_admin_Qualifications",
				gloAdminQualificationsSubMenuItems);
		getGrandchildrenMenuOptions("menu_admin_viewAdminModule", "menu_admin_Configuration",
				gloAdminConfigurationSubMenuItems);

		System.out.println("\n" + "For PIM Menu");
		getGrandchildrenMenuOptions("menu_pim_viewPimModule", "menu_pim_Configuration",
				gloPimConfigurationSubMenuItems);

		System.out.println("\n" + "For Leave Menu");
		getGrandchildrenMenuOptions("menu_leave_viewLeaveModule", "menu_leave_Entitlements",
				gloLeaveEntitlementsSubMenuItems);
		getGrandchildrenMenuOptions("menu_leave_viewLeaveModule", "menu_leave_Reports", gloLeaveReportsSubMenuItems);
		getGrandchildrenMenuOptions("menu_leave_viewLeaveModule", "menu_leave_Configure",
				gloLeaveConfigureSubMenuItems);

		System.out.println("\n" + "For Time Menu");
		getGrandchildrenMenuOptions("menu_time_viewTimeModule", "menu_time_Timesheets", gloTimeTimesheetSubMenuItems);
		getGrandchildrenMenuOptions("menu_time_viewTimeModule", "menu_attendance_Attendance",
				gloTimeAttendanceSubMenuItems);
		getGrandchildrenMenuOptions("menu_time_viewTimeModule", "menu_time_Reports", gloTimeReportSubMenuItems);
		getGrandchildrenMenuOptions("menu_time_viewTimeModule", "menu_admin_ProjectInfo",
				gloTimeProjectInfoSubMenuItems);

		
		System.out.println("\n" + "For Performance Menu");
		getGrandchildrenMenuOptions("menu__Performance", "menu_performance_Configure", gloPerformanceconfigureSubMenuItems);
		getGrandchildrenMenuOptions("menu__Performance", "menu_performance_ManageReviews", gloPerformanceManageReviewsSubMenuItems);
		
		
		System.out.println("\n" + "For Maintenance Menu");
		getGrandchildrenMenuOptions("menu_maintenance_purgeEmployee", "menu_maintenance_PurgeRecords", gloMaintenancePurgeRecordsSubMenuItems);
		
		
	}

	public void getGrandchildrenMenuOptions(String str, String string, String[] stringarray) {
		// Mouse over to main menu
		WebElement k = cdriver.findElement(By.id(str));
		a.moveToElement(k).perform();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Mouse over the element to make the elements visible
		WebElement l = cdriver.findElement(By.id(string));
		a.moveToElement(l).perform();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Capturing all childrens of submenu
		WebElement mainOrg = cdriver.findElement(By.xpath("//a[@id='" + string + "']//parent::li//descendant::ul"));
		List<WebElement> mainOrgOption = mainOrg.findElements(By.tagName("a"));

		System.out.println("\n" + "submenu - below grandchildren menu found " +
		string);

		for (int i = 0; i < mainOrgOption.size(); i++) {
			locArrayToStoreMenuItems.add(mainOrgOption.get(i).getText());
			// System.out.println(mainOrgOption.get(i).getText());
		}

		Assert.assertTrue(Arrays.equals(locArrayToStoreMenuItems.toArray(), stringarray));
		locArrayToStoreMenuItems.clear();
	}

}
