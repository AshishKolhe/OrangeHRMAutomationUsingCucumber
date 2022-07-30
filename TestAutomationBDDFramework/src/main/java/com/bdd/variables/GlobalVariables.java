package com.bdd.variables;

import static com.bdd.variables.GlobalVariables.cdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GlobalVariables {
	
	public static WebDriver cdriver;
	
	
	
	
		//Smoke test variables
		public static String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		public static String[] gloMainMenuOption = {"Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Buzz"};
		
		//admin sub menu options names
		public static String[] gloAdminUserManagementSubMenuItems = {"Users"};
		public static String[] gloAdminJobSubMenuItems = {"Job Titles","Pay Grades","Employment Status","Job Categories","Work Shifts"};
		public static String[] gloAdminOrganizationSubMenuItems = {"General Information","Locations","Structure"};
		public static String[] gloAdminQualificationsSubMenuItems = {"Skills","Education","Licenses","Languages","Memberships"};
		public static String[] gloAdminConfigurationSubMenuItems = {"Email Configuration","Email Subscriptions","Localization","Language Packages","Modules","Social Media Authentication","Register OAuth Client"};
		
		//PIM sub menu option names
		public static String[] gloPimConfigurationSubMenuItems = {"Optional Fields","Custom Fields","Data Import","Reporting Methods","Termination Reasons"};
		
		//Leave sub menu option names
		public static String[] gloLeaveEntitlementsSubMenuItems = {"Add Entitlements","Employee Entitlements","My Entitlements"};
		public static String[] gloLeaveReportsSubMenuItems = {"Leave Entitlements and Usage Report","My Leave Entitlements and Usage Report"};
		public static String[] gloLeaveConfigureSubMenuItems = {"Leave Period","Leave Types","Work Week","Holidays"};
		
		//Time sub menu option name
		public static String[] gloTimeTimesheetSubMenuItems = {"My Timesheets","Employee Timesheets"};
		public static String[] gloTimeAttendanceSubMenuItems = {"My Records","Punch In/Out", "Employee Records","Configuration"};
		public static String[] gloTimeReportSubMenuItems = {"Project Reports","Employee Reports","Attendance Summary"};
		public static String[] gloTimeProjectInfoSubMenuItems = {"Customers","Projects"};
		
		//Performance sub menu option name
		public static String[] gloPerformanceconfigureSubMenuItems = {"KPIs","Trackers"} ;
		public static String[] gloPerformanceManageReviewsSubMenuItems = {"Manage Reviews","My Reviews","Review List"} ;
		
		//Maintenance sub menu option
		public static String[] gloMaintenancePurgeRecordsSubMenuItems = {"Employee Records","Candidate Records"};
		
		//id's for all sub menu element
		
		public static String[] gloMainMenuItemsById = {"menu_admin_viewAdminModule","menu_pim_viewPimModule","menu_leave_viewLeaveModule","menu_time_viewTimeModule","menu_recruitment_viewRecruitmentModule","menu__Performance","menu_maintenance_purgeEmployee"};
		
		public static String[] gloAdminSubMenuItemsById = {"menu_admin_UserManagement","menu_admin_Job","menu_admin_Organization","menu_admin_Qualifications","menu_admin_Configuration","menu_admin_nationality","menu_admin_addTheme",};
		
		public static String[] gloPimSubMenuItemsById = {"menu_pim_Configuration","menu_pim_viewEmployeeList","menu_pim_addEmployee","menu_core_viewDefinedPredefinedReports"};
		
		public static String[] gloLeaveSubMenuItemsById = {"menu_leave_applyLeave","menu_leave_viewMyLeaveList","menu_leave_Entitlements","menu_leave_Reports","menu_leave_Configure","menu_leave_viewLeaveList","menu_leave_assignLeave"};
		
		public static String[] gloTimeSubMenuItemsById = {"menu_time_Timesheets","menu_attendance_Attendance","menu_time_Reports","menu_admin_ProjectInfo"};
		
		public static String[] gloRecruitmentSubMenuItemsById = {"menu_recruitment_viewCandidates","menu_recruitment_viewJobVacancy"};
		
		public static String[] gloPerformanceSubMenuItemsById = {"menu_performance_Configure","menu_performance_ManageReviews","menu_performance_viewMyPerformanceTrackerList","menu_performance_viewEmployeePerformanceTrackerList"};
		
		public static String[] gloMaintenanceSubMenuItemsById = {"menu_maintenance_purgeEmployee","menu_maintenance_purgeCandidateData"};
		
		
		public static String gloAdminMenuItems = "\"menu_admin_UserManagement\"";
		public static String gloJobMenuItems ="\"menu_pim_viewPimModule\"";
		public static String gloLeaveMenuItems ="\"menu_leave_viewLeaveModule\"";
		public static String gloTimeMenuItems ="\"menu_time_viewTimeModule\"";
		public static String gloRecruitmentMenuItems ="\"menu_recruitment_viewRecruitmentModule\"";
		
		
		public static String gloMyInfoMenuItems ="\"menu_pim_viewMyDetails\"";
		public static String gloPerformanceMenuItems ="\"menu__Performance\"";
		public static String gloDashboardMenuItems ="\"menu_dashboard_index\"";
		public static String gloDirectoryMenuItems ="\"menu_directory_viewDirectory\"";
		public static String gloMaintenanceMenuItems ="\"menu_maintenance_purgeEmployee\"";
		public static String gloBuzzMenuItems ="\"menu_buzz_viewBuzz\"";
		
				
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
		
		public static String[] gloAdminUserManagementElements = {"searchSystemUser_userName", "searchSystemUser_userType", "searchSystemUser_employeeName_empName", "searchSystemUser_status","searchBtn","resetBtn","btnAdd","btnDelete"}; 
		public static String[] gloAdminUserManagementTableHeaders = {"Username", "User Role", "Employee Name","Status"};

		public static String[] gloRandomName= {"Kasper Risner",	"Prynce Klingensmith",	"Meghna Normand",	"Milagros Godinez",	"Xia Holmgren",	"Serena Pace",	"Oryan Mcphail",	"Sheyla Fullerton",	"Corrina Blais",	"Ximena Delgado",	"Tova Talbott",	"Vanellope Choe",	"Anasofia Appel",	"Mei Cashman",	"Denver Ashby",	"Kaya Land",	"Mayrin Grow",	"Taleah Shinn",	"Domonic Klatt",	"Markayla Gist",	"Yulissa Maples",	"Chace Brunson",	"Demoni Krall",	"Rosa Pike",	"Kyree Swan",	"Sylus Morelli",	"Ziya Mix",	"Deondre Bushey",	"Dedrick Breeding",	"Rana Dryden",	"Arlo Craft",	"Lennox Lancaster",	"Deshaun Autry",	"Taylyn Friel",	"Brooke Haynes",	"Adlee Derr",	"Violett Godsey",	"Elise Moss",	"Ronnie Zack",	"Glenda Habib",	"Shaylin Boykins",	"Farhan Moniz",	"Matteo Lyons",	"Tilly Montiel",	"Jamaal Arguello",	"Jelani Shumaker",	"Yitzchok Farias",	"Rosalinda Fleck",	"Marcela Keeton",	"Indigo Graber"};

	}
