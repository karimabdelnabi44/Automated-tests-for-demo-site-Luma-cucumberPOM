Feature: check products prise in $
  Scenario: check products prises in $
    Given users open new chrome browser
    And user go to url hot teller section
    And user check items prices in usd
  Scenario: user can add to cart successfully
    Given users open new chrome browser
    And user go to url hot teller section
    And user check add to cart appears
  Scenario: user add to cart and cart count successfully
    Given users open new chrome browser
    And user go to url hot teller section
    And user choose product
    And user choose size
    And user choose color
    When user click add to cart
    Then cart count is updated
