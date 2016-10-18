Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    And I click on the Contact link
    And I input the following details
      | name    | j.Bloggs                                  |
      | email   | j.Bloggs@qaworks.com                      |
      | message | please contact me I want to find out more |
    Then QAWorks will be able to contact me
 