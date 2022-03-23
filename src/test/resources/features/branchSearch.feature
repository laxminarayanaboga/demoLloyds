Feature: Search for a branch on Lloyds page 

Scenario Outline: As a user, I should be search for a branch on the Lloyds page 
	Given I access the Lloyds home page 
	When I click on Branch Finder 
	And search for "<searchWord>" 
	And access the last search result 
	Then I should see branch page with "<branchName>", "<branchAddress>", "<daysTheBranchIsClosed>" 
	Examples: 
		|searchWord|branchName|branchAddress|daysTheBranchIsClosed|
		|Halifax|Keighley|54 North Street Keighley BD21 3SJ|Tuesday,Saturday,Sunday|
		
		