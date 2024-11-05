Feature: Login function
  Scenario: user cant register without confirming password
    Given user open browser
    And user Open website URL
    When user click create account
    And user enter firstname
    And user enter lastname
    And user enter valid email
    And user enter password
    And user leave confirm password empty
    And user click on submit
    Then user get required emty field message
  Scenario: user cant register with different password
    Given user open browser
    And user Open website URL
    When user click create account
    And user enter firstname
    And user enter lastname
    And user enter valid email
    And user enter password
    And user enter different confirmation password
    And user click on submit
    Then user get enter confirmed password
  Scenario: user can register
    Given user open browser
    And user Open website URL
    When user click create account
    And user enter attached data
    And user click on submit
    Then User get directed to account
    And user get account data


