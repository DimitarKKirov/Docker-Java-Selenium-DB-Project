@Show
Feature: comparing databases data

  Scenario: compare all tables data from MySql and Oracle

    Given user extracts the data from DB Mysql
    And the data from Oracle DB
    When the user compares the data
    Then the data is equal


