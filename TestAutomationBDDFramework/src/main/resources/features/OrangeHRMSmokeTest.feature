Feature: Smoke test menu bar

@smoketest
Scenario Outline: Enter the credentials "<uName>" , "<pWord>" on "<bName>"  and check if login is "<status>"

Given user navigates to "<bName>"
When enter user name as "<uName>" and password as "<pWord>"
Then user should be able to login "<status>"
And user should be able to see all main menu options
And user should be able to see all sub menu items for "<submenuoption>" menu

Examples: 
|bName|uName|pWord|status|submenuoption|
|chrome|admin|admin123|successful|admin|