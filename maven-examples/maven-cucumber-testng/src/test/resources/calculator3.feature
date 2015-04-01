Feature: Add two negative numbers
	As a user
	I want to use the calculator for adding negative numbers
	So that I don't need to us my brain
  
	Scenario: Add two negative numbers
	    Given I have a calculator
	    When I add two numbers:
			| 1				| 1				|
			| 2				| 2				|
			| 4				| 4				|
			| 8				| 8				|
			| 16			| 16			|
			| 32			| 32			|
			| 64			| 64			|
			| 128			| 128			|
			| 256			| 256			|
	    Then the result should be:
			| 2			|
			| 4			|
			| 8			|
			| 16		|
			| 32		|
			| 64		|
			| 128		|
			| 256		|
			| 512		|