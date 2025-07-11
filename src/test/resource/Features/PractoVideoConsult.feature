Feature:Practo Video Consult Module

Backgroud:
Given User has launched the browser
And User is on the Practo homepage

#Scenario-I
@ConsultNow @Positive
Scenario: Verify Consult Now button is clickable and open Consultation form
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
Then Consultation form should be displayed successfully

#Scenario-II
@NewMobile @Positive
#This scenario verifies that entering a new mobile number
Scenario Outline: Verify new mobile number 
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
@InvalidSymptomValidation @Negative
Scenario: Verify Continue button is inactive when symptom is less than 4 characters
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
And User enters invalid symptom from properties
Then Continue button should be inactive
  
  
#Scenario-IV
@LinkedInVisibility @Positive
Scenario: Validate the visibility of Practo LinkedIn page
When User clicks on Video Consult link from homepage
And User scrolls to the bottom of the page
And User clicks on the LinkedIn button
Then Practo LinkedIn page should open in a new tab

#Scenario-V
@LogoRedirection @Positive
Scenario: Verify redirection to homepage on Practo logo click
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
And User clicks on the Practo logo
Then User should be redirected to the Practo homepage

#Scenario-VI
@VideoConsultDataTable @Positive
Scenario: Validate booking Video Consultation with valid credentials using DataTable
When User clicks on Video Consult link from homepage
And User Clicks on Consult Now button on Video Consult Page
And enters the VALID symptom and phonenumber using Data Table
      | Credentials.xlsx |
Then Continue button is active


 

  
  
 

 
 