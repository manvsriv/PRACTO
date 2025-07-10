Feature:Practo Video Consult Module

Backgroud:
Given User has launched the browser
And User is on the Practo homepage

#Scenario-I
@ConsultNowPositive
Scenario: Verify Consult Now button is clickable and open Consultation form
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
Then Consultation form should be displayed successfully

#Scenario-II
@NewMobileOTPFormValidation
#This scenario verifies that entering a new mobile number
Scenario: Verify new mobile number 
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
And User enters symptom "<SYMPTOM>" in the symptom input field
And User selects speciality Pediatrics from the list
And User scrolls to mobile number input
And User enters new mobile number "<MOBILE_NUMBER>"
Then Continue button is active

Examples:
|SYMPTOM |MOBILE_NUMBER | 
|10 	     |11  	          |



# Scenario-III
@InvalidSymptomValidation
Scenario: Verify Continue button is inactive when symptom is less than 4 characters
  When User clicks on Video Consult link from homepage
  And User Clicks on Consult Now button on Video Consult Page
  And User enters invalid symptom from properties
  Then Continue button should be inactive
  
  
#Scenario-IV
@LinkedInVisibility
Scenario: Validate the visibility of Practo LinkedIn page
When User clicks on Video Consult link from homepage
And User scrolls to the bottom of the page
And User clicks on the LinkedIn button
Then Practo LinkedIn page should open in a new tab

#Scenario-V
@LogoRedirection
Scenario: Verify redirection to homepage on Practo logo click
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
And User clicks on the Practo logo
Then User should be redirected to the Practo homepage



 

  
  
 

 
 