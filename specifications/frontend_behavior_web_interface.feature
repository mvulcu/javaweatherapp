Feature: User interface for retrieving weather information

  Narrative:
  As a user
  I want a simple and intuitive interface
  So that I can easily get weather updates for my city.

  Acceptance Criteria:

  Scenario 1: User enters a valid city name
    Given the user is on the main page of the weather application
    When they enter "Stockholm" into the city input field and submit
    Then the frontend should display a results page with weather details for Stockholm.

  Scenario 2: User searches for a city that does not exist
    Given the user is on the main page of the weather application
    When they enter "Atlantis" into the city input field and submit
    Then the frontend should display an error page stating the city was not found.

  Scenario 3: User submits an empty search
    Given the user is on the main page of the weather application
    When they submit the search without entering a city name
    Then the frontend should display an error page stating the city was not found.

  Scenario 4: User submits an incorrect city name
    Given the user is on the main page of the weather application
    When they enter an invalid city name and submit the form
    Then the frontend should display an error page stating the city was not found.