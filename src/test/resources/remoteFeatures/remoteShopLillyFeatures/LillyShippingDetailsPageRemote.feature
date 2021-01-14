@Show
Feature: ordering items from the basket

  Scenario Outline: Preparing for shipment
    Given the user is in Home products "https://shop.lillydrogerie.bg/"
    And he clicks Home products from the left had menu
    And add items to the user basket
    And opens the basket
    When and clicks checkout
    And user fill the necessary Data "<First Name>","<Last Name>","<Phone Number>","<City>","<email>" and "<ShippingAddress>"
    And pres submit button
    Then the user is redirected to the payment page
    Examples:
      | First Name | Last Name | Phone Number | City  | email      | ShippingAddress |
      | Dimitar    | Kirov     | 0987654534   | Sofia | abv@abv.bg | Jerusalim       |

