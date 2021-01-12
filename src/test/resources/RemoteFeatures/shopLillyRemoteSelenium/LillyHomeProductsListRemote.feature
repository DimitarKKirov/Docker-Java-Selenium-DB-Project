@Show
Feature: shopping

  Scenario Outline: user goes to Home Products from the left menu
    Given the user is on the "<home page>"
    And the user is logged in with "<email>" and "<pass>"
    When the user clicks Home products from the left had menu
    Then the user is redirected to the shop list with the corresponding items
    Examples:
      | home page                      | email                        | pass        |
      | https://shop.lillydrogerie.bg/ | Dimitar.testing.bg@gmail.com | iskamneshto |


  Scenario: Adding items to the shopping cart and opening the shopping cart
    Given user is in Home products "https://shop.lillydrogerie.bg/"
    And the user clicks Home products from the left had menu
    And add items to the basket
    And the user clicks the basket
    When the total price is calculated correctly for the items in the basket
    Then the user is redirected to the shopping cart


