Feature: Create new contacts

  Scenario Outline: Add new contacts
    Given User is logged into the application
    When User is on the contacts page
    Then User clicks on New Contacts from the menu
    Then User enters new contact details <title>, <firstname>, <lastname>, <companyname>
    

    Examples: 
      | title | firstname | lastname | companyname |
      | Mr.   | Basil     | Arthur   | Dell        |
      | Miss | Dean      | Amy      | Bell        |
