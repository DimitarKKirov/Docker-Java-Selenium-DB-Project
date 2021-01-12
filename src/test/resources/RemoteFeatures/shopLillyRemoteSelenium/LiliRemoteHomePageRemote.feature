@Lilly @Show
Feature: homepage

  #1
  Scenario: navigating to login page and log in
    Given open Home Page "https://shop.lillydrogerie.bg/"
    When  click on Вход button
    Then you are redirected to the login page of Lilly website
