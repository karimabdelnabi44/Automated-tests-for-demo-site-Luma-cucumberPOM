Feature: user can login
  Scenario: user login successfully
   Given user Open browser chrome
    And user Open website url
    And user click sign in
    When user enter login data
    Then User get directed to Profile
    And confirm account information