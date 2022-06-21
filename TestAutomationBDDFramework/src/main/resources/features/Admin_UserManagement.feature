Feature: User management functionalities under admin -> user management -> user

@admin
Scenario Outline: Enter the credentials "<uName>" , "<pWord>" on "<bName>"  and check if login is "<status>"
Given user navigates to "<bName>"
And enter user name as "<uName>" and password as "<pWord>"
And user should be able to login "<status>"
And user should navigate to admin "<admin>" menu and then to user management "<userMan>" menu
And verify if user is user successfully navigated
Then Verify if all the fields are displayed
And Verify if the table is displayed and populated with values

Examples:
|bName|uName|pWord|status|admin|userMan|
|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|

	@admin
	Scenario Outline: Admin -> user management search employees with "<userRole>"  Role
	Given user navigates to "<bName>"
	And enter user name as "<uName>" and password as "<pWord>"
	And user should be able to login "<status>"
	And user should navigate to admin "<admin>" menu and then to user management "<userMan>" menu
	And verify if user is user successfully navigated 
	And user select "<userRole>" from User role dropdown
	Then Verify only employees with "<userRole>" role is displayed
	
		Examples:
	|bName|uName|pWord|status|admin|userMan|userRole|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|Admin|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|ESS|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|All|	
	
	@admin
	Scenario Outline: Admin -> user management search employees with "<userStatus>"  status
	Given user navigates to "<bName>"
	And enter user name as "<uName>" and password as "<pWord>"
	And user should be able to login "<status>"
	And user should navigate to admin "<admin>" menu and then to user management "<userMan>" menu
	And verify if user is user successfully navigated 
	And user select "<userStatus>" from user status dropdown
	Then Verify only employees with Status "<userStatus>" status is displayed
		Examples:
	|bName|uName|pWord|status|admin|userMan|userStatus|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|Enabled|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|Disabled|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|All|	
	
	@admin
	Scenario Outline: Admin -> user management search employees
	Given user navigates to "<bName>"
	And enter user name as "<uName>" and password as "<pWord>"
	And user should be able to login "<status>"
	And user should navigate to admin "<admin>" menu and then to user management "<userMan>" menu
	And verify if user is user successfully navigated
	Then user selects Employee name and click on search
	And verify only 1 row with selected employee should be displayed
	And verify that after clicking on Reset the search menu selection should show default values 
	
		Examples:
	|bName|uName|pWord|status|admin|userMan|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|
		
	@admin
	Scenario Outline: Admin -> user management delete and delete cancel employee
	Given user navigates to "<bName>"
	And enter user name as "<uName>" and password as "<pWord>"
	And user should be able to login "<status>"
	And user should navigate to admin "<admin>" menu and then to user management "<userMan>" menu
	And verify if user is user successfully navigated
	And user selects an employee to delete 
	Then deletion shoulb be successful
	And user selects an employee to delete 
	And user cancels the deletion
	And Employe should be displayed in the table
	
	Examples:
	|bName|uName|pWord|status|admin|userMan|
	|chrome|admin|admin123|successful|menu_admin_viewAdminModule|menu_admin_UserManagement|