Feature: Automation Scenarios

@functional
Scenario: Verify translated Text from German to Spanish
	Given Application is opened and on Home Page
	When User select source language
	And select required translated language
	And User type source text
	Then translated text should display

@functional
Scenario: Verify translated Text from Hindi to English
	Given Application is opened and on Home Page
	When User select source language
	And select required translated language 
	And User type source text
	Then user click on swap languages button
	And verify destination text

@functional
Scenario: Verify screen keyboard functionality
	Given Application is opened and on Home Page
	When User select source language
	When User type source text
	Then User click on clear source text link
	And User click on Keyboard and type Hi text
	