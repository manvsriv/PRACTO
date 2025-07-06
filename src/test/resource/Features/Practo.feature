
Feature: To validate the different functionalities of Practo Find Doctor Page

Background:
    Given User is on Practo HomePage. 
    
#@Scenario1
#Scenario: Validate the visibility of Practo Case Studies Page
#When user clicks Find Doctors near you button
#And clicks on Security and Help dropdown menu
#And clicks on help
#Then Practo help page should appear
#And clicks on Practo Case Studies
#Then Practo Case Studies Page appears.

#@Scenario2
#Scenario: Validate the visibility of Practo Github page
#When user clicks Find Doctors near you button on homepage
#And clicks Find Doctors near you buttonscrolls to the bottom of the page
#And clicks on the Github button
#Then Practo Github Page opens.

#@Scenario3
#Scenario: Validate the Healthy Eating Page
#When user clicks on the module button
#And clicks on Read Articles button
#And clicks on Healthy Eating option
#Then Articles on Healthy Eating appear on a page
#And user navigates back to the module page

@Scenario4
Scenario Outline: Validate the page for Booking a Surgery Appointment
When user clicks on the module page
And clicks on the Surgeries popup
And scrolls down and clicks Cataract option
And enters the "<name>" and "<phnumber>" 
Then validate the Book Appointment button

    Examples: 
      | name          | phnumber     |
      | 10            |     11       |
      | 20            |     21       |