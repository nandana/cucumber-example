Feature: Sorting a list of integers
	In order to save my time finding a give number
	As a person who have many numerical lists
	I want to sort my lists
	
  Background:
    Given a list of integers:
      | 76  |
      | 31  |
      | 25  |
      | 57  |
      | 19  |
      | 62  |
      | 48  |	
	

  Scenario: Sort a list ascending
    The integers should be should be listed in numerical ascending order

    When I sort that list ascending
    Then it should look like:
      | 19  |
      | 25  |
      | 31  |
      | 48  |
      | 57  |
      | 62  |
      | 76  |
      
   Scenario: Sort a list descending
    The integers should be should be listed in numerical descending order

    When I set the order is "descending"
    And I sort the list
    Then it should look like:
      | 76  |
      | 62  |
      | 57  |
      | 48  |
      | 31  |
      | 25  |
      | 19  |
