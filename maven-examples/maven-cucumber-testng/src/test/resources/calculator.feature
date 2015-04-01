Feature: Add two numbers
	As a user
	I want to use the calculator for adding numbers
	So that I don't need to us my brain
  
	Scenario Outline: Add two numbers
	    Given I have a calculator
	    When I add <firstnumber> and <secondNumber>
	    Then the result should be <result>
	    
	    Examples:
			| firstnumber	| secondNumber		| result	|
			| 1				| 1					| 2			|
			| 3				| 3					| 6			|