Feature: Retrieve the weather for a specified city via API

  Narrative:
  As a backend service
  I want to be able to process requests for weather data
  So that I can provide accurate weather information to the frontend.

  Scenario: City found in the weather database
    Given the backend has received an API request for "Stockholm"
    When the weather service processes the request
    Then the backend should return a JSON with the weather details for Stockholm.

  Scenario: City not found in the weather database
    Given the backend has received an API request for "Atlantis"
    When the weather service processes the request
    Then the backend should return an error message stating the city was not found.

  Scenario: Invalid or empty API request received
    Given the backend has received an incorrect or empty API request
    When the weather service attempts to process the request
    Then the backend should return an error message stating the request was invalid.
