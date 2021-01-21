@Show
Feature: search

  Background:
    Given the user is on in "https://www.emag.bg/homepage?ref=emag_CMP-26580_emagia-05-27-12-2020"

  Scenario: search for item
    When user enters search criteria "Harry"
    Then the user can see the results "72 резултати, открити за:"