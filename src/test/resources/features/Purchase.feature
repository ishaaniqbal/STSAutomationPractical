Feature: Item purchase functionality

  Scenario: Successful item purchase
    Given I am logged in to the application
    When I add the product to the cart
    And I proceed to checkout
    Then I should see the order confirmation message
    Then I Close the browser
