Feature: getting heartbeat
  In order to check if the application server still alive
  As a client
  I want to be able to request a beat

  Rules:
  - the beat must return the sent token
  - the beat must return a timestamp

  Scenario: without invalid token
    Given an invalid token
    When beat is requested
    Then a <400> request status is returned

  Scenario: the token
    Given a token
    When beat is requested
    Then the token is returned
    And a <200> request status is returned

  Scenario: the timestamp
    Given a token
    When beat is requested
    Then a timestamp is returned
    And a <200> request status is returned

