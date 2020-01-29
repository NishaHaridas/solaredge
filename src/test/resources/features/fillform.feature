Feature: Basic form fill

  As a user I want to fill the basic form and validate the successfully submitted message.

  @web
  Scenario: To check if user can fill the form and validate the message
    Given a web "Chrome" browser is on the page "https://www.solaredge.com/uk//contact/qa_automation_test"
    When I fill in "yourname" with "newcucumbertestuser"
    And I fill in "youremailaddress" with "cucumbertestuser@gmail.com"
    And I fill in "subject" with "Cucumber QA Automation Test"
    And I fill in "message" with "A sample QA Automation Test"
    And I select "country" with "United States"
    And I fill in "firstname" with "cucumber test"
    And I fill in "lastname" with "cucumber Client"
    And I fill in "company" with "test Client company"
    And I fill in "streetaddress" with "test Client address"
    And I fill in "city" with "test City"
    And I select "state" with "New York"
    And I fill in "zipcode" with "10082"
    And I click on the Send message button
    Then the form is successfully submitted