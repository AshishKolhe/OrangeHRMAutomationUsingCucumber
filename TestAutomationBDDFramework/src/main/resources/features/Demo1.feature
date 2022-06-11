@demo1features
Feature: Demo1 features

@ImageLinkValidation
Scenario Outline: Validate using browser "chrome"
Given user navigates to "chrome"
When user clicks on "<linkName>"
Then verify the title displayed correctly

Examples:
|linkName|
|Images|

@ImageLinkValidation
Scenario Outline: Validate using browser "edge"
Given user navigates to "edge"
When user clicks on "<linkName>"
Then verify the title displayed correctly

Examples:
|linkName|
|Images|

@ImageLinkValidation
Scenario Outline: Validate using browser "firefox"
Given user navigates to "firefox"
When user clicks on "<linkName>"
Then verify the title displayed correctly

Examples:
|linkName|
|Images|