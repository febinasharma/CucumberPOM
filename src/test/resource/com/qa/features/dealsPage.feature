@tag
Feature: Deals Feature
  
  @tag1
  Scenario Outline: Create New Deals
    Given User is logged into the application and is on the Home Page
    When User is on the New Deals Page
    Then User clicks on New Deals from the menu
    Then User enters new deals details <compName>, <priContact>,<closeDate>
       

    Examples: 
      | compName  | priContact |closeDate  |
      | Lindt | Meeka 	|		8-8-2025 |
      | Telas | Ben 		| 	11-11-2025 |
      
