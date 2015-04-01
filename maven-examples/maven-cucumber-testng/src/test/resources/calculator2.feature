Feature: Add two negative numbers
	As a user
	I want to use the calculator for adding negative numbers
	So that I don't need to us my brain
  
	Scenario Outline: Add two negative numbers
	    Given I have a calculator
	    When I add <firstnumber> and <secondNumber>
	    Then the result should be <result>
	    
	    Examples:
			| firstnumber	| secondNumber		| result	|
			| -1			| -1				| -2		|
			| -2			| -2				| -4		|
			| -4			| -4				| -8		|
			| -8			| -8				| -16		|
			| -16			| -16				| -32		|
			| -32			| -32				| -64		|
			| -64			| -64				| -128		|
			| -128			| -128				| -256		|
			| -256			| -256				| -512		|