
Feature: Login functionality

#@LoginFunc
Scenario Outline: Enter the credentials "<uName>" , "<pWord>" on "<bName>"  and check if login is "<status>"
Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And user should be able to logout after "<status>" status

Examples:
|bName|uName|pWord|status|
|chrome|admin|admin123|successful|
|chrome|Admin|admin1234|unsuccessful|
|chrome||admin1234|unsuccessful|
|chrome|Admin||unsuccessful|
|chrome|||unsuccessful|
#|edge|admin|admin123|successful|
#|edge|Admin|admin1234|unsuccessful|

#@LoginFunc
Scenario Outline: Validate all available webelements
Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And User should be able to locate "<add>" button
And user should be navigate to "<url>"
And all elements are displayed correctly

Examples:
|bName|uName|pWord|status|url|
|edge|admin|admin123|successful|saveSystemUser|

#@LoginFunc
Scenario Outline: Add user validations
Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And User should be able to locate "<add>" button
And user should be navigate to "<url>"
And click on Save without entering any values
And click on cancel without entering any values

Examples:
|bName|uName|pWord|status|url|
|edge|admin|admin123|successful|saveSystemUser|


@LoginFunc
Scenario Outline: Add Field validations
Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And User should be able to locate "<add>" button
And user should be navigate to "<url>"
And user tried to enter the name which is not in the list
And user tried to enter the name which exists in the list
And user name selected in user name field
And password "<password>" entered in both password field
And click on "save" button
And verify sucessful navigation to "<redUrl>"


Examples:
|bName|uName|pWord|status|url|password|redUrl|
|edge|admin|admin123|successful|saveSystemUser|Password12345|https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers|
|edge|admin|admin123|successful|saveSystemUser|Password12345|https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers|
|edge|admin|admin123|successful|saveSystemUser|Password12345|https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers|
|edge|admin|admin123|successful|saveSystemUser|Password12345|https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers|


