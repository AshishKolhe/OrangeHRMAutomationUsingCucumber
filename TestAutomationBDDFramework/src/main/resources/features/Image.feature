@ImageValidations
Feature: Validation of image tag

@searchFunctionality
Scenario Outline: Validation of search functionality
Given user navigates to "chrome"
When user clicks on "<linkName>"
And user clicks on search bar
Then verify search term is entered

Examples:
|linkName|
|Images|

