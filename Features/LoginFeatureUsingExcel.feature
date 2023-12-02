Feature: Login with valid crediantals

  @sanity
  Scenario Outline: Successfully login with crediantals
    Given User opens browser "chrome"
    And User provides URL "URL"
    When User navigates to my accountant menu
    And User clicks on my account
    And User clicks on login
    Then User navigates to my account page by providing user details "<row_num>"

    Examples: 
      | row_num |
      |       1 |
      |       2 |
      |       3 |
