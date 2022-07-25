Feature: PIM->Add employee validations

@PIM_addEmployee
Scenario Outline: Enter the credentials "<uName>" , "<pWord>" on "<bName>"  and check if login is "<status>"
Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And user navigates to PIM -> employee list tag
And user clicks on Add button
And user clicks on Save button without entering first name or last name
And User enters "<firstname>" and "<lastname>" 
And user uploads the photo
And capture assigned empid
And user clicks on Save button
And verify if new Employee is added
And close the driver

Examples:
|bName|uName|pWord|status|firstname|lastname|
|chrome|admin|admin123|successful|johnch|doech|
|edge|admin|admin123|successful|johnedge|doedge|
|firefox|admin|admin123|successful|johnff|doeff|