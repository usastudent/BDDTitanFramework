@completeTest
Feature: Retail

  #Background keyword in cucumber
  # any steps that are repeated at the begining of each scenario and
  # scenario Outline and they are exactly the same steps for all scenario
  # and scenario outline in the same feature can be placed under Background keyword
  @RegisterTest
  Scenario: Register to Test environment
    Given User is on retail Website
    When User click on myAccount
    And User click on Register Option
    And User fill Personal Details with below information
      | firstName | lastName | email                | telephone  | password | passwordConfirm | subscribe |
      | Alex      | White    | a.white3@tekschool.us | 2021012233 | test123  | test123         | yes       |
    And User click on privacyPolicy
    And User click on ContinueButton
    Then User should see a success message 'Your Account Has Been Created!'
