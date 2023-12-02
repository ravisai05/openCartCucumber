Feature: Login  crediantals

  @sanity
  Scenario Outline: Successfully login with crediantals
    Given User opens browser "chrome"
    And User provides URL "URL"
    When User navigates to my accountant menu
    And User clicks on my account
    And User clicks on login
    And User provides email as "<email>" and Password as "<password>"
    And click on Login
    Then User navigates to my account page"<result>"

    Examples: 
      | email               | password         | result  |
      | YRHlpUA@gmail.com   | XfKNnLt@)!       | valid   |
      | acb@gmail.com       | XfKNnLt@)!111111 | invalid |
      | YRHlpUA@gmail11.com | XfKNnLt@)!       | invalid |
