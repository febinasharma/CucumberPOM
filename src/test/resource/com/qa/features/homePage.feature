Feature: HomePage Feature

  Scenario: Verify if user can login and land on the Home Page
    Given User opens the browser and enter the url
    When User is on the login page of the application
    Then User enters valid credentials and logs into appilcation
    Then User is navigated to Home Page
    


