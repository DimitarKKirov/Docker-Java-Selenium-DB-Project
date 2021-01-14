@Show
Feature: Login page

  Scenario Outline: user is logged in with correct credentials
    Given the user is on the "<Login>" page
    When user enters the correct "<username>" and "<password>"
    And clicks on button Вход
    Then user is successfully logged in
    Examples:
      | username                     | password    | Login                                                                                                  |
      | Dimitar.testing.bg@gmail.com | iskamneshto | https://shop.lillydrogerie.bg/customer/account/login/referer/aHR0cHM6Ly9zaG9wLmxpbGx5ZHJvZ2VyaWUuYmcv/ |


