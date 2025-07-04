
Feature: To validate the different functionalities of Practo Find Doctor Page

Background:
    Given User is on Practo HomePage. 
    
@practocasestudies
Scenario: Validate the visibility of Practo Case Studies Page
When user clicks Find Doctors near you button
And clicks on Security and Help dropdown menu
And clicks on help
Then Practo help page should appear
And clicks on Practo Case Studies
Then Practo Case Studies Page appears.

@PractoGithubPage
Scenario: Validate the visibility of Practo Github page
When user clicks Find Doctors near you button on homepage
And clicks Find Doctors near you buttonscrolls to the bottom of the page
And clicks on the Github button
Then Practo Github Page opens.