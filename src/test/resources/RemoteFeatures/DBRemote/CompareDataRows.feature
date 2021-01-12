@Show
Feature: check data rows are identical

  Scenario Outline:
    Given user extracts data from <row> of MySql Database
    And <rows> from Oracle Database
    Then the user compares the rows data and its the same
    Examples:
      | row | rows |
      | 1   | 1    |
      | 3   | 3    |
      | 5   | 5    |
      | 7   | 7    |
      | 9   | 9    |