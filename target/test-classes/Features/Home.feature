@completeTest
Feature: Retail Test Environment

  # Every feature starts with word Feature: <Name of Feature file>
  # Every feature file has extension .feature and it is all lower case
  # Every Test case is a scenario in feature file
  # Each scenario starts with word Scenario: <Name of the Scenario>
  # Each Scenario starts with Gherkin Keywords
  # Given When And Then
  @login
  Scenario: login to Test Environment
    Given User is on retail Website
    When User click on myAccount
    And User click on Login option
    And User enter userName "tekstudent@gmail.com" and password "sacramento"
    And User click on login button
    Then User should be logged into myAccount page

  @smokeTest
  Scenario: login to Test Environment
    Given User is on retail Website
    When User click on myAccount
    And User click on Login option
    And User enter userName "tekstudent@gmail.com" and password "sacramento"
    And User click on login button
    Then User should be logged into myAccount page

  @Regression
  Scenario: login to Test Environment
    Given User is on retail Website
    When User click on myAccount
    And User click on Login option
    And User enter userName "tekstudent@gmail.com" and password "sacramento"
    And User click on login button
    Then User should be logged into myAccount page

  @outline
  Scenario Outline: login with multiple users
    Given User is on retail Website
    When User click on myAccount
    And User click on Login option
    And User enter userName "<userName>" and password "<password>"
    And User click on login button
    Then User should be logged into myAccount page

    Examples: 
      | userName             | password   |
      | tekstudent@gmail.com | sacramento |
      | testtek@tekschool.us |     123456 |
      | tekstudent@gmail.com | sacramento |

  @end
  Scenario: login to Test Environment
    Given User is on retail Website
    When User click on myAccount
    And User click on Login option
    And User enter userName "tekstudent@gmail.com" and password "sacramento"
    And User click on login button
    Then User should be logged into myAccount page
