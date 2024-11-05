Feature: Wishlist Features
  Scenario: user able to add to wishlist
    Given user open new browser
    And user move to hot seller
    And user hover on BreathEasyTank
    When user click add to wishlist
    Then user get directed to log in page
    And user enter login email and pass
    And user directed to whishlist with product

  Scenario: guest cannot add to wishlist
      Given user open new browser
      And user move to hot seller
      And user hover on BreathEasyTank
      When user click add to wishlist
      Then user get directed to log in page



