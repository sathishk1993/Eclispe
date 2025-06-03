Feature: Complete the Regrestion process

Scenario: Add the registration form in WebTable
	Given User clicks on WebTable
	When User clicks on Add button
	|FirstName				|	Spiderman				|
	|LastName				|	Hulk						|
	|Email						|spidy@gmail.com	|
	|Age							|31								|
	|Salary						|34000						|
	|Department				|Physics					|
	Then User fills the form and submits