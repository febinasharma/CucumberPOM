Feature: HomePage Feature

  Scenario: Verify if user can login and land on the Home Page
    Given User opens the browser and enter the url
    When User is on the login page of the application
    Then User enters valid credentials and logs into appilcation
    Then User is navigated to Home Page
    
	Scenario: Verify if the user can access Contacts Menu option
   	Given User opens the browser and enter the url
   	And User is on the login page of the application
   	And User enters valid credentials and logs into appilcation
   	And User is navigated to Home Page
   	When User clicks on the Contacts menu option
   	Then User is on the Contacts Page

   	


