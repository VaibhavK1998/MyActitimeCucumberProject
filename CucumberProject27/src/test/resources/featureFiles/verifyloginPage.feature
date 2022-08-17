Feature: Login page feature


  Scenario: validate Login page
    Given User is on login page
    Then Username field should be display
    And Password field should be dispay
    And Login field should be display
    And Keep me login checkbox should be display
    And Logo should be display
    And Logolabel should be display
    And Header label should be display
    And Actitime link should be display
    And Licence link should be display

  Scenario Outline: Validate Login actitime succesfully
    Given User is on login page
    When User enter username as <username>
    And User enter password as <password>  
    And Click login button
    Then Dashboard page title sould be display as "actiTIME - Enter Time-Track 
  Examples:
  |username|password|
  |"admin"|"manager1"|
  |"adminra"|"manager"|
  |"1admin"|"mangers"|
  
  Scenario: validate invalid login
    Given User is on login page
    When User enter username
    And User enter password
    And Click login button
    Then Enter correct username and password msg should be display
