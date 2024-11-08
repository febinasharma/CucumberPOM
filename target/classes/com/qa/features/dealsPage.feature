@dp
Feature: Deals Feature
@dp-tc01 @smoke
	Scenario: Verify is user is able to navigate to Deals Page from the Home Page
		Given User is logged into the application and is on the Home Page
		When User clicks on Deals from the  Menu option
		Then User is navigated to Deals page
  
  @dp-tc02 @regression
  Scenario Outline: Verify if user is able to Create New Deals
		Given User is logged into the application and is on the Home Page
	  When User clicks on New Deals from the Deals menu
    Then User enters new deals details <compName>, <priContact>,<closeDate>
       

    Examples: 
      | compName  | priContact |closeDate  |
      | Lindt | Meeka 	|		8-8-2025 |
      | Telas | Ben 		| 	11-11-2025 |
      
   @dp-tc03
   Scenario: Verify deals that are closed
   Given User is logged into the application and is on the Home Page
   When User clicks on Full Form Search from Deals menu option
   And User clicks on Closed Status radio button
   And User clicks on Search Deals button
   Then All the Closed deals are displayed
   
      
