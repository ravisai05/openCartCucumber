Feature: Login with valid crediantals

  @sanity
  Scenario: Successfully login with crediantals
    Given User opens browser "chrome"
    And User provides URL "URL"
    When User navigates to my accountant menu
    And User clicks on my account
    And User clicks on login
    And User provides email as "YRHlpUA@gmail.com" and Password as "XfKNnLt@)!"
    And click on Login
    Then User navigates to my account page "valid"
